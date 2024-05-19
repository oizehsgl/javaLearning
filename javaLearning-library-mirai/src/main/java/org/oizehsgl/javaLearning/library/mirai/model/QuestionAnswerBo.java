package org.oizehsgl.javaLearning.library.mirai.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 问答实体类
 *
 * @author oizehsgl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerBo {
  private List<Path> filePathList;
  private Map<String, Integer> answerScoreMap;

  public QuestionAnswerBo load(String stringDir) throws IOException {
    filePathList = new ArrayList<>();
    answerScoreMap = new HashMap<>();
    File dir = new File(stringDir);
    List<File> fileList = Arrays.asList(Objects.requireNonNull(dir.listFiles()));
    for (File file : fileList) {
      if (file.getName().startsWith("q")) {
        filePathList.add(file.toPath());
      } else if (file.getName().startsWith("a.txt")) {
        List<String> strings = Files.readAllLines(file.toPath());
        Iterator<String> stringIterator = strings.iterator();
        if (stringIterator.hasNext()) {
          String answer = stringIterator.next();
          String score = stringIterator.next();
          answerScoreMap.put(answer, Integer.parseInt(score));
        }
      }
    }
    return this;
  }
}
