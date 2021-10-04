package phoneBook_Project;

import java.io.*;
import java.util.Scanner;

public class PhoneBook {


    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {
        try{
            System.out.println("\tPhone Book eProject. ");
        
            //This is the creation of the fie and confirmation of creation of the required file.
            File file = new File("PhoneBook.txt");
            if(file.exists()){
                System.out.println( file.getName() + " Exists");
            }
            else{
                System.out.println("File doesn't exist");
                System.out.println("File is being created.....");
                file.createNewFile();
            }
        
        //This is where the user will choose what they want to do either to ADD, DELETE, MODIFY, COUNT and SEARCH
        while(true){
            System.out.println( "\n" + "Please use one of the following Key words: \nADD, DELETE, DISPLAY, MODIFY, COUNT , SEARCH , EXIT");
            System.out.print("Please choose what you would like to do: ");
            Scanner mainMenuScan = new Scanner(System.in);
            String menuChoice = mainMenuScan.next().toUpperCase();
            System.out.println("You have chosen to " + menuChoice + "\n");
            if(menuChoice.equals("ADD")){
                //The ADD records part of the program will write the contact to the file.
                ADDrecords addObj = new ADDrecords();
                addObj.Add();
            }
            else if(menuChoice.equals("DELETE")){
                //The DELETE records part of the program will delete a contact the phonebook.
                DELETErecords deleteObj = new DELETErecords();
                deleteObj.Delete();
            }
            else if(menuChoice.equals("MODIFY")){
                //The MODIFY records part of the program will modify a specific contact.
                MODIFYrecords modifyObj = new MODIFYrecords();
                modifyObj.Modify();
            }
            else if(menuChoice.equals("COUNT")){
                COUNTrecords countObj = new COUNTrecords();
                countObj.Countrecords();
            }
            else if(menuChoice.equals("SEARCH")){
                SEARCHrecords searchObj = new SEARCHrecords();
                searchObj.Search();
            }
            else if(menuChoice.equals("DISPLAY")){
                DISPLAYrecords displayObj = new DISPLAYrecords();
                displayObj.Display();
            }
            else if(menuChoice.equals("EXIT")){
                break;
            }
            else if(menuChoice.isEmpty()){
                System.out.println("Please enter one of the choices.");
            }
            else{
                System.out.println("Please enter one of the choices.");
            }
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
}

	
}
