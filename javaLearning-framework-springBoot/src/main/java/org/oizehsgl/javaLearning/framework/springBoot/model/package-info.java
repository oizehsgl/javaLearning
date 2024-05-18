/**
 * 以失血模型为主的各类模型的分层
 * <p>
 * bo: 业务对象,一般是其余对象组合的复杂对象
 * dao: 数据访问对象,有增删改查的接口
 * po: 持久化对象,也叫实体类,和数据库结构一一对应
 * dto: 数据传输对象,一般是与其它服务交互时的封装对象
 * qo: 查询对象,一般用于展示层传来的查询
 * vo: 视图对象,用于展示层
 *
 * @author oizehsgl
 */
package org.oizehsgl.javaLearning.framework.springBoot.model;
