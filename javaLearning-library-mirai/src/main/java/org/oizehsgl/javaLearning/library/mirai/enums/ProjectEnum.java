package org.oizehsgl.javaLearning.library.mirai.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.oizehsgl.javaLearning.library.mirai.consumer.EncyclopediaConsumer;
import org.oizehsgl.javaLearning.library.mirai.consumer.ProjectConsumer;
import org.oizehsgl.javaLearning.library.mirai.consumer.ProjectManagerConsumer;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * 项目枚举
 *
 * @author yueyuanzhi
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

    public String getBeanName() {
        return StringUtils.uncapitalize(beanClass.getSimpleName());
    }

    public static <R> ProjectEnum getEnum(Function<ProjectEnum, R> function, R r) {
        return Arrays.stream(ProjectEnum.values())
                .filter(p -> function.apply(p).equals(r))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}