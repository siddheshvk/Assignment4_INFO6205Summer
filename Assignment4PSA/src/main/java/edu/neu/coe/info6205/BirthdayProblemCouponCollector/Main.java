/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.BirthdayProblemCouponCollector;

import java.util.Random;

/**
 *
 * @author Siddhesh
 */
public class Main {
    
    
    public static void main(String[] args){
        int coupon_count=0;
        Double count =0.0;
        int nodeCount=0;

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

        System.out.println(count);

        System.out.println("number of hashes/throws after when all bins/slots are filled: "+ nodeCount/10);

        double logVal = count * Math.log(count);

        System.out.println("Expected hashes before all the slots are filled: "+ logVal);
        System.out.println();
        }
    }
}
