package org.oizehsgl.sub.poetryInThreeSteps;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * emojiBrainstormService
 *
 * @author oizehsgl
 * @since 4/13/23
 */
@Service
public class EmojiBrainstormService {
    /**
     * 存放成对的表情衍生的单词以及汉字拼音
     */
    static Map<Integer, Set<String>> map = new HashMap<>() {{
//        put(1, Stream.of(
//                "why", "how", "question", "unknown", "problem", "interrogation", "query", "doubt", "疑", "惑", "谜", "问", "猜", "何"
//        ).collect(Collectors.toSet()));
//        put(2, Stream.of(
//                "eye", "see", "look", "watch", "view", "sight", "看", "观", "望", "瞧", "赏", "瞄", "视", "窥", "瞥", "眼", "眸", "目", "睛", "瞟", "盯"
//        ).collect(Collectors.toSet()));
//        put(3, Stream.of(
//                "ghost", "spirit", "fetch", "soul", "spectre", "anima", "atman", "鬼", "灵", "怪"
//        ).collect(Collectors.toSet()));
//        put(4, Stream.of(
//                "car", "vehicle", "rook", "lathe", "castle", "车", "轨", "轮", "轧", "载", "拉"
//        ).collect(Collectors.toSet()));
//        put(5, Stream.of(
//                "silence", "tranquil", "mum", "mute", "quite", "寥", "谧", "嘘", "默", "噤", "缄", "静", "寂"
//        ).collect(Collectors.toSet()));
//        put(6, Stream.of(
//                "embrace", "hug", "enfold", "infold", "hold", "surround", "caress", "拥", "抱", "搂"
//        ).collect(Collectors.toSet()));
//        put(7, Stream.of(
//                "gun", "rifle", "firearm", "blunderbuss", "pistol", "peacemaker", "枪", "毙", "铳", "杀"
//        ).collect(Collectors.toSet()));
//
//        put(1, Stream.of(
//                "bu","步"
//        ).collect(Collectors.toSet()));
//        put(2, Stream.of(
//                "jin"
//        ).collect(Collectors.toSet()));
//        put(3, Stream.of(
//                "chang"
//        ).collect(Collectors.toSet()));
//        put(4, Stream.of(
//                "jiang"
//        ).collect(Collectors.toSet()));
//        put(5, Stream.of(
//                "gun"
//        ).collect(Collectors.toSet()));
//        put(6, Stream.of(
//                "gun"
//        ).collect(Collectors.toSet()));
//        put(7, Stream.of(
//                "lai"
//        ).collect(Collectors.toSet()));
        put(1, Stream.of(
                //"why","how", "疑", "惑", "谜", "问", "猜","晕","懵"
                "why", "how", "yi", "huo", "mi", "wen", "cai","yun","meng"
        ).collect(Collectors.toSet()));
        put(2, Stream.of(
                //"eye", "see", "look", "view", "看", "观", "望", "瞧", "赏", "瞄", "视", "窥", "瞥", "眼", "眸", "目", "睛", "瞟", "盯"
                "eye", "see", "look", "view", "kan", "guan", "wang", "qiao", "shang"
                //,
                //"miao", "shi", "kui", "pie", "yan", "mou", "mu", "jing", "piao", "ding"
        ).collect(Collectors.toSet()));
        put(3, Stream.of(
                //"atman","anima","soul", "鬼", "灵", "怪", "魑", "魅", "魍", "魉","妖","魔","怕","惊","恐"
                "atman","anima", "soul", "gui", "ling", "guai", "chi", "mei", "wang", "liang", "yao", "mo","pa","jing","kong"
        ).collect(Collectors.toSet()));
        put(4, Stream.of(
                //"taxi","lathe","car", "rook", "车", "轨", "轮", "轧", "载", "拉", "乘","开","驶","驾"
                "taxi","lathe","car", "rook", "che", "gui", "lun", "ya", "zai", "la", "cheng","kai","jia","shi"
        ).collect(Collectors.toSet()));
        put(5, Stream.of(
                // "mum", "mute", "quite", "寥", "谧", "嘘", "默", "噤", "缄", "静", "寂"
                "mum", "mute", "quite", "liao", "mi", "xu", "mo", "jin", "jian", "jing", "ji"
        ).collect(Collectors.toSet()));
        put(6, Stream.of(
                //"care","love", "enfold", "hug",  "hold", "拥", "抱","友","爱","慰"
               "care","love","enfold", "hug", "hold", "yong", "bao","you","ai","wei"
        ).collect(Collectors.toSet()));
        put(7, Stream.of(
                //"gun", "rifle", "pistol", "枪", "毙", "铳", "杀","恼","怒","气"
                "gun", "rifle", "pistol", "qiang", "bi", "chong", "sha","nao","nu","qi"
        ).collect(Collectors.toSet()));
    }};
    Map<String, Set<String>> cacheMap = new HashMap<>();

