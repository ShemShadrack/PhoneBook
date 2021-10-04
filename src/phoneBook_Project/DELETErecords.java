package phoneBook_Project;

import java.io.*;
import java.util.*;

public class DELETErecords {
	
	public void Delete() throws IOException, ArrayIndexOutOfBoundsException{
        try{
            /**
             * First Part: This part will create the "Delete.txt" file that will later be changed to the "PhoneBook.txt"
             */
            File deleteFile = new File("Delete.txt");
            FileWriter deleteFileWriter = new FileWriter("Delete.txt");
            if(deleteFile.exists()){
                System.out.println(deleteFile + " exists.");
            }
            else{
                deleteFile.createNewFile();
                System.out.println(deleteFile + " has been created.");
            }
            
            /**
             * Second Part: Finding the contact to be deleted.
             */
            System.out.println("Please enter a last name or a city or phonenumber of the contact you would like to delete: ");
            Scanner userDeleteQuery = new Scanner(System.in);
            String userDelete = userDeleteQuery.nextLine();
            Scanner userDeleteScan = new Scanner(new File("PhoneBook.txt"));
            String userDeleteScanned;
            String contactToBeDeleted = " ";
            while(userDeleteScan.hasNextLine()){
                userDeleteScanned = userDeleteScan.nextLine();
                String[] userDeleteChoice = new String[5];
                userDeleteChoice = userDeleteScanned.split(",");
                //This is a if statement that will prevent the program from crashing should it encounter an empty line
                if(userDeleteScanned.isEmpty()){
                    continue;
                }
                for(int i = 0; i < 5; i++){
                    if(userDeleteChoice[1].equals(userDelete) || userDeleteChoice[3].equals(userDelete) || userDeleteChoice[4].equals(userDelete)){
                        contactToBeDeleted = userDeleteScanned;
                    }
                }
            }
            System.out.println("Contact to be deleted is " + contactToBeDeleted + " .\n");
            
            /**
             * Third Part: Has the while loop that will print the data from the "PhoneBook.txt" to the new "Delete.txt" file without printing the deleted contact
             */
            if(contactToBeDeleted.isEmpty()){
                System.out.println("No such file exists");
            }
            else{
                Scanner deleteScanner = new Scanner(new File("PhoneBook.txt"));
                String scanned;
                while(deleteScanner.hasNextLine()){
                    scanned = deleteScanner.nextLine();
                    String[] scannedData = new String[5];
                    scannedData = scanned.split(",");
                    if(scanned.isEmpty()){
                        continue;
                    }
                    for(int i = 0; i < 5; i++){
                        
                    }
                    if(scanned.equals(contactToBeDeleted)){
                        continue;
                    }
                    deleteFileWriter.append(scanned + "\n");
                    System.out.println(scanned);
                }
                deleteFileWriter.close();
            }
            
            /**
             * Fourth part: Will make the "Delete.txt" file into the new "PhoneBook.txt"
             */
            File phoneBookObj = new File("PhoneBook.txt");
            phoneBookObj.delete();
            deleteFile.renameTo(phoneBookObj);
            
        }
        catch(Exception e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

}
