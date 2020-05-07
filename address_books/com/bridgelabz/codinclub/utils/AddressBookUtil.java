package com.bridgelabz.codinclub.utils;
import com.bridgelabz.codinclub.main.AddressBookMain;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.Scanner;
import java.util.*;

/**
*Address Book Util class
*@author Moutusi Karmakar 
*/
public class AddressBookUtil{
	private final static Scanner scanner = new Scanner(System.in);
	
	/**
	*method getUserInput takes integer input from the user and returns it
	*/
	public static int getUserInput(){
		return scanner.nextInt();
	}
	
	/**
	*anonymous class
	*comparator object sortByFname of type Person
	*compare method returns sorted firstname
	*/
	public static Comparator<Person> sortByFname = new Comparator<Person>(){
                public int compare(Person a, Person b){
                        int flag = (a.firstname).compareTo(b.firstname);
                        if(flag == 0){
                                return (a.lastname).compareTo(b.lastname);
                        }
                        else{
                                return flag;
                        }
                }
        };

	/**
	*anonymous class
	*comparator object sortByLname of type Person
	*compare method returns sorted lastname
	*/
	public static Comparator<Person> sortByLname = new Comparator<Person>(){
                public int compare(Person a, Person b){
                        int flag = (a.lastname).compareTo(b.lastname);
                        if(flag == 0){
                                return (a.firstname).compareTo(b.firstname);
                        }
                        else{
                                return flag;
                        }
                }
        };

	/**
	*anonymous class
	*comparator object sortByZip of type Person
	*compare method returns 0,1 and -1 according to the values of Zip 
	*/
	public static Comparator<Person> sortByZip = new Comparator<Person>(){
                public int compare(Person a, Person b){
                        int flag = a.zip-b.zip;
                        if(flag == 0){
                                return (a.firstname).compareTo(b.firstname);
                        }
                        else{
                                return flag;
                        }
                }
        };

}
