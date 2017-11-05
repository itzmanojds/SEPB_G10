/***************************************************************/
/* 
 *	Baselined as v1.0, Dated 05-Nov-2017
 *	This program takes the integer value from user as input and
 *	searches the nearest position and value in the array for the 
 * 	input given.
*/ 
/***************************************************************/

/****************************************************************/
//Group.....................................: G10
//1.		Manojkumar Devaraya Shenoy, 			Matrikel-Nr : 478610
//2.		Krishna Viswanathan Janardhanan,		Matrikel-Nr : 480282
//3.		Kumar Ekambaram,						Matrikel-Nr : 479211
//4.		Ashiya,								Matrikel-Nr : 480237
//5.		Priyanka Nagaraj,		 			Matrikel-Nr : 479240
//6.		Ananya Sagara Neelakanta Jois, 		Matrikel-Nr : 480378
//7.		Jayrajsinh Vajesinh Parmar, 			Matrikel-Nr : 483791
/****************************************************************/


package BinarySearch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		
		//Array declaration and initialization with sorted values
		int[] intArray = { -1, 4, 6, 9, 15, 17, 21, 54, 54, 54, 55, 66, 66, 98, 156, 172, 190, 312, 477, 519 };
		
		//This variable to keep input value to be searched 
		int searchNumber=0;
		
		int arrayLength = intArray.length;
		
		
		System.out.println("Array content is:");
		
		//To print all content of Array
		for(int i= 0; i < arrayLength; i++) 
		{
			System.out.print("["+i+"]\t");
		}
		System.out.println("");
		//To print all content of Array
		for(int i= 0; i < arrayLength; i++) 
		{
			System.out.print(intArray[i] +"\t");
		}
		
		
		System.out.println("\nEnter the number to be searched");
		
		//To read user input
	    Scanner scanner=new Scanner(System.in);
	    try {
			searchNumber = scanner.nextInt(); //Reading input as integer
		} 
	    catch (InputMismatchException e) {
	    		scanner.close(); //Closing the scanner
			System.out.println("Only numbers are allowed.");
			System.out.println("Exitting program, Please Restart the program.");
			return;
		}
	    scanner.close(); //Closing the scanner
	    
	    //Function call for Finding the nearest position
	    int position = binary_search(intArray, 0, arrayLength-1, searchNumber);
	    
	    
	    if(position<arrayLength)
	    {
	    		System.out.println("Nearest position : [" + position + "], Nearest value : "+intArray[position]);
	    }
	}
	
	
		
	public static int binary_search(int[] intArray,int first_position, int last_position, int searchNumber)	{
			
			// If the searching number is first or last element of the intArray
			if(first_position==last_position)									
			{
				return first_position;
			}
			else
			{
				//Calculating the middle position
				int mid_position = (last_position + first_position )/2; 		
			
				
				//Check if the number to be searched is same as middle value
				if (intArray[mid_position] == searchNumber) {	
					if (intArray[mid_position-1] == searchNumber) 
					{
						return binary_search(intArray,first_position,mid_position-1,searchNumber); //Do recursive search with values before middle value
					}
					else
					return mid_position;								
				}
				
				// Check if the number to be searched is less than the middle value
				else if(searchNumber < intArray[mid_position])					
				{
					// Calculate the difference between the number to be searched from the middle value and element before middle value
					int diffWithMid = Math.abs(intArray[mid_position]-searchNumber); 			//Absolute value
					int diffWithMidMinus1 = Math.abs(searchNumber-intArray[mid_position-1]); //Absolute value
					
					// Compare the differences
					//if difference with mid is greater, take left part of array
					if(diffWithMid >= diffWithMidMinus1)
					{
						return binary_search(intArray,first_position,mid_position-1,searchNumber); //Do recursive search with values before middle value
					}
					
					else if(diffWithMid < diffWithMidMinus1)
					{
						return mid_position;									
					}
				}
				// Check if the number to be searched is greater than the middle value
				else if(searchNumber > intArray[mid_position])					
				{
					// Calculate the difference between the number to be searched from the middle value and element next middle value
					int diffWithMid = Math.abs(searchNumber-intArray[mid_position]);				//Absolute value
					int diffWithMidPlus1 = Math.abs(intArray[mid_position+1]-searchNumber);	//Absolute value
					
					// Compare the differences
					//if difference with mid is greater, take right part of array
					if(diffWithMid > diffWithMidPlus1)
					{
						return binary_search(intArray,mid_position+1,last_position,searchNumber); //Do recursive search with values after middle value
					}
					//if difference with mid+1 is lesser, return mid position, since mid_position is neared
					else if(diffWithMid <= diffWithMidPlus1)
					{
						return mid_position;	// Return middle value position is it near
					}
				}
				return -1;// Default return value
			}
		}

}
