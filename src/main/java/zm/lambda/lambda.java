package zm.lambda;

import java.util.Comparator;

public class lambda {
    public static void main(String[] args) {
//        test1();
//        System.out.println("主线程方法");
        test2();
    }
    public static void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("无参的lambda表达式1");
            }
        };
        r1.run();
        /**
         * 无参的lambda表达式
         */
        System.out.println("********************");
        Runnable r2=()->{
            System.out.println("无参的lambda表达式2");
        };
        r2.run();
    }
    /**
     * 有参的lambda表达式
     */
    public static  void test2() {
        Comparator<Integer> comparable = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = comparable.compare(10, 20);
        System.out.println(compare);
        Comparator<Integer> com2 = (o1, o2) ->
            Integer.compare(o1, o2);
        int com=com2.compare(32, 21);
        System.out.println(com);
    }

}
