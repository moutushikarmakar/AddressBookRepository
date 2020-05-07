package com.bridgelabz.codinclub.utils;
import com.bridgelabz.codinclub.main.AddressBookMain;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.*;

/**
*Address Book Repo class
*@author Moutusi Karmakar
*/
public class AddressBookRepo{
	
	/**
	*addToAddressBook method adds the new contact to the Address Book CSV file
	*@param object of type Person
	*@param ArrayList of type Person
	*/
	public void addToAddressBook(final Person person,ArrayList<Person> addPersonList){
		addPersonList.add(person);
		AddressBookFileOperations.writeFile(addPersonList);
	}
	
	/**
	*updateToAddressBook method updates the Address Book CSV file with the chnaged contact
	*@param Arraylist of type Person
	*/
	public void updateToAddressBook(ArrayList<Person> editPersonList){
		AddressBookFileOperations.writeFile(editPersonList);
		AddressBookFileOperations.readFile();
	}
	
	/**
	*deleteFromAddressBook method deletes the contact from the Address Book CSV file
	*@param Arraylist of type Person
	*/
	public void deleteFromAddressBook(ArrayList<Person> deletePersonList){
		AddressBookFileOperations.writeFile(deletePersonList);
	}
	
	/**
	*sortAddressBook saves the sorted Address Book in the Address Book CSV file
	*@param Arraylist of type Person
	*/
	public void sortAddressBook(ArrayList<Person> sortPersonList){
		AddressBookFileOperations.writeFile(sortPersonList);
		AddressBookFileOperations.readFile();
	}
}
