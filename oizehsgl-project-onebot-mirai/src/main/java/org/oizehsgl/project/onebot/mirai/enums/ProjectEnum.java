package org.oizehsgl.project.onebot.mirai.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.oizehsgl.project.onebot.mirai.consumer.EncyclopediaConsumer;
import org.oizehsgl.project.onebot.mirai.consumer.ProjectConsumer;
import org.oizehsgl.project.onebot.mirai.consumer.ProjectManagerConsumer;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 项目枚举
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum ProjectEnum {
  PROJECT_MANAGEMENT("项目管理", ProjectManagerConsumer.class),
  ENCYCLOPEDIA("百科竞赛", EncyclopediaConsumer.class),
  FIVE_FOUR_CORPUS("五四文集", EncyclopediaConsumer.class),
  ;
  public final String name;
  public final Class<? extends ProjectConsumer> beanClass;
  public String beanName;

  public static <R> ProjectEnum getEnumByFun(Function<ProjectEnum, R> function, R r) {
    return Arrays.stream(ProjectEnum.values())
        .filter(p -> function.apply(p).equals(r))
        .findFirst()
        .orElse(null);
  }

  public String getBeanName() {
    return StringUtils.uncapitalize(beanClass.getSimpleName());
  }
}
