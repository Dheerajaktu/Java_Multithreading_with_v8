package SynchronisedConcurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronisedListDemo {
    public static void main(String[] args) throws InterruptedException {

        //List<Integer> list = new ArrayList();
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());


        /*
        * Facing Data inconsistency here
        * Will fixed using Collection.synchroniseList<>
        * Note - Most of collections are not thread safe
        * #Downside of using the Collection.synchronise() approach
        * 1 ==> Coarse grained locking
        * 2 ==> Limited functionality
        * 3 ==> No Fail fast Iterators
        * 4 ==> Performance Overhead
        * */


        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                list.add(i);
            }
        });


        Thread t2 = new Thread(()->{
            for(int i=0;i<1000;i++){
                list.add(i);
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(list.size());
    }
}
