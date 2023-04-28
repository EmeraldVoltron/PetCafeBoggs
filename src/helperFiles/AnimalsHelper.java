/**************************************************************
* Name        : Pet Cafe Final Project
* Author      : Abigail Boggs
* Created     : 3/28/23
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : Program for employees at a pet cafe to add animals, add
* 				adopters, and then sort through animals to see what animals
* 				fit the adopters best. The adopters, are in a priority queue
* 				from when they last visited. 
*               Input:  pets, and adopters
*               Output: pets with their perfect owners
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

package helperFiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		//prints out each pet from the list
		for(int i = 0; i < petsList.size(); i++) {
			System.out.println("Id: " + i + " | Name: " + petsList.get(i).getName() + " | Age: " + petsList.get(i).getAge() +
					" | Species: " + petsList.get(i).getTypeOfAnimal() + " | Breed: " + 
					petsList.get(i).getBreed() + " | Date of arrival: " + petsList.get(i).getDateOfArrival() +
					" | Good with kids? " + petsList.get(i).isGoodWithChildren() + " | Disabled? " +
					petsList.get(i).isDisabilities());
		}
		System.out.println();
	}
	
	//Add Animals 
	public void addAnimals(ArrayList<Pets> petsList) {
		Pets pet = new Pets();
		
			System.out.println("Please enter the animal's information: ");
			System.out.print("Animal's name: ");
			String name = in.nextLine();
			
			Integer age = (Integer) null;
			//gets animals age and make sure its a number format
			do {
				System.out.print("Age: ");
				String ageString = in.nextLine();
				
				try {
					age = Integer.parseInt(ageString);
				} catch(NumberFormatException e) {
					System.out.println("Invalid input, try again");
				} finally {
					if(age < 0) {
						System.out.println("Age cannot be less than 0.");
					}
				}
			} while (age == null || age < 0);
			
			System.out.print("Species: ");
			String species = in.nextLine();
		
			System.out.print("Breed: ");
			String breed = in.nextLine();
		
			LocalDate dateOfArrival = null;
			//make sure the date is inputted correctly
			do {
				System.out.print("Date of arrival (yyyy-mm-dd): ");
				String d = in.nextLine();
				
				try {
					dateOfArrival = LocalDate.parse(d);
				} catch (Exception e) {
					System.out.println("Date invalid, try format again. ");
				}
			} while(dateOfArrival == null);
		
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
			pet = new Pets(name, age, species, breed, dateOfArrival, kidsyn, disabledyn);
		
			
		petsList.add(pet);
		System.out.println("Animal added");
		
		
	}

	/**
	 *  Delete animals
	 */
	public void deleteAnimals(ArrayList<Pets> petsList) {
		//asks what animal they want to delete
		System.out.println("What animal would you like to delete?");
		if(petsList.isEmpty()) {
			System.out.println("No animals available.");
			return;
		}
		
		System.out.print("Enter the animal's ID number from list.");
		int animalNumber = in.nextInt();
		
		//checks to make sure the number is in the bounds
		while(animalNumber > petsList.size() || animalNumber < 0) {
			System.out.println("Invalid ID, try again.");
			animalNumber = in.nextInt();
		}
		
		//removes
		petsList.remove(animalNumber);
		System.out.println("Animal removed.");
		
	}

	/**
	 * @return
	 */
	public ArrayList<Pets> sortAnimals(ArrayList<Pets> sorting) {
		Collections.sort(sorting, AnimalsHelper.petsTypeComparator);
		return sorting;
	}
	
	//compares the pets type for sorting
	public static Comparator<Pets> petsTypeComparator = new Comparator<Pets>() {
		public int compare(Pets s1, Pets s2) {
			String petType1 = s1.getTypeOfAnimal().toUpperCase();
			String petType2 = s2.getTypeOfAnimal().toUpperCase();
			
			return petType1.compareTo(petType2);
		}
	};

	/**
	 * @param p 
	 * @param animalId
	 */
	public void deleteAnimals(ArrayList<Pets> p, int animalId) {
		p.remove(animalId); //removes the pets just using the animalsId
	}
	
}
