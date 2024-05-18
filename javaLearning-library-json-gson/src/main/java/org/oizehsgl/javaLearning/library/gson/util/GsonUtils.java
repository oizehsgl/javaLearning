package org.oizehsgl.javaLearning.library.gson.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * gson工具类
 *
 * @author oizehsgl
 */
@Component
public final class GsonUtils {
    private GsonUtils() {
    }

    private static final Gson gson = new GsonBuilder()
            ////不导出实体中没有用@Expose注解的属性
            //.excludeFieldsWithoutExposeAnnotation()
            //支持Map的key为复杂对象的形式
            .enableComplexMapKeySerialization()
            ////过滤transient或static修饰的字段
            //.excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
            ////系列化null
            //.serializeNulls()
            ////时间转化为特定格式
            //.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
            ////会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效
            ////"userName"->"userName"  FieldNamingPolicy.IDENTITY 默认的字段转换规则，字段名不变
            ////"user_name"->"UserName" FieldNamingPolicy.UPPER_CAMEL_CASE 将json中的字段名转换为首字母大写的格式
            ////"user_name"->"User Name" FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES 将json中的字段名转换为首字母大写，单词之间以空格分割的格式
            ////"UserName"->"user_name" FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES 将json中的字段名转换为小写字母，单词之间以下划线分割的格式
            ////"UserName"->"user-name" FieldNamingPolicy.LOWER_CASE_WITH_DASHES 将json中的字段名转换为小写字母，单词之间以分隔线分割的格式
            //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            //@Since(1.0)自1.0版本后(包含)才会执行此字段的序列化和反序列化
            //@Until(1.0)在1.0版本前(不含)才会执行此字段的序列化和反序列化
            .setVersion(1.0)
            ////设置指定类型的解析适配器
            //.registerTypeAdapter(Date.class, DateTimeSerializer.builder()
            //        .datetimeFormat("yyyy-MM-dd HH:mm:ss")
            //        .build())
            //.registerTypeAdapter(java.sql.Date.class, DateTimeSerializer.builder()
            //        .datetimeFormat("yyyy-MM-dd HH:mm:ss")
            //        .build())
            ////设置指定类型以及子类实现类解析适配器
            //.registerTypeHierarchyAdapter(List.class, DemoDeserializer.builder()
            //        .build())
            //// 禁此序列化内部类
            //.disableInnerClassSerialization()
            ////生成不可执行的Json（多了 )]}' 这4个字符）
            //.generateNonExecutableJson()
            ////禁止转义html标签
            //.disableHtmlEscaping()
            ////格式化输出
            //.setPrettyPrinting()
            //// 过滤规则同时适用于序列化/反序列化
            //.setExclusionStrategies(DemoExclusionStrategy.builder()
            //        .build())
            //// 过滤规则只适用于序列化
            //.addSerializationExclusionStrategy(DemoExclusionStrategy.builder()
            //        .build())
            //// 过滤规则只适用于反序列化
            //.addDeserializationExclusionStrategy(DemoExclusionStrategy.builder()
            //        .build())
            .create();

    /**
     * 根据对象返回json 过滤空值字段
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * 根据对象返回json 过滤空值字段
     */
    public static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    /**
     * 根据对象返回json 过滤空值字段
     */
    public static <T> T fromJson(String json, TypeToken<T> type) {
        return gson.fromJson(json, type);
    }
}
