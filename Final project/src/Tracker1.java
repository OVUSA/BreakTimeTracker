import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.format.DateTimeFormatter; 

public class Tracker1 {
	
	static ArrayList<String> startWork= new ArrayList<String>();
	static ArrayList<String> stopWork= new ArrayList<String>();   
	static ArrayList<String> startBreak= new ArrayList<String>(); 
	static ArrayList<String> stopBreak= new ArrayList<String>();    
	static ArrayList<String> DurationBreak= new ArrayList<String>(); 
	    
	
		
	long hour = (1000*60)*60 ;
	static long minute = 1000*60;
	long second = 1000;
	


	public static void StartWork() { 
	//long startTime = System.currentTimeMillis(); 
	LocalTime sTime = LocalTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");  
	String formattedDate = sTime.format(myFormatObj);  
	System.out.println("Started work at: " + formattedDate); 
	startWork.add(formattedDate);
	//Duration(sTime);
	
	}
	
	public static void StartBreak() {
		LocalTime sTime = LocalTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String formattedDate = sTime.format(myFormatObj);  
		System.out.println("Started break at: " + formattedDate); 
		
	  }
	public static long  StopBreak() {  
		long endTime = System.currentTimeMillis();
		LocalTime eTime = LocalTime.now();
		
		// formating time        
		DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String formattedDateStop = eTime.format(myFormatObj1);  
		System.out.println("Finish a break at: " + formattedDateStop); 
		stopBreak.add(formattedDateStop);
		return endTime;
		}
	public static void  StopWork() {  
			System.currentTimeMillis();
			LocalTime eTime = LocalTime.now();
			// formating time        
			DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("HH:mm:ss");  
			String formattedDateStop = eTime.format(myFormatObj1);  
			System.out.println("Finish work at: " + formattedDateStop); 
			stopWork.add(formattedDateStop);
			//Duration(eTime);
			}
	

public LocalTime getObject(LocalTime sTime) {
	
	return sTime;
}
	
/*public static void Duration(LocalTime eTime ) {

	int number = Integer.parseInt(eTime);
	int number1 = Integer.parseInt(sTime);
	
	int differ = number - number1;
		
		System.out.println("Time difference: " + differ/ 1000);
        
		 
		
	}
	
	
	*/
	
	
	
	public static void myLoop (int amount) {
		
		for(int i=0; i< amount; i++) {
		    try {
		        Thread.sleep(1000);
		    } catch (InterruptedException e) {
		       
		        e.printStackTrace();
		    }
		}
	}


	public static void print(String  element) { //CHECK AN ARRAY
	  
	  for ( int i = 0 ; i < 1; i++) {
		  element=startWork.get(i);
		  System.out.println( "you started work at: "+ element);
	  	}
	}
	

	  


	



	


	
	
	
	public static char userInput(Scanner scnr) { // read user input
		char answer = scnr.next().charAt(0);
		return answer;
		
		
	}
	

}
