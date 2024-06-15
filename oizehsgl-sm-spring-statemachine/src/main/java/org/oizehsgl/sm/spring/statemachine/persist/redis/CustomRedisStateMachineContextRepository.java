package org.oizehsgl.sm.spring.statemachine.persist.redis;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import jakarta.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachineContextRepository;
import org.springframework.statemachine.kryo.MessageHeadersSerializer;
import org.springframework.statemachine.kryo.StateMachineContextSerializer;
import org.springframework.statemachine.kryo.UUIDSerializer;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */

@Component
public class CustomRedisStateMachineContextRepository<S, E>
        implements StateMachineContextRepository<S, E, StateMachineContext<S, E>> {

  public static final String BEAN_NAME = "customRedisStateMachineContextRepository";

  private static final ThreadLocal<Kryo> kryoThreadLocal =
          ThreadLocal.withInitial(() -> {
            Kryo kryo = new Kryo();
            kryo.addDefaultSerializer(StateMachineContext.class, new StateMachineContextSerializer());
            kryo.addDefaultSerializer(MessageHeaders.class, new MessageHeadersSerializer());
            kryo.addDefaultSerializer(UUID.class, new UUIDSerializer());
            return kryo;
          });

  @Resource(name = CustomStateMachineRedisTemplate.BEAN_NAME)
  private RedisTemplate<String, byte[]> redisTemplate;

  private byte[] serialize(StateMachineContext<S, E> context) {
    Kryo kryo = kryoThreadLocal.get();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Output output = new Output(out);
    kryo.writeObject(output, context);
    output.close();
    return out.toByteArray();
  }

  @SuppressWarnings("unchecked")
  private StateMachineContext<S, E> deserialize(byte[] data) {
    if (data == null || data.length == 0) {
      return null;
    }
    Kryo kryo = kryoThreadLocal.get();
    ByteArrayInputStream in = new ByteArrayInputStream(data);
    Input input = new Input(in);
    return kryo.readObject(input, StateMachineContext.class);
  }

  @Override
  public void save(StateMachineContext<S, E> context, String id) {
    redisTemplate.opsForValue().set(id, serialize(context));
  }

  @Override
  public StateMachineContext<S, E> getContext(String id) {
    return deserialize(redisTemplate.opsForValue().get(id));
  }
}
