import java.util.HashMap;
import java.util.Map;

public class CellularAutomataUtils {
	
	//convert an integer to its 8-bit binary equivalent
	public String inputToBinaryEightBit(int num) {
		
		String binaryNum = Integer.toBinaryString(num);
		String eightBitString = "";
		int diffFromEightBits = 8 - binaryNum.length();
		
		if(diffFromEightBits > 0) {
			for(int i = 1; i <= diffFromEightBits; i++) {
				eightBitString += "0";
			}
		}
		
		eightBitString += binaryNum;
		
		return eightBitString;
		
	}

	//initilize the standard input array with all zeros, value of one in middle
	public int[] initArray(int numCells) {
		
		int[] inputArray = new int[numCells];
		int middleIndex = inputArray.length / 2;

		for (int i = 0; i < inputArray.length; i++) {
		    inputArray[i] = 0;
		}

		inputArray[middleIndex] = 1;
		
		return inputArray;
		
	}
	
	//desired output for our initial input array (integer)
	public String inputArrayToString(int[] array) {
        
		StringBuilder sb = new StringBuilder();
        
		for (int i = 0; i < array.length; i++) {
			
			if(array[i] == 0) {
				sb.append('.');
			}
			
			else {
				sb.append('X');
			}
			
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
       
        return sb.toString();
    }
	
	//desired output for our repeating array (character)
	public String newArrayToString(char[] array) {
        
		StringBuilder sb = new StringBuilder();
        
		for (int i = 0; i < array.length; i++) {
           
			if(array[i] == '0') {
				sb.append('.');
			}
			
			else {
				sb.append('X');
			}
			
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
       
        return sb.toString();
    }
	
	//key value pairs that represent eight possible patterns and their transition rules
	//based on binary equivalent of user entered decimal rule number
	public Map<String, Character> initTransitionRules(String binaryEightBit){
		
		Map<String, Character> transitionRules = new HashMap<>();
		 
		 transitionRules.put("000", binaryEightBit.charAt(7));
		 transitionRules.put("001", binaryEightBit.charAt(6));
		 transitionRules.put("010", binaryEightBit.charAt(5));
		 transitionRules.put("011", binaryEightBit.charAt(4));
		 transitionRules.put("100", binaryEightBit.charAt(3));
		 transitionRules.put("101", binaryEightBit.charAt(2));
		 transitionRules.put("110", binaryEightBit.charAt(1));
		 transitionRules.put("111", binaryEightBit.charAt(0));
		 
		 return transitionRules;
		
	}

}
