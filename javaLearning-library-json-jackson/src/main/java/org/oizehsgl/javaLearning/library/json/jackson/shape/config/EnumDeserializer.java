package org.oizehsgl.javaLearning.library.json.jackson.shape.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.library.json.jackson.shape.enums.DemoEnum;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * 示例枚举反序列化
 *
 * @author yueyuanzhi
 */
//@Component
//public class EnumDeserializer extends JsonDeserializer<DemoThirdPartEnum> {
//
//    @Override
//    public DemoThirdPartEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//        final Integer param = jsonParser.getIntValue();
//        final JsonStreamContext parsingContext = jsonParser.getParsingContext();
//        final String currentName = parsingContext.getCurrentName();
//        final Object currentValue = parsingContext.getCurrentValue();
//        try {
//            final Field declaredField = currentValue.getClass().getDeclaredField(currentName);
//            final Class<?> targetType = declaredField.getType();
//            final Method valuesMethod = targetType.getDeclaredMethod("values");
//            DemoThirdPartEnum[] enums = (DemoThirdPartEnum[]) valuesMethod.invoke(null);
//            for (DemoThirdPartEnum anEnum : enums) {
//                if (anEnum.getId().equals(param)) {
//                    return anEnum;
//                }
//            }
//            throw new RuntimeException("未知类型");
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
//            throw new RuntimeException("未知类型", e);
//        }
//    }
//}
//
@Slf4j
@JacksonStdImpl
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EnumDeserializer extends JsonDeserializer<DemoEnum> implements ContextualDeserializer {

    private Class<?> clazz;

    @Override
    public DemoEnum deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        // 前端传递的值
        String value = p.getValueAsString();
        // 通过遍历，获取对应的枚举对象
        return Arrays.stream(clazz.getEnumConstants()).map(t -> (DemoEnum) t)
                .filter(t -> Objects.equals(t.getCode(), value))
                .findAny().orElse(DemoEnum.ONE);

    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        // 自定义反序列化器
        Class<?> typeClazz = property.getType().getRawClass();
        return new EnumDeserializer(typeClazz) {
        };
    }
}