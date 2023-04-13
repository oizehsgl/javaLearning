package org.oizehsgl.sub;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.poetryInThreeSteps.EmojiBrainstorm;
import org.oizehsgl.sub.poetryInThreeSteps.EmojiBrainstormService;
import org.oizehsgl.sub.poetryInThreeSteps.Poetry;
import org.oizehsgl.sub.poetryInThreeSteps.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * poetryInThreeStepsTest
 *
 * @author oizehsgl
 * @since 4/12/23
 */
@SpringBootTest
public class PoetryInThreeStepTest {
    @Autowired
    private PoetryService poetryService;
    @Autowired
    private EmojiBrainstormService emojiBrainstormService;

    @Test
    public void testPoetryInThreeSteps() throws IOException, BadHanyuPinyinOutputFormatCombination {
        MultiValueMap<String, EmojiBrainstorm> allExpressionMultiValueMap = emojiBrainstormService.getCombination2Pinyin();
        MultiValueMap<String, Triple<String, String, Poetry>> map = new LinkedMultiValueMap<>();
        poetryService.readCsv2PoetryThenPredicateAndConsumer(string -> allExpressionMultiValueMap.get(string)
                , (poetry, emojiBrainstorm) -> {
                    System.out.println(poetry);
                    System.out.println(emojiBrainstorm);
                });
        for (Map.Entry<String, List<EmojiBrainstorm>> stringStringEntry : allExpressionMultiValueMap.entrySet()) {
            List<Triple<String, String, Poetry>> tripleList = null;
            if (Objects.nonNull(tripleList)) {
                map.put(stringStringEntry.getKey(), tripleList);
            }
        }

        System.out.printf("%n%n%n");
        map.entrySet().forEach(e -> {
            List<Triple<String, String, Poetry>> tripleList = e.getValue();
            for (Triple<String, String, Poetry> triple : tripleList) {
                System.out.printf("%s-->%s-->%s-->%s:%s%n", e.getKey(), triple.getLeft(), triple.getMiddle(), triple.getRight().getTitle(), triple.getRight().getContent());
            }
        });
        System.out.printf("%n%n%n");
    }
    @Test
    public void test(){
        MultiValueMap<Integer,Integer> map = new LinkedMultiValueMap<>();
        List<Integer> integers = map.get(1);
        List<Integer> list1 =new ArrayList<>();
        list1.add(1);
        map.put(1,list1 );
        if(integers==null){
            List<Integer> list =new ArrayList<>();
            list.add(1);
            map.put(1,list );
        }else {
            List<Integer> list =map.get(1);
            list.add(2);
            map.put(1, list);
        }
        System.out.println(map);
    }
}