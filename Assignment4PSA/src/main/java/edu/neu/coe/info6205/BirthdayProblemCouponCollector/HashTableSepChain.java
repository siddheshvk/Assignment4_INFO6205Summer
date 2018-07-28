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

public class HashTableSepChain<Key, Value>   {
    
        public static int chainCount=0;
	public static int nodeCount=0;
	
	private int slots;
//	private Node[] st = (Node[]) new Object[M];
	private Node[] nodeChain ;
        
        private static class Node
	{
		private Object key;
		private Object val;
		private Node next;	
		
		public Node(Object key, Object val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
		
	}
        
        public HashTableSepChain(int slots)
	{
		this.slots=slots;
		this.nodeChain =  new Node[slots];
	}
        
        private int hash(Key key)
	{  
//		System.out.println("key: "+key+" from hash function: "+ (key.hashCode() & 0xffffffff) % M);
		return (key.hashCode() & 0x7fffffff) % slots;
		
	}

	public Value get(Key key)
	{
		int i=hash(key);
		for(Node node = nodeChain[i];node!=null; node=node.next)
		{
			if(key.equals(node.key))
				return (Value)node.val;
		}
		
		return null;
	}
	
	public void put(Key key, Value val)
	{
		int index=hash(key);
		
		nodeCount++;

		if(nodeChain[index]==null)
		{
			
			chainCount++;
		}
		
		

		for(Node node = nodeChain[index]; node!=null; node=node.next)
		{
			if(key.equals(node.key))
			{	
				node.val = val;
				return;
			}
		}
		nodeChain[index]= new Node(key,val, nodeChain[index]);
	}
}
