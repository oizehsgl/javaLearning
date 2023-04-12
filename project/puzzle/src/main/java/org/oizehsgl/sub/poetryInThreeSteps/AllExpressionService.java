package org.oizehsgl.sub.poetryInThreeSteps;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * allExpressionService
 *
 * @author oizehsgl
 * @since 4/13/23
 */
@Service
public class AllExpressionService {
    Map<String, List<String>> cacheMap = new HashMap<>();

    /**
     * combination2拼音
     *
     * @return {@link Map}<{@link String}, {@link String}>
     * @throws BadHanyuPinyinOutputFormatCombination 糟糕汉语拼音输出格式组合
     */
    public Map<String, String> getCombination2Pinyin() throws BadHanyuPinyinOutputFormatCombination {
        Map<String, String> map = new HashMap<>();
        for (String s1 : AllExpression.map.get(1)) {
            for (String s2 : AllExpression.map.get(2)) {
                for (String s3 : AllExpression.map.get(3)) {
                    for (String s4 : AllExpression.map.get(4)) {
                        for (String s5 : AllExpression.map.get(5)) {
                            for (String s6 : AllExpression.map.get(6)) {
                                for (String s7 : AllExpression.map.get(7)) {
                                    String key = String.format("1:%s-2:%s-3:%s-4:%s-5:%s-6:%s-7:%s", s1, s2, s3, s4, s5, s6, s7);
                                    String value = String.format("%s%s%s%s%s%s%s", convertOrCache(s1), convertOrCache(s2), convertOrCache(s3), convertOrCache(s4), convertOrCache(s5), convertOrCache(s6), convertOrCache(s7));
                                    map.put(key, PinyinUtils.sort(value));
                                }
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    /**
     * 转换或缓存
     *
     * @param word 词
     * @return {@link String}
     * @throws BadHanyuPinyinOutputFormatCombination 糟糕汉语拼音输出格式组合
     */
    private List<String> convertOrCache(String word) throws BadHanyuPinyinOutputFormatCombination {
        if (cacheMap.containsKey(word)) {
            return cacheMap.get(word);
        }
        List<String> pinyins = PinyinUtils.enZh2MultiPinyin(word);
        cacheMap.put(word, pinyins);
        return pinyins;
    }
}