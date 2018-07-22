package findMatrix;

public class findMatrix {
	
	//
	static int calculateDeterminat(int a, int b, int c, int d, int e, int f, int g, int h, int i){
		return a*e*i + b*f*g + c*d*h - c*e*g - a*f*h - b*d*i;
	}
	
	static boolean includedInArray(int[] array, int var){
		for(int i = 0; i < array.length; i++) {
			//if(array[i] == 0) continue;
			if(array[i] == var) return true;
		}
		return false;
	}
	
	
	static boolean arrayFilled(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 0) return false;
		}
		return true;
	}
	
	static void recurringTesting(int[] array, int index, int equals) {
		if(array.length == index) {
			
			if(calculateDeterminat(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]) == equals){
				for(int i = 0; i < array.length; i++) {
					System.out.print(array[i] + "	");
					if(i % 3 == 2)	System.out.print("\n");
				}
				System.out.print("\n");
			}
			return;
		}
		
		for(int i = 1; i <= array.length; i++) {
			if(includedInArray(array, i)){
				continue;
			}
			array[index] = i;
			recurringTesting(array, index + 1, equals);
			array[index] = 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Input please");
			return;
		}
		int input =Integer.parseInt(args[0]);
		
		int[] array = new int[9];
		recurringTesting(array, 0, input);
	}
}
