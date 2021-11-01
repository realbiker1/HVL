package opg5;

public class Sortering {
	
	public static void selectionSort(int[] tab) {
		long start = System.currentTimeMillis();
		int temp;
		
		for (int i = 0; i < tab.length - 1; i++) {
			int min_index = i;
			for (int j = i + 1; j < tab.length; j++) {			
				if (tab[j] < tab[min_index]) {
					min_index = j;
				}
			}
			temp = tab[min_index];
			tab[min_index] = tab[i];
			tab[i] = temp;		
		}
		logTime(start, "Selection sort");
	}
	
	public static void insertionSort(int tab[]) {
		long start = System.currentTimeMillis();	
		
        for (int i = 1; i < tab.length; ++i) {
        	
            int key = tab[i];
            int j = i - 1;
   
            while (j >= 0 && tab[j] > key) {
                tab[j + 1] = tab[j];
                j = j - 1;
            }
            tab[j + 1] = key;
        }
        logTime(start, "Insertion sort");
    }
	public static void mergeSort(int[] tab) {
		long start = System.currentTimeMillis();
		mergeSortRec(tab, 0, tab.length - 1);
		logTime(start, "Merge sort");
	}
	
	private static void mergeSortRec(int[] tab, int venstre, int hoyre) {
		
		if (venstre < hoyre) {
			
			int midten = (hoyre + venstre) / 2;					
			mergeSortRec(tab, venstre, midten);
			mergeSortRec(tab, midten+1, hoyre);
			merge(tab, venstre, midten, hoyre);
		}
			
	}
	
	private static void merge(int tab[], int venstre, int midten, int hoyre) {
	
		int[] temp = new int[hoyre - venstre + 1];
		
		int i = venstre;
		int k = 0;
		int j = midten+1;
		
		while (i <= midten && j <= hoyre) {
			
			if(tab[i] <= tab[j]) {
				temp[k] = tab[i];	
				k += 1;
				i += 1;
			} else {
				temp[k] = tab[j];
				k += 1;
				j += 1;
			}		
		}
		
		while(i <= midten) {
			temp[k] = tab[i];
			i += 1; 
			k += 1;
		}

		while(j <= hoyre) {
			temp[k] = tab[j];
			k += 1; 
			j += 1;
		}

		for(int x = venstre; x <= hoyre; x++) {
			
			tab[x] = temp[x - venstre];
		}
	}
	
	public static void quickSort(int[] arr, int venstre, int hoyre) {
	    
		if (venstre < hoyre) {
	         
	        int pi = partition(arr, venstre, hoyre);
	
	        quickSort(arr, venstre, pi - 1);
	        quickSort(arr, pi + 1, hoyre);
	    }
	}
	
	static int partition(int[] arr, int low, int high)
	{
	     
	    // pivot
	    int pivot = arr[high];
	     
	    // Index of smaller element and
	    // indicates the right position
	    // of pivot found so far
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	         
	        // If current element is smaller
	        // than the pivot
	        if (arr[j] < pivot)
	        {
	             
	            // Increment index of
	            // smaller element
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    Tabell.printTab(arr);
	    return (i + 1);
	}
	
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	private static void logTime(long start, String sortMethod) {
		long end = System.currentTimeMillis();	
		System.out.println(sortMethod + " (" + (end - start) + "ms)");		
	}
	
	
	
	

}
