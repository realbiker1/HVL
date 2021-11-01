package opg;


public class Kladd {
	
	
	public static void insertionSort(int arr[], int n)
	{
	    int i, key, j;
	    for (i = 1; i < n; i++)
	    {
	        key = arr[i];
	        j = i - 1;
	 
	        System.out.println("j = " + arr[j]);
	        System.out.println("p = " + key);
	        System.out.println("kall");
	        while (j >= 0 && arr[j] > key)
	        {
	        	System.out.println("kall");
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	}
	
	

	public static void main(String[] args) {
		
		int[] intArray = new int[]{ 4,1,7,3,2}; 
		
		insertionSort(intArray, intArray.length);

	}

}
