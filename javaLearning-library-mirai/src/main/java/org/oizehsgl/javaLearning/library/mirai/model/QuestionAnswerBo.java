package org.oizehsgl.javaLearning.library.mirai.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 问答实体类
 *
 * @author yueyuanzhi
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerBo {
    List<String> filePathList;
    Map<String,Integer> answerScoreMap;
    public QuestionAnswerBo load(File file){
        List<File> fileList = Arrays.asList(Objects.requireNonNull(file.listFiles()));
        return null;
    }

}
