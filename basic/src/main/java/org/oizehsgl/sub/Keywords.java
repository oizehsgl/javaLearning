package org.oizehsgl.sub;

/**
 * 关键字
 *
 * @author oizehsgl
 * @since 2022/12/2
 */
public class Keywords {
    public static void main(String[] args) {
        System.out.println("访问");
        System.out.printf("%s(%s): %s%n","public","公共","可跨包");
        System.out.printf("%s(%s): %s%n","protected","保护","当前包内可用");
        System.out.printf("%s(%s): %s%n","private","私有","当前类可用");
        System.out.println("对象");
        System.out.printf("%s(%s): %s%n","class","类","public class A(){}花括号里是已实现的方法体，类名需要与文件名相同");
        System.out.printf("%s(%s): %s%n","interface","接口","public interface B(){}花括号里有方法体，但没有实现，方法体句子后面是英文分号“;”结尾");
        System.out.printf("%s(%s): %s%n","abstract","抽象类","public abstract class C(){}介于类与接口中间，可以有，也可以没有已经实现的方法体");
        System.out.printf("%s(%s): %s%n","implements","实现","用于类或接口，实现接口public class A interface B(){}");
        System.out.printf("%s(%s): %s%n","extends","继承","用于类继承类public class A extends D(){}");
        System.out.printf("%s(%s): %s%n","new","创建对象","A a=new A();A表示一个类");
        System.out.println("包");
        System.out.printf("%s(%s): %s%n","import","导入","当使用某个包的一些类时，仅需要类名，即可自动插入类所在的包");
        System.out.printf("%s(%s): %s%n","package","包","将所有相关的类放在一个包类以便查找修改等");
        System.out.println("类型");
        System.out.printf("%s(%s): %s%n","byte","字节","8bit");
        System.out.printf("%s(%s): %s%n","char","字节","16bit");
        System.out.printf("%s(%s): %s%n","boolean","布尔","");
        System.out.printf("%s(%s): %s%n","sort","短整形","16bit");
        System.out.printf("%s(%s): %s%n","int","整形","32bit");
        System.out.printf("%s(%s): %s%n","float","浮点","32bit");
        System.out.printf("%s(%s): %s%n","long","长整","64bit");
        System.out.printf("%s(%s): %s%n","double","双精","64bit");
        System.out.printf("%s(%s): %s%n","void","无值","public void A(){}其他需要反回的经常与return连用");
        System.out.println("流程");
        System.out.printf("%s(%s): %s%n","if","如果","if（条件语句｛执行代码｝如果条件语句成立，就开始执行｛｝里面的内容");
        System.out.printf("%s(%s): %s%n","else","或者","常与if连用，用法相同：if(...){...}else{...}");
        System.out.printf("%s(%s): %s%n","while","仅当","while（条件语句）｛执行代码｝");
        System.out.printf("%s(%s): %s%n","for","对于","for(初始化循环变量；判断条件；循环变量值｛｝");
        System.out.printf("%s(%s): %s%n","switch","分支","switch(表达式）｛case 常量表达式1：语句1；...case 常量表达式2；语句2；default:语句；｝default就是如果没有匹配的case就执行它，default并不是必须的。case后的语句可以不用大括号。");
        System.out.printf("%s(%s): %s%n","case","匹配","匹配switch的表达式里的结果");
        System.out.printf("%s(%s): %s%n","default","默认","default就是如果没有匹配的case就执行它， default并不是必须的");
        System.out.printf("%s(%s): %s%n","do","运行","通常与while连用");
        System.out.printf("%s(%s): %s%n","break","跳出","直接跳出循环，执行循环体后的代码");
        System.out.printf("%s(%s): %s%n","continue","继续","中断本次循环，并开始下一轮循环");
        System.out.printf("%s(%s): %s%n","return","返回","return 一个返回值类型");
        System.out.printf("%s(%s): %s%n","instanceof","实例","一个二元操作符，和==、>、<是同一类的。测试它左边的对象是否是它右边的类的实例，返回boolean类型的数据");
        System.out.println("修饰");
        System.out.printf("%s(%s): %s%n","static","静态","属性和方法都可以用static修饰，直接使用类名、属性和方法名。只有内部类可以使用static关键字修饰，调用直接使用类名、内部类类名进行调用。static可以独立存在。");
        System.out.printf("%s(%s): %s%n","final","最终","方法和类都可用final来修饰；final修饰的类是不能被继承的；final修饰的方法是不能被子类重写。常量的定义：final修饰的属性就是常量");
        System.out.printf("%s(%s): %s%n","super","父类","常见public void paint(Graphics g){super.paint(g);...}");
        System.out.printf("%s(%s): %s%n","this","当前","调用当前类中的方法（表示调用这个方法的对象）this.addActionListener(al):等等");
        System.out.printf("%s(%s): %s%n","native","本地","");
        System.out.printf("%s(%s): %s%n","strictfp","严格","");
        System.out.printf("%s(%s): %s%n","synchronized","同步","一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块");
        System.out.printf("%s(%s): %s%n","transient","临时","当一个对象被序列化的时候，transient型变量的值不包括在序列化的表示中，然而非transient型的变量是被包括进去的。");
        System.out.printf("%s(%s): %s%n","volatile","易变","用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。volatile很容易被误用，用来进行原子性操作。");
        System.out.println("异常");
        System.out.printf("%s(%s): %s%n","catch","捕获","（1）try+catch 程序流程是：运行到try块中，如果有异常抛出，则转到catch块去处理。然后执行catch块后面的语句（2）try+catch+finally 程序流程是：运行到try块中，如果有异常抛出，则转到catch垮，catch块执行完毕后，执行finally块的代码，再执行finally块后面的代码。如果没有异常抛出，执行完try块，也要去执行finally块的代码。然后执行finally块后面的语句（3）try+finally  程序流程是：运行到try块中，如果有异常抛出，则转到finally块的代码。");
        System.out.printf("%s(%s): %s%n","try","试用","捕获异常");
        System.out.printf("%s(%s): %s%n","finally","最终","有没有异常都执行");
        System.out.printf("%s(%s): %s%n","throw","抛出","一些可以导致程序出问题，比如书写错误，逻辑错误或者是api的应用错误等等。为力防止程序的崩溃就要预先检测这些因素，所以java使用了异常这个机制在java中异常是靠“抛出”  也就是英语的“throw”来使用的，意思是如果发现到什么异常的时候就把错误信息“抛出”");
        System.out.printf("%s(%s): %s%n","throws","抛出","把异常交给他的上级管理，自己不进行异常处理");
        System.out.println("其他");
        System.out.printf("%s(%s): %s%n","enum","枚举","");
        System.out.printf("%s(%s): %s%n","assert","断言","");
        System.out.println("保留");
        System.out.printf("%s(%s): %s%n","const","常量","用于修改字段或局部变量的声明。");
        System.out.printf("%s(%s): %s%n","goto","转到","指定跳转到标签，找到标签后，程序将处理从下一行开始的命令");
        System.out.println("特殊");
        System.out.printf("%s(%s): %s%n","null","空","");
        System.out.printf("%s(%s): %s%n","true","真","");
        System.out.printf("%s(%s): %s%n","false","假","");
    }
}
