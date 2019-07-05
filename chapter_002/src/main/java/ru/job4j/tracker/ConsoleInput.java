package ru.job4j.tracker;
import java.util.*;

 public class ConsoleInput implements Input {

         public  String ask(String question) {
             Scanner scanner = new Scanner(System.in);
             System.out.println(question);
             return scanner.nextLine();
         }
     @Override
     public int ask(String question, List<Integer> range) {
         int key = Integer.valueOf(this.ask(question));
         boolean exist = false;
         for (int value : range) {
             if (value == key) {
                 exist = true;
                 break;
             }
         }
         if (exist) {
             return key;
         } else {throw new MenuOutException("Number out of menu range");}
     }
 }