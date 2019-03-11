/** 	Assignment #: 3
 *		@author Michael Umholtz
 *		StudentID: 	1212997706
 *		ClassID:	570
 *		Lecture: 	Wednesday 3:05 - 4:20
 *		Description:	This class creates a list of integers stored within an array that
 *						sorts based on an insertion approach. Duplicate values are excluded
 *						and the last value is removed from the list when necessary. The
 *						print method exists to print out only user inputted values stored
 *						within the array.	*/

package cse360assign3;
public class OrderedIntList {
	
	/**
	 * Array used to contain all input values.
	 */
	private int[] intArray; 
	
	/**
	 * Integer holding number of input elements currently stored within the intArray.
	 */
	private int numElements; 
	
	/**	A basic constructor that instantiates both the array to store values in as well as
	 *	a value for the number of elements that are in said array.	*/
	OrderedIntList ()
	{
			intArray = new int[10];
			numElements = 0;
	}
	
	/**	Method to insert integer elements into their specific locations	and 
	 *  move all subsequent elements as to maintain ascending order.	
	 *  
	 *  @param userInput Input value to be added to the array.		*/
	
	public void insert (int userInput) {
			
			int insertIndex = 0;
			
			for (int forCounter = 0; forCounter < numElements; forCounter++) {
				
				insertIndex = numElements;
				
				if(userInput <= intArray[forCounter]) {
					
					insertIndex = forCounter;
					
					if(userInput == intArray[forCounter]) {
						insertIndex = intArray.length;
					}
					
					forCounter = numElements;
				}
			}
			
			System.out.println(insertIndex);
			
			if(numElements < intArray.length) {
				numElements++;
			} //Only increments number of elements to the maximum size of the array
			
			if(insertIndex >= intArray.length - 1) {
				insertIndex = intArray.length - 1;
			}  //Insures insertIndex never extends past the max index of the array
			
			if(insertIndex == intArray.length) {}
			else {
				
				for (int forCounter = numElements - 1; forCounter > insertIndex; forCounter--) {
					intArray[forCounter] = intArray[(forCounter - 1)];
				}
				
				intArray[insertIndex] = userInput;
				
			}
			
	}
	/** Method to print all user inserted values within the array in lines of 5 elements per line.	*/
	public void print () {
		
		for (int forCounter = 0; forCounter < numElements; forCounter++) {
			
			if (forCounter % 5 == 0) System.out.println();
			
			System.out.print(intArray[forCounter] + "\t"); }
	}
}
