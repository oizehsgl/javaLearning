package org.oizehsgl.javaLearning.library.gson;

import com.google.gson.InstanceCreator;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author yueyuanzhi
 */
@Data
@Builder
@RequiredArgsConstructor
public class Id<T> {
    private final Class<T> classOfId;
    private final long value;
}

class IdInstanceCreator implements InstanceCreator<Id<?>> {
    @Override
    public Id<?> createInstance(Type type) {
        Type[] typeParameters = ((ParameterizedType) type).getActualTypeArguments();
        // Id has only one parameterized type T
        Type idType = typeParameters[0];
        return Id.builder()
                .classOfId((Class) idType)
                .value(0L)
                .build();
    }
}