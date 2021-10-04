package phoneBook_Project;

import java.util.*;
import java.io.*;

public class ADDrecords {
	
	String firstName;
    String lastName;
    String address;
    String city;
    int phonenumber;
    /**
     * The Add() Method here is used to add a new contact to the "PhoneBook.txt" file.
     * @param firstName String value for the first Name of the contact
     * @param lastName String value for the last Name of the contact
     * @param address String value for the address Name of the contact
     * @param city String value for the city of the contact
     * @param phonenumber int value for the phone number of the contact
     */
    public void Add() throws InputMismatchException{
        try{
            /**
             * First part: Getting user to input the required information.
             */
            System.out.println("Adding to Phone Book.....");
            //The 'firstN' will be accepted by the Scanner(System.in) and stored in the firstName variable
            System.out.print("Please enter the First Name: ");
            Scanner firstN = new Scanner(System.in);
            this.firstName = firstN.nextLine();

            //The 'lastN' will be accepted by the Scanner(System.in) and stored in the lastName variable
            System.out.print("Please enter the last name: ");
            Scanner lastN = new Scanner(System.in);
            this.lastName = lastN.nextLine();

            //The 'addRess' will be accepted by the Scanner(System.in) and stored in the address variable
            System.out.print("Please enter the address: ");
            Scanner addRess = new Scanner(System.in);
            this.address = addRess.nextLine();

            //The 'ciTy' will be accepted by the Scanner(System.in) and stored in the city variable
            System.out.print("Please enter the City: ");
            Scanner ciTy = new Scanner(System.in);
            this.city = ciTy.nextLine();

            //The 'phoneNumber' will be accepted by the Scanner(System.in) and stored in the phonenumber variable
            System.out.println("Phone number must have less than 10 numbers.");
            System.out.print("Please enter the Phone number: ");
            Scanner phoneNumber = new Scanner(System.in);
            this.phonenumber = phoneNumber.nextInt();

            System.out.println("New Contact: " + firstName + " " + lastName + " " + address + " " + city + " " + phonenumber );
            
            
            /**
             * Second Part: Writing all of the information into the PhoneBook.txt file.
             */
            FileWriter addWriter = new FileWriter("PhoneBook.txt",true);
            addWriter.append( "\n" + firstName + "," + lastName + "," + address + "," + city + "," + phonenumber);
            addWriter.close();
            System.out.println("Has been added to the file.");
            
        }
        catch(Exception e){
            System.out.println("An error has occured while adding contact.");
            e.printStackTrace();
        }
    }

}
