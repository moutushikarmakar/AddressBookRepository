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

public class AddressBookServicesImpl implements AddressBookServices{
	public int ID = 0;
	Scanner scanner = new Scanner(System.in);
	public void addPerson(ArrayList<Person> addPersonList){
		ID++;
		System.out.println("Enter details of the person----->");
		System.out.println("Firstname: ");
	 	String firstname = scanner.next();
		scanner.nextLine();
		System.out.println("Lastname: ");
        	String lastname = scanner.next();
		scanner.nextLine();
		System.out.println("Address: ");
        	String address = scanner.next();
		scanner.nextLine();
		System.out.println("City: ");
        	String city = scanner.next();
		scanner.nextLine();
		System.out.println("State: ");
        	String state = scanner.next();
		scanner.nextLine();
		System.out.println("Zip: ");
        	int zip  = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Phone Number: ");
        	long phoneNum = scanner.nextLong();

		Person personObj = new Person(ID, firstname, lastname, address, city, state, zip, phoneNum);
		AddressBookRepo repo = new AddressBookRepo();
		repo.addToAddressBook(personObj,addPersonList);
	}

	public ArrayList<Person> editContact(ArrayList<Person> editPersonList){
		AddressBookFileOperations.readFile();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The ID in which you want to modify: ");
		int id = scan.nextInt();
		System.out.println("Enter the attribute you want to modify: ");
		System.out.println("1. Lastname");
		System.out.println("2. Address");
		System.out.println("3. City");
		System.out.println("4. State");
		System.out.println("5. Zip");
		System.out.println("6. Phone Number");
		int attr = scan.nextInt();
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
		repo.updateToAddressBook(editPersonList);
		return editPersonList;
	}

	public void viewContact(ArrayList<Person> viewPersonList){
		System.out.println("Enter first name...");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		for(Person p : viewPersonList){
			if((p.firstname).equalsIgnoreCase(name)){
				System.out.println("------------------------------");
				System.out.println(" Firstname: "+p.firstname+"\n Lastname: "+p.lastname+"\n Address: "+p.address+"\n City: "+p.city+"\n State: "+p.state+"\n Zip: "+p.zip+"\n Phone Number: "+p.phoneNum);
				System.out.println("------------------------------");
			}
		}
	}

	public ArrayList<Person> deleteContact(ArrayList<Person> deletePersonList){
		AddressBookFileOperations.readFile();
		System.out.println("Enter the ID of the contact you want to delete: ");
		int id = AddressBookUtil.getUserInput();
		for(Person p : deletePersonList){
			if(p.ID == id){
				deletePersonList.remove(p);
				break;
			}
		}
		AddressBookRepo repo = new AddressBookRepo();
		repo.deleteFromAddressBook(deletePersonList);
		return deletePersonList;
	}

	public ArrayList<Person> sortContact(ArrayList<Person> sortPersonList){
		Scanner sort = new Scanner(System.in);
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
		repo.sortAddressBook(sortPersonList);
		return sortPersonList;
	}
}

















