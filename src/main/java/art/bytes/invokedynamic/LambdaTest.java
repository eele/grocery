package art.bytes.invokedynamic;

import java.lang.reflect.Method;

public class LambdaTest {

    private String insStr;

    private static String staticStr;

    public interface Lambda {
         void run();
    }

    public static void doSomething2(Lambda lambda) {
        lambda.run();
    }

    public void doSomething(Lambda lambda) {
        lambda.run();
    }

    public void insStr() { // 闭包形式包含自由变量情况 生成的lambda方法必须为非静态方法
        doSomething(() -> System.out.println(insStr));
    }

    public void staticStr() {
        doSomething(() -> System.out.println(staticStr));
    }

    public void constantStr() {
        doSomething(() -> System.out.println("a"));
    }

    public static void main(String[] args) {
        System.out.println("LambdaTest.ClientTest.class.getDeclaredMethods()");
        for (Method m : LambdaTest.class.getDeclaredMethods()) {
            if (m.toString().contains("lambda$")) {
                System.out.println("\t" + m);
            }
        }
    }

}
