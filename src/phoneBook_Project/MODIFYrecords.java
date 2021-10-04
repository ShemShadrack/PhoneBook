package phoneBook_Project;

import java.util.*;
import java.io.*;

public class MODIFYrecords {
	
	public void Modify() throws ArrayIndexOutOfBoundsException, InputMismatchException {
        try{
            /**
             * First part: Getting the desired information from the user for which specifies
             * contact is to be modified.
             */
            System.out.println("which contact would you like to modify?");
            System.out.println("Please enter a LAST NAME or a PHONE NUMBER or a CITY");
            Scanner userQueryScan = new Scanner(System.in);
            String userQuery = userQueryScan.nextLine();
            
            
            /**
             * Second part: Locating desired contact.
             */
            Scanner contactScanner = new Scanner(new File("PhoneBook.txt"));
            String tobeModified;
            String requiredData = "";
            //This first loop statement loops through the contacts.
            while(contactScanner.hasNextLine()){
                tobeModified = contactScanner.nextLine();
                String[] modedData = new String[5];
                modedData = tobeModified.split(",");
                //This is a if statement that will prevent the program from crashing should it encounter an empty line
                if(tobeModified.isEmpty()){
                    continue;
                }
                //This inner for loop is to separate all the pieces of data available for a single contact.
                for(int i = 0; i < 5; i++){
                    if(modedData[1].equals(userQuery) || modedData[3].equals(userQuery) || modedData[4].equals(userQuery)){
                        requiredData = tobeModified;
                    }
                }
            }
            System.out.println("\n" + "The required data: " + "\n" + requiredData + "\n");
            
            
            /**
             * Third part: allowing the user to update the information.
             */
            String newUpdate = new String();
            if(requiredData.isBlank()){
                System.out.println("No record found to Modify");
            }
            else{
                System.out.println("Please enter the new data to be updated: ");
                //The 'firstN' will be accepted by the Scanner(System.in) and stored in the firstName variable
                System.out.print("Please enter the First Name: ");
                Scanner firstN = new Scanner(System.in);
                String firstName = firstN.nextLine();
                //The 'lastN' will be accepted by the Scanner(System.in) and stored in the lastName variable
                System.out.print("Please enter the last name: ");
                Scanner lastN = new Scanner(System.in);
                String lastName = lastN.nextLine();
                //The 'addRess' will be accepted by the Scanner(System.in) and stored in the address variable
                System.out.print("Please enter the address: ");
                Scanner addRess = new Scanner(System.in);
                String address = addRess.nextLine();
                //The 'ciTy' will be accepted by the Scanner(System.in) and stored in the city variable
                System.out.print("Please enter the City: ");
                Scanner ciTy = new Scanner(System.in);
                String city = ciTy.nextLine();
                //The 'phoneNumber' will be accepted by the Scanner(System.in) and stored in the phonenumber variable
                System.out.println("Phone number must have less than 10 numbers.");
                System.out.print("Please enter the Phone number: ");
                Scanner phoneNumber = new Scanner(System.in);
                int phonenumber = phoneNumber.nextInt();
                
                newUpdate = firstName + "," + lastName + "," + address + "," + city + "," + phonenumber;
            }
            
            
            /**
             * Fourth part: creating a new file with the newly updated information.
             */
            Scanner modifyingContactScan = new Scanner(new File("PhoneBook.txt"));
            String modifyingContact;
            File modifyFile = new File("Modified.txt");
            FileWriter modFile = new FileWriter(modifyFile);
            System.out.println( "\n" + "The following contacts will remain Unchanged: ");
            while(modifyingContactScan.hasNextLine()){
                modifyingContact = modifyingContactScan.nextLine();
                if(modifyingContact.equals(requiredData)){
                    continue;
                }
                else{
                    System.out.println(modifyingContact);
                    modFile.append(modifyingContact + "\n");
                }
                
            }
            modFile.append(newUpdate + "\n");
            modFile.close();
            
            /**
             * Fifth part: Renaming the "Modified.txt" file to become the new "PhoneBook.txt" after deleting the old "PhoneBook.txt" 
             */
            File phoneBookObj = new File("PhoneBook.txt");
            phoneBookObj.delete();
            modifyFile.renameTo(phoneBookObj);
            
        }
        catch(IOException e){
            System.out.println("An error has occured while modifying a record.");
            e.printStackTrace();
        }
    }

}
