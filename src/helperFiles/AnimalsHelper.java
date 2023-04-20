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

import classes.Pets;

/**
 * @author abbyb
 *
 */
public class AnimalsHelper {
	
	Scanner in = new Scanner(System.in);
	
	public AnimalsHelper(){
	}
	
	//View all of the animals
	public void viewAnimals(ArrayList<Pets> petsList) {
		
		System.out.println("Animals: ");
		
		if(petsList.isEmpty()) {
			System.out.println("No animals available.");
			return;
		}
		for(int i = 0; i < petsList.size(); i++) {
			System.out.println("Id: " + i + " | Name: " + petsList.get(i).getName() +
					" | Species: " + petsList.get(i).getTypeOfAnimal() + " | Breed: " + 
					petsList.get(i).getBreed() + " | Date of arrival: " + petsList.get(i).getDateOfArrival() +
					" | Good with kids? " + petsList.get(i).isGoodWithChildren() + " | Disabled? " +
					petsList.get(i).isDisabilities());
		}
		System.out.println();
	}
	
	//Add Animals 
	public ArrayList<Pets> addAnimals(ArrayList<Pets> petsList) {
		Pets pet;
		
		System.out.println("Please enter the animal's information: ");
		System.out.println("Animal's name: ");
		String name = in.nextLine();
		
		System.out.print("Age: ");
		int age = in.nextInt();
	
		in.nextLine();
		System.out.print("Species: ");
		String species = in.nextLine();
		
		System.out.print("Breed: ");
		String breed = in.nextLine();
		
		System.out.print("Date of arrival: ");
		String dateOfArrival = in.nextLine();
		
		//Check for kid compatability 
		System.out.print("Good with kids? Y/N: ");
		String kids = in.nextLine();
		boolean kidsyn = true; //kids yes or no
		//checks to see if input is y or n
		while(!kids.equalsIgnoreCase("y") && !kids.equalsIgnoreCase("n")) {
			System.out.println("Please try again");
			kids = in.nextLine();
		}
		//sets if the animal is good with kids or not
		if(kids.equalsIgnoreCase("y")) {
			kidsyn = true;
		} else if(kids.equalsIgnoreCase("n")) {
			kidsyn = false;
		}
		 
		//Animal disabilities
		System.out.print("Any disabilities? Y/N: ");
		String disabled = in.nextLine();
		boolean disabledyn = false; //disabledyn yes or no
		
		//if the input does not equal the 2, then ask again
		while(!disabled.equalsIgnoreCase("y") && !disabled.equalsIgnoreCase("n")) {
			System.out.println("Please try again");
			disabled = in.nextLine();
		}
		
		//sets if the animal is disabled or not
		if(disabled.equalsIgnoreCase("y")) {
			disabledyn = true;
		} else if(disabled.equalsIgnoreCase("n")) {
			disabledyn = false;
		}
		
		//create new objects
		if(dateOfArrival.equalsIgnoreCase("")) {
			pet = new Pets(name, age, species, breed, kidsyn, disabledyn);
		} else {
			pet = new Pets(name, age, species, breed, dateOfArrival, kidsyn, disabledyn);
		}
		
		//add pets to array
		petsList.add(pet);
		System.out.println("Animal added");
		
		//returns updated petsList
		return(petsList);
		
	}

	/**
	 *  Delete animals
	 */
	public ArrayList<Pets> deleteAnimals(ArrayList<Pets> petsList) {	
		System.out.println("What animal would you like to delete?");
		if(petsList.isEmpty()) {
			System.out.println("No animals available.");
			return(petsList);
		}
		
		System.out.print("Enter the animal's ID number from list.");
		int animalNumber = in.nextInt();
		
		while(animalNumber > petsList.size() || animalNumber < 0) {
			System.out.println("Invalid ID, try again.");
			animalNumber = in.nextInt();
		}
		
		petsList.remove(animalNumber);
		System.out.println("Animal removed.");
		
		//returns updated petsList
		return(petsList);
		
	}
}
