package com.bridgelabz.codinclub.models;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;

/**
*Person class
*@author Moutusi Karmakar
*/
public class Person{
	public int ID;
	public String firstname;
	public String lastname;
	public String address;
	public String city;
	public String state;
	public int zip;
	public long phoneNum;

	/**
	*Default Contructor of Person class
	*/
	public Person(){

	}
	
	/**
	*Parameterized constructor of Person class
	*@param firstname
	*@param lastname
	*@param address
	*@param city
	*@param state
	*@param zip
	*@param phoneNum
	*/
	public Person(int ID, String firstname, String lastname, String address, String city, String state, int zip, long phoneNum){
		this.ID = ID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNum = phoneNum;
	}
	/**
	*toString method to print the fields of the Person class
	*/
	public String toString(){
		return ID+","+firstname+","+lastname+","+address+","+city+","+state+","+zip+","+phoneNum;
	}
}
