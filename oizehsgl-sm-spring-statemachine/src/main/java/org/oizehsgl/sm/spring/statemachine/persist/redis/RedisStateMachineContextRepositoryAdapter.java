package org.oizehsgl.sm.spring.statemachine.persist.redis;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.oizehsgl.nosql.redis.wrapper.serializer.CustomStringRedisSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachineContextRepository;
import org.springframework.statemachine.kryo.MessageHeadersSerializer;
import org.springframework.statemachine.kryo.StateMachineContextSerializer;
import org.springframework.statemachine.kryo.UUIDSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

/**
 * @author oizehsgl
 */
public class RedisStateMachineContextRepositoryAdapter<S, E>
    implements StateMachineContextRepository<S, E, StateMachineContext<S, E>> {

  private static final ThreadLocal<Kryo> kryoThreadLocal =
      new ThreadLocal<Kryo>() {

        @SuppressWarnings("rawtypes")
        @Override
        protected Kryo initialValue() {
          Kryo kryo = new Kryo();
          kryo.addDefaultSerializer(StateMachineContext.class, new StateMachineContextSerializer());
          kryo.addDefaultSerializer(MessageHeaders.class, new MessageHeadersSerializer());
          kryo.addDefaultSerializer(UUID.class, new UUIDSerializer());
          return kryo;
        }
      };

  private final RedisOperations<String, byte[]> redisOperations;

  /**
   * Instantiates a new redis state machine context repository.
   *
   * @param redisConnectionFactory the redis connection factory
   */
  public RedisStateMachineContextRepositoryAdapter(
      RedisConnectionFactory redisConnectionFactory,
      CustomStringRedisSerializer customStringRedisSerializer) {
    redisOperations = createDefaultTemplate(redisConnectionFactory, customStringRedisSerializer);
  }

  public RedisStateMachineContextRepositoryAdapter(RedisTemplate<String, byte[]> redisTemplate) {
    redisOperations = redisTemplate;
  }

  private static RedisTemplate<String, byte[]> createDefaultTemplate(
      RedisConnectionFactory connectionFactory,
      CustomStringRedisSerializer customStringRedisSerializer) {
    RedisTemplate<String, byte[]> template = new RedisTemplate<String, byte[]>();
    template.setKeySerializer(customStringRedisSerializer);
    template.setHashKeySerializer(customStringRedisSerializer);
    template.setConnectionFactory(connectionFactory);
    template.afterPropertiesSet();
    return template;
  }

  @Override
  public void save(StateMachineContext<S, E> context, String id) {
    redisOperations.opsForValue().set(id, serialize(context));
  }

  @Override
  public StateMachineContext<S, E> getContext(String id) {
    return deserialize(redisOperations.opsForValue().get(id));
  }

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
}
