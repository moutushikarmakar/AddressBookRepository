package com.bridgelabz.codinclub.utils;
import com.bridgelabz.codinclub.main.AddressBookMain;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.*;

public class AddressBookRepo{

	public void addToAddressBook(final Person person,ArrayList<Person> addPersonList){
		addPersonList.add(person);
		AddressBookFileOperations.writeFile(addPersonList);
	}
	public void updateToAddressBook(ArrayList<Person> editPersonList){
		AddressBookFileOperations.writeFile(editPersonList);
		AddressBookFileOperations.readFile();
	}
	public void deleteFromAddressBook(ArrayList<Person> deletePersonList){
		AddressBookFileOperations.writeFile(deletePersonList);
	}
	public void sortAddressBook(ArrayList<Person> sortPersonList){
		AddressBookFileOperations.writeFile(sortPersonList);
		AddressBookFileOperations.readFile();
	}
}
