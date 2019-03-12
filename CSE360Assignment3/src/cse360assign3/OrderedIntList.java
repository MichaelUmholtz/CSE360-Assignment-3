/** 	Assignment #: 3
 *		@author Michael Umholtz
 *		StudentID: 	1212997706
 *		ClassID:	570
 *		Lecture: 	Wednesday 3:05 - 4:20
 *		Description:	This class creates a list of integers stored within an array that
 *						sorts based on an insertion approach. Duplicate values are excluded
 *						and the last value is removed from the list when necessary. 	*/

package cse360assign3;
public class OrderedIntList {
	
	/**	Array used to contain all input values.		*/
	private int[] intArray; 
	
	/**	Integer holding number of input elements currently stored within the intArray.		*/
	private int numElements; 
	
	/**	A basic constructor that instantiates both the array to store values in as well as
	 *	a value for the number of elements that are in said array.	*/
	OrderedIntList ()
	{
			intArray = new int[10];
			numElements = 0;
	}
	
	/** Overloaded constructor allowing the size of the array to be given as a parameter.
	 * 
	 * @param size Size of the array used to hold integer values.		*/
	OrderedIntList (int size)
	{
			intArray = new int[size];
			numElements = 0;
	}
	
	/**	Method to insert integer elements into their specific locations	and 
	 *  move all subsequent elements as to maintain ascending order.	
	 *  
	 *  @param userInput Input value to be added to the array.		*/
	public void insert (int userInput) 
	{
		
			int insertIndex = 0;
			
			for (int forCounter = 0; forCounter < numElements; forCounter++) {
				
				insertIndex = numElements;
				
				if(userInput <= intArray[forCounter]) {
					
					insertIndex = forCounter;
					
					if(userInput == intArray[forCounter]) {
						insertIndex = -1;
					}
					
					forCounter = numElements;
				}
			}
			
			if(insertIndex >= 0) {
				
				if(numElements >= intArray.length) {
					
					int newSize = (int)(intArray.length * 1.5);
					
					if(newSize == 1) {
						newSize += 1;
					}
					
					int[] tempArray = new int[newSize];
					
					for(int transferCounter = 0; transferCounter < numElements; transferCounter++) {
						
						tempArray[transferCounter] = intArray[transferCounter];
					
					}
					
					intArray = tempArray;
				}
				
				if(numElements < intArray.length) {
					numElements++;
				} //Only increments number of elements to the maximum size of the array
			
				for (int forCounter = numElements - 1; forCounter > insertIndex; forCounter--) {
					intArray[forCounter] = intArray[(forCounter - 1)];
				}
				
				intArray[insertIndex] = userInput;
				
				} 
			
	}
	
	/** Method returning the size of the array used to store integer values. 
	 * 
	 * @return Size of the array storing integer values.	*/
	public int size () 
	{
		return (intArray.length);
	}
	
	/** Method returning the number of integers currently stored in the array.
	 * 
	 * @return Number of integers stored in array.		*/
	public int length () 
	{
		return numElements;
	}
	
	/** Method that searches for one given value in the integer array then deletes it if it exists.
	 * 	If deleting this element were to decrease the number of elements in the array below half the
	 * 	array size, then the array size is changed to be 50% smaller.
	 * 
	 * @param key Integer value to be searched for and deleted from the integer array.		*/
	public void delete (int key) {
		
		int indexToDelete = -1;
		int numOfValuesToDelete = 0;
		
		for(int counter = 0; counter < intArray.length; counter ++) {
			
			if(intArray[counter] == key) {
				
				indexToDelete = counter;
				
				numOfValuesToDelete += 1;
				
			}
			
		}
		
		int[] tempArray;
		
		if((double)(numElements - numOfValuesToDelete) < ((double)intArray.length / 2)) {
			tempArray = new int[intArray.length / 2];
		}else {
			tempArray = new int[intArray.length];
		}
		
		
		int tempCounter = 0;
		
		if(indexToDelete != -1) {
			for(int arrayCounter = 0; arrayCounter < numElements; arrayCounter ++) {
				
				if(arrayCounter == indexToDelete && numOfValuesToDelete != 0) {
				
				}else {
				
					tempArray[tempCounter] = intArray[arrayCounter];
					tempCounter+=1;
				
				}
			}
			
			intArray = tempArray;
			numElements = numElements - numOfValuesToDelete;
			
		}
	}
	
	/**	This method converts all elements stored in the integer array into a printable string format.
	 * 	This string is created such that there exists a space between each integer value excluding one
	 * 	after the last value.
	 * 
	 *	@return A string containing all integer elements stored in the array.		*/
	public String toString () 
	{
		String intList = "";
		
		for(int arrayCounter = 0; arrayCounter < numElements - 1; arrayCounter++) {
			
			intList = "" + intArray[arrayCounter] + " "; 
		
		}
		
		intList = "" + intArray[numElements-1];
		
		return intList;
	}
	
}
