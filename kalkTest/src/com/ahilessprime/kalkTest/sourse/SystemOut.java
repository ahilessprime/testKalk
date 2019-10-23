package com.ahilessprime.kalkTest.sourse;
import com.ahilessprime.kalkTest.sourse.MostWanted;

public class SystemOut {
    /**
     * SystemOut - проводит конечные вычисления и выводиn на экран.
     * содержит открытые методы:
     * void startOut() -  проводит вычислесния с значений полученные через класс Mostvanted
     * и выводит на экран пользователя.
     * void outData(int) - выводит числовой аргумент на экран
     * void outData(String) - выводит строковой аргумент на экран
     */
    int otvet;
    MostWanted most = new MostWanted();

    public void StartOut(){ //начало конечных вычислений и вывода
        vichislenie();
        sortirovka();

    }

    private void vichislenie(){ //отсортированный числовой массив распределяется по обычным переменным для читабедьности
        int a= most.getDataint(1);
        int b= most.getDataint(2);
        int c= most.getDataint(3);

        switch (b){ //сравнивается условное значение и требуемое для него операция
            case 0: otvet=a+c; break;
            case 1: otvet=a-c; break;
            case 2: otvet=a*c; break;
            case 3: otvet=a/c; break;
        }

    }

    private void sortirovka(){ //конечная для вывода ответа
        if(most.getStatusArLat()==1){ //если запрос на арабском -
            outData(otvet); //вернуть ответ как есть после вычисления
        }
        else{ //иначе переобразовать ответ в латинский и вернуть его
            outData(most.getLatin(otvet));
        }

    }

    public void outData(int n){
        System.out.println(otvet);
    } // вывод ответа для целочисленного типа
    public void outData(String s){
        System.out.println(s);
    }  // перезагрузка для строкового типа (Лат)

}
