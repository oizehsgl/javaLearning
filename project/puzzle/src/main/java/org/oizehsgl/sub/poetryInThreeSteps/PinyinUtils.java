package org.oizehsgl.sub.poetryInThreeSteps;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stringSortUtils
 *
 * @author oizehsgl
 * @since 4/12/23
 */
public class PinyinUtils {

    /**
     * 拼音格式
     */
    static HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();

    static {
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    /**
     * 排序
     *
     * @param pinyins 拼音
     * @return {@link String}
     */
    public static String sort(String pinyins) {
        char[] chars = pinyins.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * en zh2拼音
     *
     * @param words 单词
     * @return {@link String}
     */
    public static List<String> enZh2MultiPinyin(String words) throws BadHanyuPinyinOutputFormatCombination {
        List<String> stringList = new ArrayList<>();
        for (char c : words.toCharArray()) {
            if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                String[] strings = PinyinHelper.toHanyuPinyinStringArray(c, hanyuPinyinOutputFormat);
                stringList = stringList.stream().flatMap(e -> Arrays.stream(strings).map(e1 -> e + e1)).collect(Collectors.toList());
            } else {
                stringList = stringList.stream().flatMap(e -> Stream.of(c).map(e1 -> e + e1)).collect(Collectors.toList());
            }
        }
        return stringList;
    }
}