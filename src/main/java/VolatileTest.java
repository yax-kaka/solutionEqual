/**
 * volatile和synchronized 测试
 */
public class VolatileTest {
    static boolean mainFlag = false;
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        boolean falsePrint = false;
        boolean truePrint = false;

        for (; ; ) {
//            synchronized(myThread) { //使用synchronized加锁后myThread的内存变得可见，线程获取到锁，会清空本地内存，然后从主内存中拷贝共享变量的最新值到本地内存作为副本
//                if (myThread.getFlag()) {
//                    if (!truePrint) {
//                        truePrint = true;
//                        System.out.println("主线程访问到更改后的flag的值");
//                    }
//                } else {
//                    if (!falsePrint) {
//                        falsePrint = true;
//                        System.out.println("flag的值仍为false");
//                    } else {
//                        //System.out.println("主线程未访问到更改后的flag");
//                    }
//                }
//            }

            if (myThread.getFlag()) {
                if (!truePrint) {
                    truePrint = true;
                    System.out.println("主线程访问到更改后的flag的值");
                }
            } else {
                if (!falsePrint) {
                    falsePrint = true;
                    System.out.println("flag的值仍为false");
                }
            }
        }
    }
}

