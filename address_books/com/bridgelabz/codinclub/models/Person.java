package com.bridgelabz.codinclub.models;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import com.bridgelabz.codinclub.services.AddressBookFileOperations;

public class Person{
	public int ID;
	public String firstname;
	public String lastname;
	public String address;
	public String city;
	public String state;
	public int zip;
	public long phoneNum;

	public Person(){

	}

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
	public String toString(){
		return ID+","+firstname+","+lastname+","+address+","+city+","+state+","+zip+","+phoneNum;
	}

	public void setID(int ID){
		this.ID = ID;
	}
	public void setFirstName(String firstname){
		this.firstname = firstname;
	}
	public void setLastName(String lastname){
		this.lastname = lastname;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setCity(String city){
		this.city = city;
	}
	public void setState(String state){
		this.state = state;
	}
	public void setZip(int zip){
		this.zip = zip;
	}
	public void setPhone(long phoneNum){
		this.phoneNum = phoneNum;
	}
}
