// package定义包名
// 包是相关类的聚合目录
package com.example.keyword.keywordAccessModifier.keywordPackagePrivate.keywordPackagePrivateInaccessible;

// 导入类

import com.example.keyword.keywordAccessModifier.keywordPackagePrivate.KeywordPublic;

/**
 * @author oizehsgl
 * @since 6/27/23
 */
public class KeywordPackagePrivateInaccessibleInner {
    public void testPackagePrivateInaccessible() {
        // 无法访问
        //KeywordPackagePrivate keywordPackagePrivate = new KeywordPackagePrivate();
    }

    public void testMethod() {
        KeywordPublic keywordPublic = new KeywordPublic();
        keywordPublic.methodPublic();
        // 不可访问
        //keywordPublic.methodProtected();
        //keywordPublic.methodPackagePrivate();
    }
}