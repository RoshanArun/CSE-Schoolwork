//-------------------------------------------------------------------------
// AUTHOR: Roshan Arun
// FILENAME: IntList.java
// SPECIFICATION: Creates a program where you manipulate arrays 
// FOR: CSE 110- Homework #7
// TIME SPENT:  30 min
//-------------------------------------------------------------------------
import java.util.Random;
import java.util.Arrays;


public class IntList {

	private int[] array;
	private int capacity;
	
	public IntList(int size) {
		capacity = size;
		array = new int[size];
	}
	
	public void randomize() {
		long seed = 13579753;
		Random rng = new Random(seed);
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rng.nextInt(20) + 1;
		}
	}
	
	public void addInt(int newInt, int index) {
	    
		if(array.length == capacity) {
			increaseSize();
		}
		
	    if(array.length >1){ 
	        // shift right
	        for(int i = array.length - 2;i >= index; i--){
	            array[i+1] = array [i];
	        }
	     }
	    
	    capacity = capacity + 1;
		array[index] = newInt;
	}
	
	public void increaseSize() {
		int[] newArr = Arrays.copyOf(array, array.length * 2);
		array = newArr;
	}
	
	public void removeFirst(int intToRemove) {
	        
		int getIndex = 0; 
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == intToRemove) {
				getIndex = i;
			}
		}
				
		for (int i = getIndex; i < array.length - 1; i++) {
		    array[i] = array[i + 1];
		}
	
		capacity = capacity - 1;
		
	}
	
	public int[] countInts() {
		int[] newArr = Arrays.copyOf(array, array.length); 
		int count = 0; 
		
		for(int i = 1; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(array[j] == i) {
					count++;
				}
			}
			newArr[i - 1] = count;
			count = 0;
		}
		return newArr;
	}
	
	public String toString() {
        String output = "";
        for(int i = 0; i < capacity; i++) {
            String temp = String.valueOf(array[i]);
            output = output.concat(temp + " ");
        }
        return output;
    }
}
