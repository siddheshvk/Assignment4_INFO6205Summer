/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.BirthdayProblemCouponCollector;

/**
 *
 * @author Siddhesh
 */
public class Helper {
    
    static <Key>int hash(int num, Key key)
    {  return (key.hashCode() & 0x7fffffff) % num;  }
    
}
