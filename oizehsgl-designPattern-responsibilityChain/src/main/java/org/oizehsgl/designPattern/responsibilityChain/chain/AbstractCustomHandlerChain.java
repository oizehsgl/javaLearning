//package org.oizehsgl.designPattern.responsibilityChain.chain;
//
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import org.oizehsgl.designPattern.responsibilityChain.handler.CustomFirstHandler;
//import org.oizehsgl.designPattern.responsibilityChain.handler.CustomHandler;
//import org.oizehsgl.designPattern.responsibilityChain.handler.CustomSecondHandler;
//import org.springframework.asm.TypeReference;
//import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
//
///**
// * @author oizehsgl
// */
//public abstract class AbstractCustomHandlerChain<T, R> {
//  private final List<CustomHandler<Object, Object>> customHandlerList;
//
//  public AbstractCustomHandlerChain(CustomHandler<Object, Object>... customHandlers) {
//    customHandlerList = List.of(customHandlers);
//  }
//
//  public R handle(T t) {
//
//
//    CustomFirstHandler customFirstHandler = new CustomFirstHandler();
//    CustomSecondHandler customSecondHandler = new CustomSecondHandler();
//    String s="";
//    Integer i=  customFirstHandler.handle(s);
//    Object o =  customFirstHandler.handle(s);
//    Class<Integer> c = Integer.class;
//    Type type = List<Integer>.g
//    Object o1 =  customSecondHandler.handle(c.cast(o));
//
//    for (CustomHandler<Object, Object> customHandler : customHandlerList) {
//      Class<Integer> c = Integer.class;
//      c.getGenericInterfaces();
//      c.getGenericSuperclass()
//      TypeReference
//      ParameterizedType parameterizedType =
//       c.cast(customHandler.handle(t));
//    }
//  }
//
//
//void testTypeReference() {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(9);
//        list.add(4);
//        list.add(8);
//
//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("a", list);
//        System.out.println(jsonObj);
//
//        List<String> list2 = jsonObj.getObject("a", new TypeReference<List<Integer>>(){});
//        System.out.println(list2);
//  }
//}
