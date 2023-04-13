package org.oizehsgl.sub;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.tuple.Triple;
import org.oizehsgl.sub.poetryInThreeSteps.EmojiBrainstorm;
import org.oizehsgl.sub.poetryInThreeSteps.EmojiBrainstormService;
import org.oizehsgl.sub.poetryInThreeSteps.Poetry;
import org.oizehsgl.sub.poetryInThreeSteps.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    //@Test
    public void testPoetryInThreeSteps() throws IOException, BadHanyuPinyinOutputFormatCombination {
        MultiValueMap<String, EmojiBrainstorm> allExpressionMultiValueMap = emojiBrainstormService.getCombination2Pinyin();
        MultiValueMap<String, Triple<String, String, Poetry>> map = new LinkedMultiValueMap<>();
        poetryService.readCsv2PoetryThenPredicateAndConsumer(string -> allExpressionMultiValueMap.get(string)
                , (poetry, emojiBrainstorm) -> {
                    System.out.println(poetry);
                    System.out.println(emojiBrainstorm);
                });
    }
    //@Test
    public void test(){
        List<String> strings= Arrays.asList("1","2");
        System.out.println(String.join("-",strings));
    }
}