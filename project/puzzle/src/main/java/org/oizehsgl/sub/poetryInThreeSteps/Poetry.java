package org.oizehsgl.sub.poetryInThreeSteps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * poetry
 *
 * @author oizehsgl
 * @since 4/12/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poetry {
    /**
     * 标题
     */
    String title;
    /**
     * 朝代
     */
    String dynasty;
    /**
     * 作者
     */
    String author;
    /**
     * 体裁
     */
    String genre;
    /**
     * 内容
     */
    List<String> content;
}