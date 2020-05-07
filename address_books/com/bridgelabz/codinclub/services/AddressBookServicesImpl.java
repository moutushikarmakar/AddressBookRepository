package com.bridgelabz.codinclub.services;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;
import com.bridgelabz.codinclub.main.AddressBookMain;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
*Address Book Services Implementation class
*Implementation class of Address Book Services Interface
*@authour Moutusi Karmakar
*/
public class AddressBookServicesImpl implements AddressBookServices{
	public final int ID = 0;
	Scanner scanner = new Scanner(System.in);
	
	/**
	*Implementation of addPerson method
	*addPerson methods adds contact to the Address Book
	*@param addPersonList
	*/
	public void addPerson(ArrayList<Person> addPersonList){
		/**
		*variable ID is incremnted each time a contact is added in the Address Book 
		*unique ID for each contact of Address Book
		*/
		ID++;
		System.out.println("Enter details of the person----->");
		
		System.out.println("Firstname: ");
	 	public final String firstname = scanner.next();
		scanner.nextLine();
		
		System.out.println("Lastname: ");
        	public final String lastname = scanner.next();
		scanner.nextLine();
		
		System.out.println("Address: ");
        	public final String address = scanner.next();
		scanner.nextLine();
		
		System.out.println("City: ");
        	public final String city = scanner.next();
		scanner.nextLine();
		
		System.out.println("State: ");
        	public final String state = scanner.next();
		scanner.nextLine();
		
		System.out.println("Zip: ");
        	public final int zip  = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Phone Number: ");
        	public final long phoneNum = scanner.nextLong();
		
		/**
		*creating an object of class Person and passing the attributes of the contact in the Person class constructor
		*/
		Person personObj = new Person(ID, firstname, lastname, address, city, state, zip, phoneNum);
		AddressBookRepo repo = new AddressBookRepo();
		/**
		*adding contact to Address Book CSV file
		*/
		repo.addToAddressBook(personObj,addPersonList);
	}
	
	/**
	*Implementation of editContact method
	*editContact method updates the Address Book
	*@param editPersonList
	*/
	public ArrayList<Person> editContact(ArrayList<Person> editPersonList){
		/**
		*view the full Address Book
		*/
		AddressBookFileOperations.readFile();
		Scanner scan = new Scanner(System.in);
		/**
		*asks user to input ID of the contact that needs to be updated
		*/
		System.out.println("Enter The ID of the contact you want to modify: ");
		int id = scan.nextInt();
		System.out.println("Enter the attribute you want to modify: ");
		System.out.println("1. Lastname");
		System.out.println("2. Address");
		System.out.println("3. City");
		System.out.println("4. State");
		System.out.println("5. Zip");
		System.out.println("6. Phone Number");
		int attr = scan.nextInt();
		/**
		*asks user to enter the modified value for the selected attribute
		*updates the address book with the modified contact
		*/
		switch(attr){
		case 1:
			System.out.println("Enter new Lastname: ");
			String lname = scan.next();
			for(Person p : editPersonList){
                        	if(p.ID == id){
					p.lastname = lname;
                        	}
                	}
		break;
		case 2:
			System.out.println("Enter new Address: ");
			String addr = scan.next();
			for(Person p : editPersonList){
                                if(p.ID == id){
                                        p.address = addr;
					int index = editPersonList.indexOf(p);
					editPersonList.set(index,p);
                                }
                        }
		break;
		case 3:
			System.out.println("Enter new city: ");
			String city = scan.next();
			for(Person p : editPersonList){
                                if(p.ID == id){
                                        p.city = city;
					int index = editPersonList.indexOf(p);
                                        editPersonList.set(index,p);
                                }
                        }
		break;
		case 4:
			System.out.println("Enter new state");
			String state = scan.next();
			for(Person p : editPersonList){
                                if(p.ID == id){
                                        p.state = state;
					int index = editPersonList.indexOf(p);
                                        editPersonList.set(index,p);
                                }
                        }
		break;
		case 5:
			System.out.println("Enter new zip: ");
			int zip = scan.nextInt();
			for(Person p : editPersonList){
                                if(p.ID == id){
                                        p.zip = zip;
					int index = editPersonList.indexOf(p);
                                        editPersonList.set(index,p);
                                }
                        }
		break;
		case 6:
			System.out.println("Enter new phone number: ");
			long phone = scan.nextLong();
			for(Person p : editPersonList){
                                if(p.ID == id){
                                        p.phoneNum = phone;
					int index = editPersonList.indexOf(p);
                                        editPersonList.set(index,p);
                                }
                        }
		break;
		default:
			System.out.println("Incorect input!");
		break;
		}
		AddressBookRepo repo = new AddressBookRepo();
		/**
		*writing in Address Book CSV file
		*/
		repo.updateToAddressBook(editPersonList);
		return editPersonList;
	}

