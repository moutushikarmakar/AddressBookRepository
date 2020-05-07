package com.bridgelabz.codinclub.services;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import com.bridgelabz.codinclub.main.AddressBookMain;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.AddressBookRepo;
import com.bridgelabz.codinclub.services.AddressBookServices;
import com.bridgelabz.codinclub.services.AddressBookServicesImpl;
import com.bridgelabz.codinclub.models.Person;
import java.util.*;

/**
*Address Book File Operations class
*@author Moutusi Karmakar
*/
public class AddressBookFileOperations{
	/**
	*Initializing the header of the CSV file
	*/
	final static String CSV_READER = "ID, First Name, Last Name, Address, City, State, Zip, Phone Number";
	
	/**
	*writeFile method writes the arraylist of contacts to a CSV file
	*@param personList
	*/
	public static void writeFile(ArrayList personList){
		FileWriter fileWriter = null;
		try{
                System.out.println(personList);
                fileWriter = new FileWriter("AddressBook.csv");
                fileWriter.append(CSV_READER);
                fileWriter.append("\n");
                for(int i=0; i<personList.size(); i++){
                        fileWriter.append(personList.get(i).toString());
                        fileWriter.append("\n");
                        }
                System.out.println("written CSV successfully!");
                }catch(Exception e){
                        System.out.println("Error writing file!");
                        e.printStackTrace();
                        }finally{
                                try{
                                fileWriter.flush();
                                fileWriter.close();
                                }catch(IOException e){
                                        System.out.println("Error closing file");
                                        e.printStackTrace();
                                        }
                                }
        }
	
	/**
	*method readFile reads the data from the CSV to arraylist
	*/
	public static void readFile(){
		BufferedReader reader = null;
		try{
		String readFile;
		reader = new BufferedReader(new FileReader("AddressBook.csv"));
		while((readFile = reader.readLine()) != null){
			/**
			*calling the convertArrayList method to display each line read from the CSV file
			*passing readFile string to convertArrayList method
			*/
			System.out.println(convertArrayList(readFile));
                	}
		System.out.println("Successfully read file!");
		}catch(Exception e){
			System.out.println("Error reading file");
			e.printStackTrace();
		}finally{
			try{
			reader.close();
			}catch(IOException e){
				System.out.println("Error closing file");
				e.printStackTrace();
				}
		}
	}
	
	/**
	*convertArrayList method takes a string, splits the data and stores in an arraylist
	*returns arraylist of each contact of the address book
	*@param list (String)
	*/
	public static ArrayList<String> convertArrayList(String list){
		ArrayList<String> result = new ArrayList<>();
		if(list != null){
			String[] splitData = list.split("\\s*,\\s*");
		 	for(int i=0; i<splitData.length; i++){
                 		if(!(splitData[i] == null) || !(splitData[i].length() == 0)){
                        		result.add(splitData[i].trim());
                                	}
                 	}
		}
		return result;
	}

}
