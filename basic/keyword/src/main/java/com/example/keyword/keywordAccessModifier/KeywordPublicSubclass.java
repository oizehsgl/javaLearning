// package定义包名
// 包是相关类的聚合目录
package com.example.keyword.keywordAccessModifier;

// 导入类

import com.example.keyword.keywordAccessModifier.keywordPackagePrivate.KeywordPublic;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 * @since 6/27/23
 */
// package-private(无修饰符)修饰类: 包内可访问,此处理解为package xxx与之完全一致
@Service
public class KeywordPublicSubclass extends KeywordPublic {
    public void testMethod() {
        KeywordPublic keywordPublic = new KeywordPublic();
        keywordPublic.methodPublic();
        // 不可通过父类对象调用父类protected方法
        //keywordPublic.methodProtected();
        // 通过super来调用,当子类没有同名方法时可以省略super
        methodProtected();
        super.methodProtected();
        KeywordPublicSubclass keywordPublicSubclass = new KeywordPublicSubclass();
        keywordPublicSubclass.methodProtected();
        // 静态保护方法可直接调用
        KeywordPublic.methodProtectedStatic();
    }

    public void methodProtected() {
        System.out.println("子类方法");
    }
}