	/**
	*implementation of viewContact method
	*views the contact according to firstname
	*@param viewPersonList 
	*/
	public void viewContact(ArrayList<Person> viewPersonList){
		/**
		*asks user to enter the firstname of the contact that needs to be viewed
		*/
		System.out.println("Enter first name...");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		/**
		*iterates through the list and displays the required contact
		*/
		for(Person p : viewPersonList){
			if((p.firstname).equalsIgnoreCase(name)){
				System.out.println("------------------------------");
				System.out.println(" Firstname: "+p.firstname+"\n Lastname: "+p.lastname+"\n Address: "+p.address+"\n City: "+p.city+"\n State: "+p.state+"\n Zip: "+p.zip+"\n Phone Number: "+p.phoneNum);
				System.out.println("------------------------------");
			}
		}
	}
	
	/**
	*implementation of deleteContact method
	*deletes the contact and updates in the address book
	*@param deletePersonList
	*/
	public ArrayList<Person> deleteContact(ArrayList<Person> deletePersonList){
		/**
		*displaying the address book
		*/
		AddressBookFileOperations.readFile();
		/**
		*asks user to enter the ID of the contact that needs to be deleted
		*/
		System.out.println("Enter the ID of the contact you want to delete: ");
		int id = AddressBookUtil.getUserInput();
		/**
		*iterates through the address book and deletes the selected contact
		*/
		for(Person p : deletePersonList){
			if(p.ID == id){
				deletePersonList.remove(p);
				break;
			}
		}
		AddressBookRepo repo = new AddressBookRepo();
		/**
		*writing updated address book to CSV file
		*/
		repo.deleteFromAddressBook(deletePersonList);
		return deletePersonList;
	}

	/**
	*implementation of the sortContact method
	*sorts the address book according to selected attribute 
	*@param sortPersonList
	*/
	public ArrayList<Person> sortContact(ArrayList<Person> sortPersonList){
		Scanner sort = new Scanner(System.in);
		/**
		*asks user to enter the attributes according to which the sorting needs to be done
		*/
		System.out.println("By which parameter do you want to sort?");
		System.out.println("1. Firstname \n2. Lastname \n3.Zip Code");
		int select = AddressBookUtil.getUserInput();
		switch(select){
		case 1:
			Collections.sort(sortPersonList, AddressBookUtil.sortByFname);
			for(Person p : sortPersonList){
				System.out.println(p);
			}
		break;
		case 2:
			Collections.sort(sortPersonList, AddressBookUtil.sortByLname);
                        for(Person p : sortPersonList){
                                System.out.println(p);
                        }
		break;
		case 3:
			Collections.sort(sortPersonList, AddressBookUtil.sortByZip);
                        for(Person p : sortPersonList){
                                System.out.println(p);
                        }
		break;
		default:
			System.out.println("Incorrect input!");
		break;
		}
		AddressBookRepo repo = new AddressBookRepo();
		/**
		*writing the sorted address book to the CSV file
		*/
		repo.sortAddressBook(sortPersonList);
		return sortPersonList;
	}
}

















