package phoneBook_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DISPLAYrecords {
	
	/**
	    * This method Display() uses the scanner class to go through the entire file 
	    * and outputs the information onto the console.
	    */
	    public void Display() throws ArrayIndexOutOfBoundsException{
	        try{
	            Scanner pageReader = new Scanner(new File("PhoneBook.txt"));
	            String data;
	            //While loop finds all the contacts in order.
	            while(pageReader.hasNextLine()){
	                data = pageReader.nextLine();
	                String[] info = new String[5];
	                info = data.split(",");
	                //This is a if statement that will prevent the program from crashing should it encounter an empty line
	                if(data.isEmpty()){
	                    continue;
	                }
	                //This for loop goes throught the different pieces of information about the contact.
	                for(int i = 0; i < 5; i++){
	                    System.out.print(info[i] + " ");
	                }
	                System.out.println("");
	            }
	            System.out.println("\nThese are all the available records.");
	        }
	        catch(FileNotFoundException e){
	            System.out.println("An error ocured while displaying the records!");
	        }
	    }


}
