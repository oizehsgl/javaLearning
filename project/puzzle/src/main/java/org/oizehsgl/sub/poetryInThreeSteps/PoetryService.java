package org.oizehsgl.sub.poetryInThreeSteps;

import lombok.SneakyThrows;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * poetryService
 *
 * @author oizehsgl
 * @since 4/12/23
 */
@Service
public class PoetryService {

    /**
     * 读csv
     *
     * @return {@link List}<{@link Poetry}>
     * @throws IOException ioexception
     * @apiNote 适用于小文件
     */
    public List<Poetry> readCsv() throws IOException {
        List<Poetry> poetryList = new ArrayList<>();
        InputStream inputStream = Objects.requireNonNull(this.getClass().getResourceAsStream("/poetry/sevenCharacter.csv"));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
        for (CSVRecord csvRecord : csvParser) {
            Poetry poetry = Poetry.builder()
                    .title(csvRecord.get(0))
                    .dynasty(csvRecord.get(1))
                    .author(csvRecord.get(2))
                    .genre(csvRecord.get(3))
                    .content(List.of(StringUtils.split(csvRecord.get(4), "，|。")))
                    .build();
            poetryList.add(poetry);
        }
        return poetryList;
    }

    /**
     * 得到pinyin2三重地图
     *
     * @return {@link Map}<{@link String}, {@link Triple}<{@link String}, {@link String}, {@link Poetry}>>
     * @throws IOException                           ioexception
     * @throws BadHanyuPinyinOutputFormatCombination 糟糕汉语拼音输出格式组合
     * @apiNote 适用于小文件
     */
    public MultiValueMap<String, Triple<String, String, Poetry>> getPinyin2TripleMap() throws IOException, BadHanyuPinyinOutputFormatCombination {
        List<Poetry> poetryList = readCsv();
        MultiValueMap<String, Triple<String, String, Poetry>> map = new LinkedMultiValueMap<>();
        for (Poetry poetry : poetryList) {
            for (String s : poetry.getContent()) {
                Set<String> pinyins = PinyinUtils.enZh2MultiPinyin(s);
                for (String pinyin : pinyins) {
                    String sortPinyin = PinyinUtils.sort(pinyin);
                    List<Triple<String, String, Poetry>> list = map.getOrDefault(sortPinyin, new ArrayList<>());
                    list.add(new ImmutableTriple<>(sortPinyin, pinyin, poetry));
                    map.put(sortPinyin, list);
                }
            }
        }
        return map;
    }

    /**
     * 读csv2诗歌然后谓词和消费者
     *
     * @param function 谓词
     * @param consumer 消费者
     * @throws IOException
     */
    @SneakyThrows
    public void readCsv2PoetryThenPredicateAndConsumer(Function<String, List<EmojiBrainstorm>> function, BiConsumer<Poetry, EmojiBrainstorm> consumer) throws IOException {
        Path path = Path.of(Objects.requireNonNull(this.getClass().getResource("/poetry/sevenCharacter.csv")).getPath());
        CSVParser csvRecords = CSVParser.parse(Files.newBufferedReader(path), CSVFormat.Builder.create().build());
        for (CSVRecord csvRecord : csvRecords) {
            Poetry poetry = Poetry.builder()
                    .title(csvRecord.get(0))
                    .dynasty(csvRecord.get(1))
                    .author(csvRecord.get(2))
                    .genre(csvRecord.get(3))
                    .content(List.of(StringUtils.split(csvRecord.get(4), "，|。")))
                    .build();
            for (String s : poetry.getContent()) {
                for (String py : PinyinUtils.enZh2MultiPinyin(s)) {
                    py = PinyinUtils.sort(py);
                    List<EmojiBrainstorm> emojiBrainstormList = function.apply(py);
                    if (ObjectUtils.isNotEmpty(emojiBrainstormList)) {
                        for (EmojiBrainstorm emojiBrainstorm : emojiBrainstormList) {
                            if (ObjectUtils.isNotEmpty(emojiBrainstorm.getExpressions())) {
                                consumer.accept(poetry, emojiBrainstorm);
                            }
                        }
                    }
                }
            }
        }
    }
}
