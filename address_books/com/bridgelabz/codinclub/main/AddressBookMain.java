package com.bridgelabz.codinclub.main;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.*;

public class AddressBookMain{
	public static void main(String args[]){
		final AddressBookServices addressBookServices;
		ArrayList<Person> personList = new ArrayList<>();
		addressBookServices = new AddressBookServicesImpl();
		while(true){
   			System.out.println("Enter your choice: \n1.Add Contact \n2.View Contact \n3.Update Contact \n4.Delete Contact \n5.Sort Address Book");
			int choice = AddressBookUtil.getUserInput();
   			switch(choice){
   			case 1:
				System.out.println("Add person in Address Book:");
				addressBookServices.addPerson(personList);
				System.out.println(">>>>>>>>Contact Added<<<<<<<<<<");
   			break;
   			case 2:
        			System.out.println("View Contact");
				addressBookServices.viewContact(personList);
   			break;
  			case 3:
      				System.out.println("update");
				personList = addressBookServices.editContact(personList);
				System.out.println(">>>>>>>>Contact updated<<<<<<<<<");
   			break;
			case 4:
				System.out.println("Delete Contact");
				personList = addressBookServices.deleteContact(personList);
				System.out.println(">>>>>>>>Contact deleted<<<<<<<<<");
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
