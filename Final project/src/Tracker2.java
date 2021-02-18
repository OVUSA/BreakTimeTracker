
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.format.DateTimeFormatter; 


public class Tracker2 {
	
	
	static ArrayList<String> startWork= new ArrayList<String>();
	static ArrayList<String> stopWork= new ArrayList<String>();   
	static ArrayList<String> startBreak= new ArrayList<String>(); 
	static ArrayList<String> stopBreak= new ArrayList<String>();    
	static ArrayList<Long> DurationBreak= new ArrayList<Long>(); 
	static ArrayList<Long> DurationWork   = new ArrayList<Long>(); 

	private static String name;
	
	public static  void setName(String name) {
		Tracker2. name = name;
	     }
	public static String getName() {
	return name;
	 
}
		
	static long hour = (1000*60)*60 ;
	static long minute = 1000*60;
	static long second = 1000;
	
	
	 public static void getElement() {  //Check array list
		 for ( int i = 0 ; i < startWork.size();i++) {
			 String element = startWork.get(i);
			 System.out.println(i +" of STARTWORK array "+ element);
		 }
		 for ( int i = 0 ; i < stopWork.size();i++) {
			 String element = stopWork.get(i);
			 System.out.println(i +" of STOP WORK array "+ element);
		 } 		 
	 }


	
	public static void BreakTime() { 
	   long startTime = System.currentTimeMillis(); 
	   LocalTime sTime = LocalTime.now();
	   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh:mm:ss");  
	   String formattedDate = sTime.format(myFormatObj);  
	   System.out.println("Started break at: " + formattedDate); 
	   startBreak.add(formattedDate);
	   
	   myLoop(3);
		
	    long endTime = System.currentTimeMillis();
		LocalTime eTime = LocalTime.now();
		// formating time        
		DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");  
		String formattedDateStop = eTime.format(myFormatObj1);  
		System.out.println("Finish a break at: " + formattedDateStop); 
		stopBreak.add(formattedDateStop);
		
		Duration diff = Duration.between(sTime, eTime);
        System.out.println("You have been resting for:" + diff.toHours() + ":" + diff.toMinutes() + ":" + diff.toMillis()/1000); 
        DurationBreak.add((endTime - startTime));
	  
	  }
	
	public static void WorkTime() {  
		long startTime = System.currentTimeMillis(); 
			LocalTime sTime = LocalTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh:mm:ss");  
			String formattedDate = sTime.format(myFormatObj);  
			System.out.println("Started work at: " + formattedDate); 
			startWork.add(formattedDate);
			
				myLoop(2);
		
				long endTime = System.currentTimeMillis();
					LocalTime eTime = LocalTime.now();
					// formating time        
					DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");  
					String formattedDateStop = eTime.format(myFormatObj1);  
					System.out.println("Finish work at: " + formattedDateStop); 
					stopWork.add(formattedDateStop);
					
					Duration diff = Duration.between(sTime, eTime);
					System.out.println("You have been working for:" + diff.toHours() + ":" + diff.toMinutes() + ":" + diff.toMillis()/1000); 

					//System.out.println(("runtime: " + (endTime - startTime)));
					DurationWork .add((endTime - startTime));}
			        
	
	public static void myLoop (long amount) {
		
		for(int i=0; i< amount; i++) {
		    try {
		        Thread.sleep(1000);
		    } catch (InterruptedException e) {
		       
		        e.printStackTrace();
		    }
		}
	}


	public static void print(String  element) { 
	  
	  for ( int i = 0 ; i < 1; i++) {
		  element=startWork.get(i);
		  System.out.println( "you started work at: "+ element);
	  	}
	}
	
	
	public static char userInput(Scanner scnr) { 
		char answer = scnr.next().charAt(0);
		return answer;
	}
	public static String userName(Scanner scnr) { 
		String name = scnr.next();
		return name;
	}

 public static void report() { 
	 
	 System.out.println("User name : "+ getName());
	 LocalDate today = LocalDate.now();
	 long element = 0 ; 
	 System.out.println();
	 System.out.println( "Report for "+ today);
	 System.out.println();
	 System.out.println("Categories \t Duration:");
	 
	 System.out.print(" Work   \t  ");
	 for (int i = 0 ; i < DurationWork.size(); i ++) {
		element = element + DurationWork.get(i);
	 }
		 
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("00:mm:ss");
		 Date date = new Date(element);
		 String time = simpleDateFormat.format(date);
		 System.out.print(time);
 
	 element = 0;
	 System.out.println();
	 System.out.print(" Break   \t  ");
	 for (int i = 0 ; i < DurationBreak.size(); i ++) {
			element = element + DurationBreak.get(i);
		 }
			 SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("00:mm:ss");
			 Date date1 = new Date(element);
			 String time1 = simpleDateFormat1.format(date1);
			 System.out.print(time1);
	 
	 }
  public static void printReport( ) throws IOException {
	  FileOutputStream fileStream = new FileOutputStream("report.txt");
	  PrintWriter pw = new PrintWriter(fileStream);
	   
	  
	// out = new BufferedWriter(new FileWriter());
	pw.println("User name : "+ name);
	 LocalDate today = LocalDate.now();
	 long element = 0 ; 
	 pw.println();
	 pw.println( "Report for "+ today);
	 pw.println();
	 pw.println("Categories \t Duration:");
	 
	 pw.print(" Work   \t  ");
	 for (int i = 0 ; i < DurationWork.size(); i ++) {
		element = element + DurationWork.get(i);
	 }
		 
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("00:mm:ss");
		 Date date = new Date(element);
		 String time = simpleDateFormat.format(date);
		 pw.println(time);
 
	 element = 0;
	 pw.println();
	 pw.print(" Break   \t  ");
	 for (int i = 0 ; i < DurationBreak.size(); i ++) {
			element = element + DurationBreak.get(i);
		 }
			 SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("00:mm:ss");
			 Date date1 = new Date(element);
			 String time1 = simpleDateFormat1.format(date1);
			 pw.println(time1);
			 pw.close();
	  }
	 
 }
 
	 
	 
	 
 

