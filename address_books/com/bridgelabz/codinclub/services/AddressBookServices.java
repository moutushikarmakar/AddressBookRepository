package com.bridgelabz.codinclub.services;
import com.bridgelabz.codinclub.main.AddressBookMain;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.*;

/**
*Address Book Sevices interface
*@author Moutusi Karmakar
*/
public interface AddressBookServices{
	/**
	*signature of addPerson method
	*@param addPersonList of type Person
	*/
	public void addPerson(ArrayList<Person> addPersonList);
	
	/**
	*signature of editContact method
	*@param editPersonList of type Person
	*/
	public ArrayList<Person> editContact(ArrayList<Person> editPersonList);
	
	/**
	*signature of viewContact method
	*@param viewContactList of type Person
	*/
	public void viewContact(ArrayList<Person> viewPersonList);
	
	/**
	*signature of deleteContact method
	*@param deleteContactList of type Person
	*/
	public ArrayList<Person> deleteContact(ArrayList<Person> deletePersonList);
	
	/**
	*signature of sortContact method
	*@param sortPersonList of type Person
	*/
	public ArrayList<Person> sortContact(ArrayList<Person> sortPersonList);
}
