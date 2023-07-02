import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Author: Chris Taylor");
		System.out.println("Student ID: 110352632");
		System.out.println("Email ID: taycr003");
		System.out.println("This is my own work as defined by the University's Academic Misconduct Policy.\n");
	
		CellularAutomataUtils c = new CellularAutomataUtils();
		
		Scanner input = new Scanner(System.in);
		
		//determine number of cells requested by user
		boolean isInt = false;
		int numCells = 0;

		//input validation to ensure integer
        while (!isInt) {
            
        	System.out.println("Number of cells?\n");

            if (input.hasNextInt()) {
            	numCells = input.nextInt();
                isInt = true;
            } 
            
            else {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the input buffer
            }
        }
        
        //determine rule number requested by user 
        boolean isEightBitInt = false;
        int ruleNumber = 0;
        
        //input validation to ensure integer and 255 or less
        while (!isEightBitInt) {
            
        	System.out.println("Rule number?\n");

            if (input.hasNextInt()) {
            	ruleNumber = input.nextInt();
            	
            	if (ruleNumber < 256) {
                    isEightBitInt = true;
                } else {
                    System.out.println("Invalid input. Please enter an integer less than 256.");
                }
            	
            } 
            
            else {
            	input.nextLine(); // Clear the input buffer
                System.out.println("Invalid input. Please enter an integer.");
                
            }
        }
        
        //determine number of generations requested by user
        boolean isIntGenerations = false;
        int numGenerations = 0;

        //input validation to ensure integer
        while (!isIntGenerations) {
               
        	System.out.println("Number of generations?\n");

        	if (input.hasNextInt()) {
                 numGenerations = input.nextInt();
                 isIntGenerations = true;
        	} 
                  
        	else {
        		input.nextLine(); // Clear the input buffer
        		System.out.println("Invalid input. Please enter an integer.");
        		
        	}
        }
	    
	    String result = c.inputToBinaryEightBit(ruleNumber);
		
		input.close();
		
		int[] inputArray = c.initArray(numCells);
		
		//below can be used instead if custom input is required (ie: question 4f)
		//int[] inputArray = new int[] {1,0,1,0,1,1,0,1,0};
		
		//hashmap of eight possible patterns and transition rules
		Map<String, Character> transitionRules = c.initTransitionRules(result);
		
		System.out.print("\n" + transitionRules + "\n");
		 
		String nums;
		int arraySize = inputArray.length - 1;
		//stringify array for desired output
		String inputArrayString = c.inputArrayToString(inputArray);
		System.out.print(inputArrayString + "\n");
		
		 for(int i = 1; i <= numGenerations; i++) {
		 
			 char[] newArray = new char[numCells];
			 
			 for (int j = 0; j <= arraySize; j++) {
				 
				 //left-most item in array, so we need the right-most as a neighbor
				 if(j == 0) {
					 nums = Integer.toString(inputArray[arraySize]);
					 nums += Integer.toString(inputArray[j]);
					 nums += Integer.toString(inputArray[j + 1]);
					 //get value from key in hashmap
					 newArray[j] = transitionRules.get(nums);
				 }
				 
				 
				 //right-most item in array, so we need the left-most as a neighbor
				 else if(j == arraySize) {
					 nums = Integer.toString(inputArray[arraySize - 1]);
					 nums += Integer.toString(inputArray[j]);
					 nums += Integer.toString(inputArray[0]);
					 //get value from key in hashmap
					 newArray[j] = transitionRules.get(nums);
				 }
				 
				 //standard neighbors
				 else {
					 nums = Integer.toString(inputArray[j - 1]);
					 nums += Integer.toString(inputArray[j]);
					 nums += Integer.toString(inputArray[j + 1]);
					 //get value from key in hashmap
					 newArray[j] = transitionRules.get(nums);
				}
				    
				
				
			 }
			 
			//stringify array for desired output
			 String newArrayString = c.newArrayToString(newArray);
			 System.out.print(newArrayString + "\n");
			 
			 // Convert newArray from char[] to int[]
			 int[] inputArrayInt = new int[newArray.length];
			 
			 for (int k = 0; k < newArray.length; k++) {
			      inputArrayInt[k] = Character.getNumericValue(newArray[k]);
			    }

			 // Update inputArray with the values from newArray
			 inputArray = inputArrayInt;
			 
		}
		 

	}

}
