package org.oizehsgl.sub.poetryInThreeSteps;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
     */
    public List<Poetry> readCsv() throws IOException {
        List<Poetry> poetryList = new ArrayList<>();
        CSVParser csvParser = CSVFormat.DEFAULT.parse(new InputStreamReader(Objects.requireNonNull(this.getClass().getResourceAsStream("/poetry/sevenCharacter.csv"))));
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
     */
    public MultiValueMap<String, Triple<String, String, Poetry>> getPinyin2TripleMap() throws IOException, BadHanyuPinyinOutputFormatCombination {
        List<Poetry> poetryList = readCsv();
        MultiValueMap<String, Triple<String, String, Poetry>> map = new LinkedMultiValueMap<>();
        for (Poetry poetry : poetryList) {
            for (String s : poetry.getContent()) {
                String pinyin = PinyinUtils.enZh2Pinyin(s);
                String sortPinyin = PinyinUtils.sort(pinyin);
                List<Triple<String, String, Poetry>> list = map.getOrDefault(sortPinyin, new ArrayList<>());
                list.add(new ImmutableTriple<>(sortPinyin, pinyin, poetry));
                map.put(sortPinyin, list);
            }
        }
        return map;
    }
}
