package busywait;

public class Main {
	
	private static String melding;
	
	public static void main(String[] args) {
		
		Thread printlnTraad = new Thread(new Runnable() {
			
			@Override
			public void run() {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						  
						e.printStackTrace();
					}
					System.out.println(melding);									
			}
		});
		
		Thread giVerdiTraad = new Thread(new Runnable() {
			
			@Override
			public void run() {
				melding = "Hallo";
			}
		});
		
		printlnTraad.start();
		giVerdiTraad.start();
				
	}

}
