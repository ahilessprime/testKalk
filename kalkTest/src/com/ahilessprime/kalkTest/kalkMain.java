package com.ahilessprime.kalkTest;
import com.ahilessprime.kalkTest.sourse.*;

public class kalkMain {

    /**
     * класс содержит метод main() а так же методы и переменные для отладки:
     *  static boolean rubilbik - переменная для активации помощи отладки
     *  setTestLine(String) - передача сообщения отладки
     *  String getTestLine() - принятие сообщения отладки
     */





    static boolean rubilnik = false; //для активации метода отладки присвоить true
    private static String testLine=null;// переменная для сообщений отладки

    public synchronized void setTestLine(String testLine) throws InterruptedException{
        while(rubilnik&this.testLine!=null) { //если рубильник включен и testline содержит какое либо значение
            wait(1); }  // - подож3дать пока это значение не будет прочитанно и обнуленно
        this.testLine=testLine; }

        public synchronized String getTestLine() throws InterruptedException{
        while(testLine==null){ //если testLine null
            wait(1);  // подождать пока значение не будет добавленно
        }
        String s = testLine; //прочитать переменную отладки
        testLine=null; // и обнулить переменную отладки
        return s;
    }


    public static void main(String[] args) {

        // метод для отладки
        Testing test; //объект класса отладки
        if (rubilnik){ //запускаем отладчик в новом потоке
            test = new Testing();
            test.start();
        }


        UserInput input = new UserInput();
        input.setInput(); //взаимодейстыие с пользователем
        SystemOut out = new SystemOut();
        out.StartOut();

    }
}
