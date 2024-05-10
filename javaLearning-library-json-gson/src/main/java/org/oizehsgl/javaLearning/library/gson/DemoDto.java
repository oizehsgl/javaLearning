package org.oizehsgl.javaLearning.library.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 示例dto
 *
 * @author yueyuanzhi
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoDto {
    @Expose(serialize = true, deserialize = false)
    private String expose;
    // 可以添加备选字段名(当多种情况同时出时,以最后一个出现的值为准)
    @SerializedName(value = "SERIALIZED_NAME", alternate = {"serializedName", "serialized_name"})
    private String serializedName;
    @Since(1.0)
    private String since;
    @Until(1.0)
    private String until;
    // 不参与序列化
    private transient String transientField;

    // 静态内部类才能被实例化
    static class DemoSubDto {
        @Until(0.9)
        private String until;
    }
}
