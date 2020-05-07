package com.bridgelabz.codinclub.main;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.*;

/**
*Address Book Main class
*Collector class
*@author Moutusi Karmakar
*/
public class AddressBookMain{
	public static void main(String args[]){
		/**
		*Class AddressBookServicesImpl implements the AddressBookServices Interface
		*creating an arraylist 'personList' that stores each record of the address book
		*creating object of AddressBookServicesImpl class
		*/
		final AddressBookServices addressBookServices;
		ArrayList<Person> personList = new ArrayList<>();
		addressBookServices = new AddressBookServicesImpl();
		/**
		*user has options to add contact, view contact, update contact, delete contact and sort address book
		*methods defined for each operation in the implementation of AddressBookServices Interface
		*/
		while(true){
   			System.out.println("Enter your choice: \n1.Add Contact \n2.View Contact \n3.Update Contact \n4.Delete Contact \n5.Sort Address Book");
			int choice = AddressBookUtil.getUserInput();
   			switch(choice){
   			case 1:
				System.out.println("Add Contact:");
				addressBookServices.addPerson(personList);
				System.out.println(">>>>>>>>Contact Added<<<<<<<<<<");
   			break;
   			case 2:
        			System.out.println("View Contact");
				addressBookServices.viewContact(personList);
   			break;
  			case 3:
      				System.out.println("Update Contact");
				personList = addressBookServices.editContact(personList);
				System.out.println(">>>>>>>>Contact Updated<<<<<<<<<");
   			break;
			case 4:
				System.out.println("Delete Contact");
				personList = addressBookServices.deleteContact(personList);
				System.out.println(">>>>>>>>Contact Deleted<<<<<<<<<");
			break;
			case 5:
				System.out.println("Sort Address Book");
				personList = addressBookServices.sortContact(personList);
				System.out.println(">>>>>>>>>Address Book Sorted<<<<<<<<<<<<");
   			default:
      				System.out.println("Please enter correct option!");
   			break;
   			}
		}
	}
}
