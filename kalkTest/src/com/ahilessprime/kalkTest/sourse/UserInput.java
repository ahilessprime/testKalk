package com.ahilessprime.kalkTest.sourse;
import java.util.Scanner;
import com.ahilessprime.kalkTest.kalkMain; //для взаимодействия с отладчиком


public class UserInput {
    /**
     * userInput - класс взаимодействия с пользователем.
     * имеет 2 примитивных метода взаимодействия:
     * void setInput() - принимает от пользователя запрос в формате String
     * String getInput() - возвращает запрос пользователя
     */


    private static String userData;

    public void setInput(){
            System.out.println("введите задачу");
            Scanner scanner = new Scanner(System.in);
            userData= scanner.nextLine();
            if(userData=="99")System.exit(0); //если значение 99, выйти из программы
            //userData="3-2";
            //userData="I+II";
            try{ errorOut("setInput");} catch (InterruptedException e){} //сообщение для отладчика
            MostWanted most = new MostWanted();
            most.startSortirovka(userData); //передача пользовательского запроса на сортировку

    }

    public String getOtvet(){
        return userData;
    }

    private void errorOut(String s) throws InterruptedException{
        kalkMain kalk1 = new kalkMain();//объект для взаимодействия с отладчиком
        kalk1.setTestLine(s);

    }
}



 class MostWanted{
    /**
     * MostWanted - проверяет запрос пользователя на соответствие требованиям.
     * проводит сортировку на арабские и латинские цифры.
     * содержит 3 открытый метод -
     * void startSortirovka(String) - проводит все вышеописанные операции над
     * полученным аргументом
     * int getStatusArLat() - возвращает статус логических переменных arab и latin в int. если 1 - Arab, 2-Latin;
     * int getDataint(int) - возвращает содержимое запроса помещенное в ячейках userDataInt. в качестве аргумента
     * дается номер ячейки
     */

    private void errorOut(String s) throws InterruptedException{
        kalkMain kalk2 = new kalkMain();//объект для взаимодействия с отладчиком
        kalk2.setTestLine(s); }


     private String [] userDataArray; //массив содержащий запрос пользователя
     private static int[] userDataInt = new int[3]; //массив содержащий запрос в типе int где
     // [0]- первое значение,[2]-второе значение,[1]-{0}-"+",{1}-"-",{2}-"*",{3}-"/";
     static boolean arab; //какого рода приведенные числа

      private String[] latinString = new String[]{"I", "II", "III", "IV",
             "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
             "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
             /*
              можно было конечно автоматизировать процесс. но при проектировании допустил ошибку
              в результате которого выходило что латинские цифры более 20 не нужны.
              заметил оплошность только тогда, когда в конце писал финальную версию документаций.
              так как методы уже написанны и работают хорошо, решил не перегружать код новыми методами
              или наследованием, подумал что будет проще дописать циферблат до 100.
              */
             "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXIII","XXIX",
             "XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX",
             "XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX",
             "L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX",
             "LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX",
             "LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX",
             "LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX",
             "XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX",
             "C"
     };

     public int getStatusArLat(){
         if (arab==true)return 1;
         else return 2;
     }

     public int getDataint(int n){
         n=n-1;
         return userDataInt[n];
     }


     public String getLatin(int systemData){
             int n=(systemData-1);
             String systemDataLatin=latinString[n];
             return systemDataLatin;
     }


     public void startSortirovka(String userData){
         try{ errorOut("publiv startSortirovka");} catch (InterruptedException e){} //сообщение для отладчика
         sortirovka(userData); //передача для проверки на исключения
     }


     private void sortirovka(String userData){



         //проводим сортировку
         //внутренний класс сортировки
         //для просмотра начала операции пролистайте вниз до конца вложенных классов
         class Sort{
             /**
              * класс для проверки исключений пользовательского запроса.
              * содержит в себе открытые методы:
              * public void start() - прогон userData по сортировочному цеху
              * public int[] getUserDataInt() - возврат целочисленного массива
              * где [0] - первое число, [2] - второе число. А [1] - знак математической
              * операции, где {0}- "+" ,{1}- "-",{2}- "*",{3}- "/".
              */



              public void start(){
                  try{ errorOut("sort.start");} catch (InterruptedException e){} //сообщение для отладчика
                 sortZnaki(); //проверяет наличие математических знаков в запросе пользователя
                 sortKolvo(); //соблюдается ли условия о не более 2 значений для операций
                 sortChisl(); //какого рода числа привел пользователь
              }

              private void sortZnaki(){
                  try{ errorOut("sort.znaki");} catch (InterruptedException e){} //сообщение для отладчика
                  /*
                  в методе проверяется содержатся ли в запросе пользователя математические
                  значения операций. когда обнаруживается знак, по нему происходит деление
                  сторки запроса (userData) на массив (userDataArray) в ячейки которого
                  помещаются пользовательские значении.
                  в случай не обнаружения выводится исключение.
                   */
                  if(userData.contains("+"))userDataArray=userData.split("\\+");
                  else if(userData.contains("-"))userDataArray=userData.split("-");
                  else if(userData.contains("*"))userDataArray=userData.split("\\*");
                  else if(userData.contains("/"))userDataArray=userData.split("/");
                  else throw new IllegalArgumentException("неверно составленный запрос " +
                              "отсуствует знак проводимой математическрой операции");
              }

              private void sortKolvo(){
                  /*
                  сортировка на количество ячеек значений UserDataArrey. по условиям задачи
                  они не должны быть более чем 2.
                   */
                  try{ errorOut("sort.sortKolvo");} catch (InterruptedException e){} //сообщение для отладчика
                  if(userDataArray.length>2)throw new IllegalArgumentException("значений для " +
                          "проведении операции должно быть не более 2");
              }

              private void sortChisl(){
                  try{ errorOut("sort.sortChisl");} catch (InterruptedException e){} //сообщение для отладчика
                  while(true){



                          try { //внешний блок перехвата, проверяет является ли первое значение
                                //пользователя арабским, если да то управление идет в вложенный
                                //блок перехвата, если нет выходит на внешний блок где проводятся
                                //операции над латинскими
                              try{ errorOut("sort.start.whie.try");} catch (InterruptedException e){}
                              //сообщение для отладчика
                              userDataInt[0] = Integer.parseInt(userDataArray[0]);
                              try {// вложенный блок перехвата проверяет ввел ли пользователь второе
                                   // так же в арабском исчислении. и проверяет не превышает ли
                                   // эти значения допустимое условие
                                  try{ errorOut("sort.start.while.try.tryArabFullUp");}  //сообщение для отладчика
                                  catch (InterruptedException e){}
                                  userDataInt[2] = Integer.parseInt(userDataArray[1]);
                                  userDataInt[1] = znach();
                                  if(userDataInt[0]>10){ //если значение превышенно
                                      System.out.println("ввведенное значение должно " +
                                              "быть не более 10");
                                      System.exit(1);
                                  }
                                  if(userDataInt[2]>10){ //если значение превышенно
                                      System.out.println("ввведенное значение должно " +
                                              "быть не более 10");
                                      System.exit(1);
                                  }
                                  arab = true;
                                  try{ errorOut("sort.start.while.try.tryArabFullDown");}  //сообщение для отладчика
                                  catch (InterruptedException e){}
                                  break;
                              } catch (Exception e) { //если введены не арабские цифры
                                  throw new IllegalArgumentException("неправильный формат: " +
                                          "цифры должны быть или арабскими или латинскими");
                              }

                          } catch (Exception e) { //если первое значение не арабское - значения
                                                  //идут на проверку по латинскому
                          }
                          try{ errorOut("sort.start.whieLatinUp");} catch (InterruptedException e){}
                          //сообщение для отладчика
                          PerevodLatin perevod = new PerevodLatin();
                          //форматируем для проверки на латинские цифры
                          userDataInt[0] = perevod.getArab(userDataArray[0].toUpperCase());
                          userDataInt[1] = znach();
                          userDataInt[2] = perevod.getArab(userDataArray[1].toUpperCase());
                          //System.out.println(userDataInt[0]+" "+userDataInt[1]+" "+userDataInt[2]);
                          for (int n = 0; n <= 2; n++) {//переводим на араб для проведения вычислений
                              if (userDataInt[n] >= 11){ //если значение 11 - недопустимое значение
                              throw new IllegalArgumentException(
                                      "Неправильный формат: цифры должны быть или арабскими" +
                                              " или латинскими так же не Больше 10");}
                          }
                          try{ errorOut("sort.start.whileLatinDown");} catch (InterruptedException e){}
                          //сообщение для отладчика
                          break;

                  }

              }

              public int znach(){ //возвращает условное значение математического знака, сканировав запрос

                  int a = 0;
                  if (userData.contains("+")) a= 0;
                  if(userData.contains("-")) a= 1;
                  if(userData.contains("*")) a= 2;
                  if(userData.contains("/")) a= 3;

                  try{ errorOut("sort.znachDown");}  //сообщение для отладчика
                  catch (InterruptedException e){}

                  return a;
              }





               class PerevodLatin {
                   /**
                    * PerevodLatin - переводит в обе стороны.
                    * int getArab(String) - переводит Латинское в Араб, возвращает Int
                    * String getLatin(int) - переводит Араб в Латин, возвращает String
                    */


                      int n = 11;

                      public int getArab(String userData) { //возвращает арабские цифры переведенные из латинских
                          try{ errorOut("sort.PerevodLatin.getArabUp");} catch (InterruptedException e){}
                          //сообщение для отладчика
                         for (int i = 0; i <= 10; i++) {
                           if (userData.equals(latinString[i])) { //сравниваются содержания двух строк
                              n = (i + 1);}  //при нахождении соответствий приводится к обычному типу от типа масссива
                         }
                          try{ errorOut("sort.PerevodLatin.getArabDown");} catch (InterruptedException e){}
                          //сообщение для отладчика
                         return n;
                      }

                      public String getLatin(int systemData){ //возвращает латинские цифры от арабских
                          try{ errorOut("sort.PerevodLatin.getLatinUp");} catch (InterruptedException e){}
                          //сообщение для отладчика

                          int n=(systemData-1); //приводится от обычного типа в тип массива
                          String systemDataLatin=latinString[n];

                          try{ errorOut("sort.PerevodLatin.getLatinUp");} catch (InterruptedException e){}
                          //сообщение для отладчика

                          return systemDataLatin;
                      }
              }

             public String getLatin(int n){ //приводится от обычного типа в тип массива
                 try{ errorOut("sort.getLatinUp");} catch (InterruptedException e){}
                 //сообщение для отладчика
                   PerevodLatin lat = new PerevodLatin();
                   String s = lat.getLatin(n); //приводится от обычного типа в тип массива
                 try{ errorOut("sort.PerevodLatin.getLatinDown");} catch (InterruptedException e){}
                 //сообщение для отладчика
                   return s;
             }


         }


         Sort sort = new Sort(); //объект класса Sort
         try{ errorOut("sortirovka");} catch (InterruptedException e){} //сообщение для отладчика
         sort.start(); //начало сортировки на предмет исключений



     }


}