    /**
     * combination2拼音
     *
     * @return {@link Map}<{@link String}, {@link String}>
     * @throws BadHanyuPinyinOutputFormatCombination 糟糕汉语拼音输出格式组合
     */
    public MultiValueMap<String, EmojiBrainstorm> getCombination2Pinyin() throws BadHanyuPinyinOutputFormatCombination {
        MultiValueMap<String, EmojiBrainstorm> allExpressionMultiValueMap = new LinkedMultiValueMap<>();
        int size = 1;
        for (Set<String> value : map.values()) {
            size *= value.size();
        }
        for (String s1 : map.get(1)) {
            for (String s2 : map.get(2)) {
                for (String s3 : map.get(3)) {
                    for (String s4 : map.get(4)) {
                        for (String s5 : map.get(5)) {
                            for (String s6 : map.get(6)) {
                                for (String s7 : map.get(7)) {
                                    EmojiBrainstorm emojiBrainstorm = EmojiBrainstorm.builder().expressions(Arrays.asList(s1, s2, s3, s4, s5, s6, s7)).build();
                                    //Set<String> strings = descartes(convertOrCache(s1), convertOrCache(s2), convertOrCache(s3), convertOrCache(s4), convertOrCache(s5), convertOrCache(s6), convertOrCache(s7));
                                    //for (String string : strings) {
                                    //    allExpressionMultiValueMap.add(string, emojiBrainstorm);
                                    //}
                                    String string = String.format("%s%s%s%s%s%s%s", s1, s2, s3, s4, s5, s6, s7);
                                    string = PinyinUtils.sort(string);
                                    allExpressionMultiValueMap.add(string, emojiBrainstorm);
                                    System.out.printf("%10d / %-10d%n", allExpressionMultiValueMap.size(), size);
                                }
                            }
                        }
                    }
                }
            }
        }
        return allExpressionMultiValueMap;
    }

    /**
     * 转换或缓存
     *
     * @param word 词
     * @return {@link String}
     * @throws BadHanyuPinyinOutputFormatCombination 糟糕汉语拼音输出格式组合
     */
    private Set<String> convertOrCache(String word) throws BadHanyuPinyinOutputFormatCombination {
        if (cacheMap.containsKey(word)) {
            return cacheMap.get(word);
        }
        Set<String> pinyins = PinyinUtils.enZh2MultiPinyin(word);
        cacheMap.put(word, pinyins);
        return pinyins;
    }

    public static Set<String> descartes(Set<String>... lists) {
        Set<String> tempList = new HashSet<>();
        for (Set<String> list : lists) {
            if (tempList.isEmpty()) {
                tempList = list;
            } else {
                tempList = tempList.stream().flatMap(item -> list.stream().map(item2 -> item + item2)).collect(Collectors.toSet());
            }
        }
        return tempList.stream().map(PinyinUtils::sort).collect(Collectors.toSet());
    }

    /**
     * 笛卡儿积
     *
     * @param lists 列表
     * @return {@link List}<{@link List}<{@link T}>>
     */
    private <T> List<List<T>> cartesianProduct(List<T>... lists) {
        List<List<T>> product = new ArrayList<>();
        for (List<T> list : lists) {
            if (ObjectUtils.isEmpty(product)) {
                list.stream().map(Collections::singletonList).forEach(product::add);
            } else {
                product = product.stream().flatMap(e -> list.stream().map(e1 -> {
                            List<T> eCopy = new ArrayList<>(e);
                            eCopy.add(e1);
                            return eCopy;
                        })
                ).collect(Collectors.toList());
            }
        }
        return product;
    }
}