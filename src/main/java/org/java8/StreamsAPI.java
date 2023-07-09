package org.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPI {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(23);
        arr.add(19);
        arr.add(44);
        arr.add(80);
        arr.add(12);
        arr.add(21);
        arr.add(67);

         arr.stream().filter(i->i%2==0).collect(Collectors.toList()).forEach(System.out::println);

         System.out.println(   "Max in arr is : " +  arr.stream().max((i1,i2)-> i1.compareTo(i2)).get());
        System.out.println(   "Min in arr is : " +  arr.stream().min((i1,i2)-> i1.compareTo(i2)).get());

        System.out.println("Sorted array is: ");
        arr.stream().sorted().forEach(System.out::println);

        System.out.println("count of even nos in arr is : " + arr.stream().filter(i-> i%2==0).count());



    }
}
