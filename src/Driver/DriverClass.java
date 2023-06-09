package Driver;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import helperFiles.AdopterHelper;
import helperFiles.AnimalsHelper;
import classes.Pets;
import classes.Adopters;

/**
 * @author abbyb
 *
 */
public class DriverClass {
	
	public static Scanner in = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Pets> pets = new ArrayList<Pets>();
		Queue<Adopters> adopters = new LinkedList<>();
		Map<Pets, Adopters> pairs = new HashMap<>();
		
		
		printMenu(pets, adopters, pairs);

		System.out.println("Goodbye!");
	}

	//Main menu
	public static void printMenu(ArrayList<Pets> p, Queue<Adopters> a, Map<Pets, Adopters> matches) {
		ArrayList<Pets> pets = p;
		Queue<Adopters> adopters = a;
		Map<Pets, Adopters> pairs = matches;
		
		System.out.println();
		System.out.println("Welcome to the pet cafe!");
		System.out.println("------------------------");
		System.out.println("Enter a Letter to choose from: ");
		System.out.println("A. Add/view animals");
		System.out.println("B. Add/view adopters");
		System.out.println("C. Match pairs, animals to adopters.");
		System.out.println("E. Exit");
		
		Scanner in = new Scanner(System.in);
		
		try {
			//check to see if the input is right, if not ask again
			String choice = in.nextLine();
			while(choice.equalsIgnoreCase("a") == false &&
					choice.equalsIgnoreCase("b") == false &&
					choice.equalsIgnoreCase("c") == false &&
					choice.equalsIgnoreCase("e") == false) {
				System.out.println("Invalid option please try again.");
				choice = in.nextLine();
			}
			//go to corresponding menus
			if(choice.equalsIgnoreCase("a")) {
				printAnimalMenu(pets, adopters, pairs);
			} else if(choice.equalsIgnoreCase("b")) {
				printAdopterMenu(pets, adopters, pairs);
			} else if(choice.equalsIgnoreCase("c")) {
				printMatchingMenu(pets, adopters, pairs);
			} else if(choice.equalsIgnoreCase("e")) {
				in.close();
				return;
			}
		} catch (Exception e) {
			
		}
		

	}
	
	//animal menu (option a)
	public static void printAnimalMenu(ArrayList<Pets> pets, Queue<Adopters> a, Map<Pets, Adopters> pairs){
		AnimalsHelper anHelp = new AnimalsHelper();
		
		System.out.println();
		System.out.println("Animal View");
		System.out.println("-----------");
		
		System.out.println("A. View animals");
		System.out.println("B. Add animals");
		System.out.println("C. Delete Animals");
		System.out.println("R. return to main menu");
		
		String choice = in.nextLine();
		
		//check to see if the input is a valid option
		while(choice.equalsIgnoreCase("a") == false &&
				choice.equalsIgnoreCase("b") == false &&
				choice.equalsIgnoreCase("c") == false &&
				choice.equalsIgnoreCase("r") == false) {
			System.out.print("Invalid choice, try again: ");
			choice = in.nextLine();
		}
		
		//act on the choices
		if(choice.equalsIgnoreCase("r")) {
			printMenu(pets, a, pairs);
		} else if(choice.equalsIgnoreCase("a")){
			if(pets.isEmpty()) {
				System.out.println("No animals available, please add more");
			} else {
				//sort animals then show them
				anHelp.sortAnimals(pets);
				anHelp.viewAnimals(pets);
			}
			printAnimalMenu(pets, a, pairs);
		} else if(choice.equalsIgnoreCase("b")) {
			//adds animals
			anHelp.addAnimals(pets);
			printAnimalMenu(pets, a, pairs);
		} else if(choice.equalsIgnoreCase("c")) {
			if(pets.isEmpty()) {
				System.out.println("No animals to delete.");
			} else {
				//delete animals
				anHelp.deleteAnimals(pets);
			}
			printAnimalMenu(pets, a, pairs);
		}
	}
	
	//adopter menu option B
	public static void printAdopterMenu(ArrayList<Pets> p, Queue<Adopters> adopters, Map<Pets, Adopters> pairs) {
		AdopterHelper adHelp = new AdopterHelper();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Adopter Menu");
		System.out.println("-----------");
		
		System.out.println("A. View Adopter Queue");
		System.out.println("B. Show next in Queue");
		System.out.println("C. Add Adopter");
		System.out.println("D. Delete Adopter");
		System.out.println("R. return to main menu");
		
		String choice = in.nextLine();
		//check to see if the input is a valid option
		while(choice.equalsIgnoreCase("a") == false &&
				choice.equalsIgnoreCase("b") == false &&
				choice.equalsIgnoreCase("c") == false &&
				choice.equalsIgnoreCase("d") == false &&
				choice.equalsIgnoreCase("r") == false) {
			System.out.print("Invalid choice, try again: ");
			choice = in.nextLine();
		}
		
		//act on the aptions
		if(choice.equalsIgnoreCase("r")) {
			//return to the main menu
			printMenu(p, adopters, pairs);
		} else if(choice.equalsIgnoreCase("a")){
			if(adopters.isEmpty()) {
				System.out.println("No adopters, please add more");
			} else {
				//calls view adopters method
				adHelp.viewAdopters(adopters);
			}
			//print the adopter menu over again after being returned
			printAdopterMenu(p, adopters, pairs); 
		} else if(choice.equalsIgnoreCase("b")) {
			if(adopters.isEmpty()) {
				System.out.println("No adopters, please add more");
			} else {
				//shows next in queue from adopter menu
				adHelp.showNextInQueue(adopters);
			}
			//print adopter menu over again after returning back to function
			printAdopterMenu(p, adopters, pairs);
		} else if(choice.equalsIgnoreCase("c")) {
			//add adopters from helper file
			adHelp.addAdopters(adopters);
			printAdopterMenu(p, adopters, pairs);
		} else if(choice.equalsIgnoreCase("d")) {
			if(adopters.isEmpty()) {
				System.out.println("No adopters to delete.");
			} else {
				//delete adopters using helper file
				adHelp.deleteAdopters(adopters);
			}
			printAdopterMenu(p, adopters, pairs);
		} 
		
		in.close();
		
	}
	
	//match pairs menu
	public static void printMatchingMenu(ArrayList<Pets> p, Queue<Adopters> adopters, Map<Pets, Adopters> pairs){	
		AnimalsHelper anHelper = new AnimalsHelper();
		System.out.println();
		System.out.println("Match some adoption pairs");
		System.out.println("--------------------------");
		
		System.out.println("A. View Next Adopter in Queue");
		System.out.println("B. View animals (sorted)");
		System.out.println("C. Make a match.");
		System.out.println("D. View Pairs.");
		System.out.println("R. return to main menu");
	
		String option = in.nextLine();
		
		while(!option.equalsIgnoreCase("a") &&
				!option.equalsIgnoreCase("b") &&
				!option.equalsIgnoreCase("c") &&
				!option.equalsIgnoreCase("r") &&
				!option.equalsIgnoreCase("d")) {
			System.out.println("Invalid input, try again");
			option = in.nextLine();
		}
		
		if(option.equalsIgnoreCase("r")) {
			printMenu(p, adopters, pairs);
		} else if(option.equalsIgnoreCase("a")) {
			if(adopters.isEmpty()) {
				System.out.println("Adopter's queue is empty, please add adopters");
				printMenu(p, adopters, pairs);
			} else {
				System.out.println(adopters.peek());
				printMatchingMenu(p, adopters, pairs);
			}
		} else if(option.equalsIgnoreCase("b")) {
			if(p.isEmpty()) {
				System.out.println("No animals to show, please add pets.");
				printMenu(p, adopters, pairs);
			} else {
				anHelper.sortAnimals(p);
				for(int i = 0; i < p.size(); i++) {
					System.out.println("Id: " + i + " | Name: " + p.get(i).getName() + " | Age: " + p.get(i).getAge() +
					" | Species: " + p.get(i).getTypeOfAnimal() + " | Breed: " + 
					p.get(i).getBreed() + " | Date of arrival: " + p.get(i).getDateOfArrival() +
					" | Good with kids? " + p.get(i).isGoodWithChildren() + " | Disabled? " +
					p.get(i).isDisabilities());
				}
				printMatchingMenu(p, adopters, pairs);
			}
		} else if(option.equalsIgnoreCase("c")) {
			if(p.isEmpty() || adopters.isEmpty()) {
				System.out.println("Only able to make a pair if adopters or animals are available.");
				printMenu(p, adopters, pairs);
			} else {
				printPairMenu(p, adopters, pairs);
				printMatchingMenu(p, adopters, pairs);
			}
		} else if(option.equalsIgnoreCase("d")) {
			if(pairs.isEmpty()) {
				System.out.println("No matches made, please make a pair.");
				printMatchingMenu(p, adopters, pairs);
			} else {
				System.out.println(pairs.toString());
				printMatchingMenu(p, adopters, pairs);
			}
		}
	}

	/**
	 * @param p
	 * @param adopters
	 * @param pairs
	 */
	
	private static void printPairMenu(ArrayList<Pets> p, Queue<Adopters> adopters, Map<Pets, Adopters> pairs) {
		AnimalsHelper anHelp = new AnimalsHelper();
		
		System.out.println("Enter the id of the animal you'd like to pair with the next adopter in line.");
		Integer id = (Integer) null;
		//gets animals id and make sure its a number format
		do {
			String idString = in.nextLine();
			
			try {
				id = Integer.parseInt(idString);
			} catch(NumberFormatException e) {
				System.out.println("Invalid input, try again");
			} finally {
				if(id < 0 || id >  p.size()) {
					System.out.println("ID cannot be less than 0.");
					
				}
			}
		} while (id == null || id < 0 || id > p.size());
		
		//get the animal selected
		Pets pet = p.get(id);
		//get the next adopter in queue
		Adopters adopter = adopters.peek();
				
		//put the pair together in the map
		pairs.put(pet, adopter);
		System.out.println("Pairs " + pairs.toString());
				
		//deletes the animal from arraylist
		anHelp.deleteAnimals(p, id);
		//delete the adopter from the queue
		adopters.poll();
		 
		return;
	}
	
	
}
