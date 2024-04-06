/**
 * 通用逻辑层(高可复用)
 * <p>
 * 通用业务逻辑
 * 封装service层通用处理,缓存中间件等
 * 封装第三方接口,预处理返回结果,转换异常信息
 * 与dao层统一交互,多个dao层的组合复用
 * 异常: 抛出到service层,如没有service应记录详细日志
 *
 * @author yueyuanzhi
 */
package org.oizehsgl.javaLearning.framework.springBoot.business.manager;