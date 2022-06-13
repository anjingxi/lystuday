package com.ly.exit_;

/**
 * @author ly
 * @version 1.0
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        //通知方式停止线程
        Thread.sleep(10*1000);
        t.setLoop(false);
    }
}
class T extends Thread{
    private boolean loop= true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    int count =0;
    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(++count);
        }
    }
}