package com.bridgelabz.codinclub.utils;
import com.bridgelabz.codinclub.main.AddressBookMain;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.Scanner;
import java.util.*;

public class AddressBookUtil{
	private final static Scanner scanner = new Scanner(System.in);
	public static int getUserInput(){
		return scanner.nextInt();
	}

	public static Comparator<Person> sortByFname = new Comparator<Person>(){
		public int compare(Person a, Person b){
			return (a.firstname).compareTo(b.firstname);
		}
	};

	public static Comparator<Person> sortByLname = new Comparator<Person>(){
                public int compare(Person a, Person b){
                        return (a.lastname).compareTo(b.lastname);
                }
        };

	public static Comparator<Person> sortByZip = new Comparator<Person>(){
                public int compare(Person a, Person b){
                        return a.zip-b.zip;
                }
        };

}
