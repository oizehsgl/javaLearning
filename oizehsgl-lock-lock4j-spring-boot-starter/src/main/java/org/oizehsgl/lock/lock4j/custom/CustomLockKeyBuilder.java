//package org.oizehsgl.lock.lock4j.custom;
//
//import com.baomidou.lock.DefaultLockKeyBuilder;
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author oizehsgl
// */
//@Component
//public class CustomLockKeyBuilder extends DefaultLockKeyBuilder {
//
//  public CustomLockKeyBuilder(BeanFactory beanFactory) {
//    super(beanFactory);
//  }
//
//  @Override
//  public String buildKey(MethodInvocation invocation, String[] definitionKeys) {
//    return "APP:" + super.buildKey(invocation, definitionKeys);
//  }
//}
