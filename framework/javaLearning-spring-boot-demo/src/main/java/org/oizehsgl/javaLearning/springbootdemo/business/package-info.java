/**
 * 重业务逻辑的代码分层
 * <p>
 * 内部请求业务从controller进入
 * 第三方请求业务从facade进入
 * 定时任务业务从schedule进入
 * 事件触发业务从subscribe进入
 * <p>
 * 业务进入后流向
 * service--->manager--->mapper
 * service--->manager...>第三方
 *
 * @author yueyuanzhi
 */
package org.oizehsgl.javaLearning.springbootdemo.business;
