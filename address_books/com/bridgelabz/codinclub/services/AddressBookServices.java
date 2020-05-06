package com.bridgelabz.codinclub.services;
import com.bridgelabz.codinclub.main.AddressBookMain;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import java.util.*;

public interface AddressBookServices{
	public void addPerson(ArrayList<Person> addPersonList);
	public ArrayList<Person> editContact(ArrayList<Person> editPersonList);
	public void viewContact(ArrayList<Person> viewPersonList);
	public ArrayList<Person> deleteContact(ArrayList<Person> deletePersonList);
	public ArrayList<Person> sortContact(ArrayList<Person> sortPersonList);
}
