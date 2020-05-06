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

public class AddressBookFileOperations{

final static String CSV_READER = "ID, First Name, Last Name, Address, City, State, Zip, Phone Number";
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

	public static void readFile(){
		BufferedReader reader = null;
		try{
		String readFile;
		reader = new BufferedReader(new FileReader("AddressBook.csv"));
		while((readFile = reader.readLine()) != null){
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
