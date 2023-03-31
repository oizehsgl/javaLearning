package org.oizehsgl.sub;

/**
 * 术语
 *
 * @author oizehsgl
 * @since 2022/11/22
 */
public class Terminology {
    public static void main(String... args){
        System.out.printf("%s: %s%n%n", "Java SE", "Standard Edition");
        System.out.printf("%s: %s%n%n", "Java EE", "Enterprise Edition");
        System.out.printf("%s: %s%n%n", "Java CE", "Micro Edition");
        System.out.printf("%s: %s%n%n", "JDK", "Java Development Kit");
        System.out.printf("%s: %s%n%n", "JRE", "Java Runtime Environment");
        System.out.printf("%s: %s%n%n", "JSR", "Java Specification Request");
        System.out.printf("%s: %s%n%n", "JCP", "Java Community Process");
        System.out.printf("%s: %s%n%n", "RI", "Reference Implementation");
        System.out.printf("%s: %s%n%n", "TCK", "Technology Compatibility Kit");
        /**
         * JCP是Java Community Process（Java社区标准过程）的缩写，它成立于1998年，是使有兴趣的各方参与定义Java的特征和未来版本的正式过程。简单地说，JCP就是社区共同对Java未来功能和发展方向进行确定的过程和组织。可以通过申请成为JCP会员提交Java发展的相关功能和建议，成为JCP会员是唯一可以提交JSR（下文说明）供审查的唯一方式。
         * JSR是Java Specification Requests Java规范请求的缩写，JCP使用JSR作为正式规范文档，描述被提议加入到Java体系中的的规范和技术。使用JSR圈定标准范围以后就可以提供给JDK团队成员进行开发， 圈定的范围通常是JAVA相关的, 同时又不会成为Java核心技术(Java SE/EE Core)的一部分.，一个标准的JSR课题通常是一个相对成熟的技术。JSR通常以一个编号指定，例如JSR-370, JSR-338等等。
         * JLS是Java Language Specification的缩写，意为Java语法规范，于指出Java的语法标准和一些规则, 这些规则包括了合规及不合规程序的说明. 规范同时指出了程序的含义并说明了运行后将发生什么。
         * JDK Enhancement Proposal的缩写，意为JDK增强建议。JEP是一个JDK核心技术相关的增强建议文档.。JEP用于探索新的一些想法，一般比JSR更为早期，用于前期的探索，是用于收集​ ​Java Development Kit​​​和​ ​OpenJDK​​增强的提案。
         */
    }
}
