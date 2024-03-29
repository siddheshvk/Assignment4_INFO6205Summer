/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.BirthdayProblemCouponCollector;

import java.util.Random;
import static edu.neu.coe.info6205.BirthdayProblemCouponCollector.Helper.hash;
/**
 *
 * @author Siddhesh
 */
public class Main {
    
    
    public static void main(String[] args){
        int coupon_count=0;
        Double count =0.0;
        int nodeCount=0;
        
     /***** Number of hashes/throws before the first collision in encountered ********/
        System.out.println("All slots full data : ");
        for(coupon_count=10000;coupon_count<110000;coupon_count+=10000) {
        nodeCount=0;
        for(int k=0;k<10;k++)
        {
            HashTableSepChain<Double, Integer> hashTable = new HashTableSepChain<>(coupon_count);
            count = (double) coupon_count;
            Random r = new Random();

            int i=0;
            double randomValue=0.0;

            while(HashTableSepChain.chainCount!=coupon_count)
            {
                randomValue = 0.0 + (count - 0.0) * r.nextDouble();
                hashTable.put(randomValue, i++);

            }	

            nodeCount+=HashTableSepChain.nodeCount;
            HashTableSepChain.nodeCount = 0;
            HashTableSepChain.chainCount = 0;
        }

        System.out.println("Slot count : " + count);

        System.out.println("Number of hashes after when all slots are filled(Actual): "+ nodeCount/10);

        double zeroBins = count * Math.log(count);

        System.out.println("Expected hashes before all the slots are filled: "+ zeroBins);
        System.out.println();
        }
        
        /***** Number of hashes/throws before all bins/slots are filled ********/
        System.out.println("FIrst collisions data : ");
        for(int slots=10000;slots<110000;slots+=10000) {
            count = (double) slots;
            int[] arr = new int[slots+1];

            Random rnd = new Random();
            int hashCountSum=0;

            for(int k=0;k<20;k++) {
                double randomValue=0.0;
                int index=0;
                int hashCount=0;

                while(arr[index]<2)
                {
                    randomValue = 0.0 + (count - 0.0) * rnd.nextDouble();
                    index = hash(slots, randomValue);			
                    hashCount++;
                    arr[index]++;
                }	

                hashCountSum+=hashCount;
                java.util.Arrays.fill(arr, 0);
           }
            System.out.println();
            System.out.println("slot count: "+slots);
            System.out.println("Number of hashes/throws before the first collision encounters (Actual): "+hashCountSum/20 );
            
            double firstColl= Math.sqrt(3.14*slots/2);
            System.out.println("Expected number of hashes/throws before the first collision encounters "+ firstColl);
        }
        
    }
}
