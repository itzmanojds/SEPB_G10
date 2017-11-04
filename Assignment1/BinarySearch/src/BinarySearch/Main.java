package BinarySearch;

import java.util.Scanner;

/****************************************************************/
//Group.....................................: G10
//1.		Manojkumar Devaraya Shenoy, 			Matrikel-Nr : 478610
//2.		Krishna Viswanathan Janardhanan,		Matrikel-Nr : 480282
//3.		Kumar Ekambaram,						Matrikel-Nr : 
//4.		Ashiya,								Matrikel-Nr : 480237
//5.		Priyanka Nagaraj,		 			Matrikel-Nr : 
//6.		Ananya Sagara Neelakanta Jois, 		Matrikel-Nr : 
//7.		Jayrajsinh Vajesinh Parmar, 			Matrikel-Nr : 
/****************************************************************/

public class Main {

	public static void main(String[] args) {	
		
		//Array declaration and initialization with sorted values
		int[] intArray = { 2, 4, 6, 9, 15, 17, 21, 34, 54, 54, 66, 66, 91, 98, 156, 172, 190, 312, 477, 519};
		
		//This variable to keep input value to be searched 
		int search_number=0;
		
		int array_length = intArray.length;
		
		
		System.out.println("Array content is:");
		
		//To print all content of Array
		for(int i= 0; i < array_length; i++) 
		{
			System.out.print(intArray[i] +"\t");
		}
		
		System.out.println("");
		
		System.out.println("Enter the number to be searched");
		
		//To read user input
	    Scanner scanner=new Scanner(System.in);
	    search_number = scanner.nextInt(); //Reading input as integer
	    scanner.close(); //Closing the scanner
	    
	    //Function call for Finding the nearest position
	    int position = binary_search(intArray, 0, array_length-1, search_number);
	    
	    
	    if(position<array_length)
	    {
	    		System.out.println("Nearest position : [" + position + "], Nearest value : "+intArray[position]);
	    }
	    
	    
	    /* For 2 same number search
	    if (intArray[position] == search_number)																// If searching number is one of the elements in the intArray
	    {
		    	//if( (intArray[position] != intArray[0]) && (intArray[position] == intArray[position-1]))	
	    		if( (position !=0) && (intArray[position] == intArray[position-1]))	// Checking if position is not the first position and if previous value is same as the element at the returned position 
		    	{
		    		System.out.println("Same number is in positions [" + (position-1) + "] and [" + position + "]") ;
		    	}
		    	else if((position != array_length-1) && (intArray[position] == intArray[position+1]))	// Checking if position is not the last position and if next value is same as the element at the returned position
		    	{
		    		System.out.println("Same number is in positions [" + position + "] and [" +  (position+1) + "]") ;
		    	}
		    	else
		    	{
		    		System.out.println("Same number is in position [" + position + "]") ;					// Executed when numbers are not repeating twice
		    	}
	    }
	    else if (intArray[position] != search_number)															// If searching number is one of the elements in the intArray
	    {
	    		//if((intArray[position] != intArray[0]) && (intArray[position] == intArray[position-1]))
		    	if((position != 0) && (intArray[position] == intArray[position-1]))						// Checking if position is not the first position and if previous value is same as the element at the returned position 
		    	{
		    		System.out.println("The nearest positions are [" + (position-1) + "] and [" + position + "]" + "\nNearest value is "+intArray[position]);
		    	}
		    	else if((position != array_length-1) && (intArray[position] == intArray[position+1]))	// Checking if position is not the last position and if next value is same as the element at the returned position
		    	{
		    		System.out.println("The nearest positions are [" + position + "] and [" + (position+1) + "]" + "\nNearest value is "+intArray[position]);
		    	}
		    	else
		    	{
		    		System.out.println("The nearest position is [" + position + "]\n and the nearest value is "+intArray[position]);  // Executed when numbers are not repeating twice
		    	}
	    }
	    */
	}
	
	
		
	public static int binary_search(int[] intArray,int first_position, int last_position, int search_number)	{
			
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
				if ((intArray[mid_position] == search_number)) {					
					return mid_position;								
				}
				
				// Check if the number to be searched is less than the middle value
				else if(search_number < intArray[mid_position])					
				{
					// Calculate the difference between the number to be searched from the middle value and element before middle value
					int Diff_With_Mid = Math.abs(intArray[mid_position]-search_number); 			//Absolute value
					int Diff_With_Mid_Minus_1 = Math.abs(search_number-intArray[mid_position-1]); //Absolute value
					
					// Compare the differences
					//if difference with mid is greater, take left part of array
					if(Diff_With_Mid >= Diff_With_Mid_Minus_1)
					{
						return binary_search(intArray,first_position,mid_position-1,search_number); //Do recursive search with values before middle value
					}
					
					else if(Diff_With_Mid < Diff_With_Mid_Minus_1)
					{
						return mid_position;									
					}
					//if difference are equal return mid-1
					// Return lower nearest value if the searching number is between both the values i.e. if differences are same
					//else if(Diff_With_Mid == Diff_With_Mid_Minus_1)
					//{
					//	return (mid_position-1);								
					//}
				}
				// Check if the number to be searched is greater than the middle value
				else if(search_number > intArray[mid_position])					
				{
					// Calculate the difference between the number to be searched from the middle value and element next middle value
					int Difference_With_Mid = Math.abs(search_number-intArray[mid_position]);				//Absolute value
					int Difference_With_Mid_Plus_1 = Math.abs(intArray[mid_position+1]-search_number);	//Absolute value
					
					// Compare the differences
					//if difference with mid is greater, take right part of array
					if(Difference_With_Mid > Difference_With_Mid_Plus_1)
					{
						return binary_search(intArray,mid_position+1,last_position,search_number); //Do recursive search with values after middle value
					}
					//if difference with mid+1 is lesser, return mid position, since mid_position is neared
					else if(Difference_With_Mid < Difference_With_Mid_Plus_1)
					{
						return mid_position;								// Return middle value position is it near
					}
					//if difference are equal return mid+1
					else if(Difference_With_Mid == Difference_With_Mid_Plus_1)
					{
						if(intArray[mid_position] == intArray[mid_position+1])
						{
							//Do recursive search with values after middle value, if 2 values (middle value and next element) are same
							return binary_search(intArray,mid_position+1,last_position,search_number); 
						}
						else
						{
							// Return middle value position if next number also at the same distance from searching number
							return mid_position;							
						}
					} 
				}
				return -1;													// Default return value
			}
	}

}
