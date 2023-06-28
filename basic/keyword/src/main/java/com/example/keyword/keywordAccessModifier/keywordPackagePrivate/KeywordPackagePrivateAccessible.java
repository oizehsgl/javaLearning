// package定义包名
// 包是相关类的聚合目录
package com.example.keyword.keywordAccessModifier.keywordPackagePrivate;

// 导入类

/**
 * @author oizehsgl
 * @since 6/27/23
 */
public class KeywordPackagePrivateAccessible {
    public void testPackagePrivateAccessible() {
        // 可以访问
        KeywordPackagePrivate keywordPackagePrivate = new KeywordPackagePrivate();
    }

    public void testMethod() {
        KeywordPublic keywordPublic = new KeywordPublic();
        keywordPublic.methodPublic();
        keywordPublic.methodProtected();
        keywordPublic.methodPackagePrivate();
    }
}