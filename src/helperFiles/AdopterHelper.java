/**************************************************************
* Name        : Project Name
* Author      : Abigail Boggs
* Created     : 
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program overall description here
*               Input:  list and describe
*               Output: list and describe
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

package helperFiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Adopters;
import classes.Pets;

/**
 * @author abbyb
 *
 */
public class AdopterHelper {

	Scanner in = new Scanner(System.in);
	
	public AdopterHelper(){
	}
	
	//View all of the adopters
	public void viewAdopters(ArrayList<Adopters> adoptersList) {
		
		System.out.println("Adopters: ");
		
		//if the adopter list is empty tell user and return
		if(adoptersList.isEmpty()) {
			System.out.println("No animals available.");
			return;
		}
		//go through each adopter in the array list
		for(int i = 0; i < adoptersList.size(); i++) {
			System.out.println("Id: " + i + " | Name: " + adoptersList.get(i).getName() +
					" | Email: " + adoptersList.get(i).getEmail() + " | Age: " + adoptersList.get(i).getAge() +
					" | Phone Number: " + adoptersList.get(i).getPhoneNumber() + " | Address: " + adoptersList.get(i).getAddress() +
					" | Date of First Visit: " + adoptersList.get(i).getFirstVisit() + " | Species Preference: " +
					adoptersList.get(i).getAnimalTypePreference() + " | Have children? " + adoptersList.get(i).isHaveChildren() +
					" | Interested in Disabled pets? " + adoptersList.get(i).isInterestInDisabledPets());
		}
		System.out.println();
	}
	
	//Add Adopters
	public ArrayList<Adopters> addAdopters(ArrayList<Adopters> adoptersList) {
		Adopters adopter;
		
		System.out.println("Please enter the adopter's information: ");
		System.out.println("Adopters's name: ");
		String name = in.nextLine();
		
		System.out.print("Age: ");
		int age = in.nextInt();
	
		in.nextLine();
		System.out.print("Species: ");
		String species = in.nextLine();
		
		System.out.print("Email: ");
		String email = in.nextLine();
		
		System.out.print("Phone number: ");
		String phoneNumber = in.nextLine();
		
		System.out.print("Address: ");
		String address = in.nextLine();
		
		System.out.print("Species preference: ");
		String preference = in.nextLine();
		
		System.out.print("Date of first visit: ");
		String firstVisit = in.nextLine();	
		
		//sees if the adopter has any pets
		System.out.print("Do they have kids? Y/N: ");
		String kids = in.nextLine();
		boolean kidsyn = true; //kids yes or no
		//checks to see if input is y or n
		while(!kids.equalsIgnoreCase("y") && !kids.equalsIgnoreCase("n")) {
			System.out.println("Please try again");
			kids = in.nextLine();
		}
		
		if(kids.equalsIgnoreCase("y")) {
			kidsyn = true;
		} else if(kids.equalsIgnoreCase("n")) {
			kidsyn = false;
		}
		 
		//if adopter is interested in pets with disabilities
		System.out.print("Are they interested in disabled pets? Y/N: ");
		String disabled = in.nextLine();
		boolean disabledyn = false; //disabledyn yes or no
		
		//if the input does not equal the 2, then ask again
		while(!disabled.equalsIgnoreCase("y") && !disabled.equalsIgnoreCase("n")) {
			System.out.println("Please try again");
			disabled = in.nextLine();
		}
		
		//sets if the adopter is interested disabled or not
		if(disabled.equalsIgnoreCase("y")) {
			disabledyn = true;
		} else if(disabled.equalsIgnoreCase("n")) {
			disabledyn = false;
		}
		

		
		//create new objects
		if(firstVisit.equalsIgnoreCase("")) {
			adopter = new Adopters(age, name, address, phoneNumber, email, preference, disabledyn, kidsyn);
		} else {
			adopter = new Adopters(age, name, address, phoneNumber, email, firstVisit, preference, disabledyn, kidsyn);
		}
		
		//add adopter to array
		adoptersList.add(adopter);
		System.out.println("Adopter added");
		
		//returns updated adoptersList
		return(adoptersList);
		
	}

	/**
	 *  Delete Adopters
	 */
	public ArrayList<Adopters> deleteAdopters(ArrayList<Adopters> adoptersList) {	
		System.out.println("What adopter would you like to delete?");
		//if the list is empty, output tht there are no adopters available and return the list
		if(adoptersList.isEmpty()) {
			System.out.println("No adopters available.");
			return(adoptersList);
		}
		
		//gets adopters ID
		System.out.print("Enter the adopter's ID number from list.");
		int adopterNumber = in.nextInt();
		
		//tests to see if id is in the adopterslist 
		while(adopterNumber > adoptersList.size() || adopterNumber < 0) {
			System.out.println("Invalid ID, try again.");
			adopterNumber = in.nextInt();
		}
		
		//removes adopter from list
		adoptersList.remove(adopterNumber);
		System.out.println("Adopter removed.");
		
		//returns updated adoptersList
		return(adoptersList);
		
	}
	
	
}
