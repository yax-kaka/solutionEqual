public class MyThread extends Thread{
    private volatile boolean flag = false; //volatile修饰通过cpu总线嗅探机制通知其他线程变量已修改

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("子线程将其flag置为true");
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
