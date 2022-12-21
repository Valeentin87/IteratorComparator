package org.example;

import java.util.*;

//1. Создадим ArrayList и заполним его на основе элементов массива целых чисел
//2. Реализуем Iterator для перебора элементов коллекции
//3. Создадим LinkedList случайных чисел из 10000 элементов и реализуем удаление конкретных чисел через remove и
    // через итератор и сравним время на выполнение данных операций
//Удаление из LinkedList через поиск элемента по индексу прошшло за время 36 а удаление с помощью итератора за время 2
public class IteratTor {


    public static void main(String[] args) {
//1.
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] array = {20, 15, 3, 56, 78, 32, 67, 8, 9};
        for(int i=0; i<array.length;i++){
            arrayList.add(array[i]);
            }
// Выводим в консоль с помощью оператора foreach
        System.out.println("-------Выводим в консоль с помощью оператора foreach--------");
        arrayList.forEach(item-> System.out.println(item));
//2. Выводим в консоль с помощью итератора
        System.out.println("----------------Выводим в консоль с помощью итератора------------------");
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

//3.
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i<10000; i++){
            linkedList.add(new Random().nextInt(250));
        }
        LinkedList<Integer> linkedList1 = (LinkedList<Integer>) linkedList.clone();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        long time1 = System.currentTimeMillis();

        for(int i=0;i<10000;i++){
            if (linkedList1.get(i)<200){
                arrayList1.add(i);
            }
        }


        long time2 = System.currentTimeMillis();
        Iterator<Integer> iterator1 = linkedList1.iterator();
        int j = 0;
        while (iterator1.hasNext()){
             j =  iterator1.next();
             if (j<200){
                 iterator1.remove();
             }
        }
        long time3 = System.currentTimeMillis();
        System.out.println("Удаление из LinkedList через поиск элемента по индексу прошшло за время "+
                +(time2-time1)+" а удаление с помощью итератора за время "+(time3-time2));
        ListIterator<Integer> iterator2 = linkedList.listIterator();
        


    }
}