package com.ahilessprime.kalkTest.sourse;
import  com.ahilessprime.kalkTest.kalkMain;

public class Testing extends Thread{

    /**
     * выводит на экран сообщения для помощи отладки
     */


    kalkMain kalk = new kalkMain();

    @Override
    public void run(){
        System.out.println("отладка включенна");
        while(true) {
            try {
                System.out.println("есть контакт: "+kalk.getTestLine());
            } catch (InterruptedException e) { }
        }
    }

}
