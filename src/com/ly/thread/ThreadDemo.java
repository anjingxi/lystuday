package com.ly.thread;

/**
 * @author ly
 * @version 1.0
 */
public class ThreadDemo {
    public static void main(String[] args) {
        A a = new A();
        Thread thread = new Thread(a);
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
//创建一个类实现runnable接口
class A implements Runnable{
    private int cont=100;
    @Override
    public void run() {
        while (true){
            if(cont<=0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"-"+--cont);
        }
    }
}