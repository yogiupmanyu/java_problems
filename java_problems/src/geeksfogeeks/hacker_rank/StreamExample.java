package java_problems.geeksfogeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public  void convertStreamToList(){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> intStream = list.stream();
        List<Integer> streamToList =  intStream.filter(i->i%2==0).collect(Collectors.toList());
        System.out.print(streamToList);
    }

    public void converStreamToArray(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);
    }

    public static void main(String[] args){
        StreamExample ob = new StreamExample();
        ob.converStreamToArray();
        ob.convertStreamToList();
    }
}
