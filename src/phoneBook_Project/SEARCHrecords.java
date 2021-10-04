package phoneBook_Project;

import java.util.*;
import java.io.*;

public class SEARCHrecords {
	
	 public void Search() throws ArrayIndexOutOfBoundsException{
	        /**
	         * This method will search for a specified contact either by using the Last Name, City and Phone Number.
	         */
	        try{
	            /**
	             * First Part: Will take in the information from the user about the required contact
	             */
	            System.out.println("Please enter the last name or city or phonenumber of the contact you are searching for: ");
	            Scanner userSearchScan = new Scanner(System.in);
	            String userSearch = userSearchScan.nextLine();
	            
	            
	            /**
	             * Second Part: Will use a while loop and a nested for loop to find the required contact
	             */
	            Scanner searchScanner = new Scanner(new File("PhoneBook.txt"));
	            String tobeSearched;
	            String searchedData = "";
	            //while loop
	            while(searchScanner.hasNextLine()){
	                tobeSearched = searchScanner.nextLine();
	                String[] searchData = new String[5];
	                searchData = tobeSearched.split(",");
	                //This is a if statement that will prevent the program from crashing should it encounter an empty line
	                if(tobeSearched.isEmpty()){
	                    continue;
	                }
	                //for loop
	                for(int i = 0; i < 5; i++){
	                    if(searchData[1].equals(userSearch) || searchData[3].equals(userSearch) || searchData[4].equals(userSearch)){
	                        searchedData = tobeSearched;
	                    }
	                }
	            }
	            System.out.println("\n" + "The search result: " + "\n" + searchedData);
	        }
	        catch(Exception e){
	            System.out.println("Error searching for the record");
	            e.printStackTrace();
	        }
	    }


}
