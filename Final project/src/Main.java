
import java.io.IOException;
import java.util.Scanner;



public class Main {
	
	public static void main (String[]args) throws IOException  {
		Tracker2 time = new Tracker2();
		
		Scanner scnr = new Scanner( System.in);
		System.out.println("Hello, what's your name?");
		
		Tracker2.setName(Tracker2.userName(scnr));
		
    	System.out.println("Press 'w'  to start working,\n"
    			           + "    'b' to start a break \n" + 
    			    			"    'e' to end the session.");
    	char inputUser = Tracker2.userInput(scnr);
    	
     	while (inputUser != 'e'){
    	
     		if (inputUser == 'w') {
				Tracker2.WorkTime();
				}
				else if (inputUser == 'b'){
				Tracker2.BreakTime();
			}
			System.out.println("Do you want to proceed?");
			inputUser = Tracker2.userInput(scnr);
				
    	} 
  		System.out.println("You chose to end the session, here is a daily report \n");
  		Tracker2.report();
	
  		
        Tracker2.printReport();// write a file
		System.exit(0);  	
		
		}
	}

 
	
