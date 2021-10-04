package phoneBook_Project;

import java.io.*;
import java.util.*;

public class COUNTrecords {
	
	 public void Countrecords() throws ArrayIndexOutOfBoundsException{
	        try{
	            int count = 0;
	            Scanner countScanner = new Scanner(new File("PhoneBook.txt"));
	            String counttoString;
	            while(countScanner.hasNextLine()){
	                counttoString = countScanner.nextLine();
	                String[] countArr = new String[5];
	                countArr = counttoString.split(",");
	                //This is a if statement that will prevent the program from crashing should it encounter an empty line
	                if(counttoString.isEmpty()){
	                    continue;
	                }
	                for(int i = 0; i < 5; i++){
	                    System.out.print(countArr[i] + " ");
	                }
	                System.out.println(" ");
	                count++;
	            }
	            System.out.println( "\n" + "There are " + count + " contacts on your contact list.");
	        }
	        catch(FileNotFoundException e){
	            System.out.println("Error found while counting the records!");
	        }
	}


}
