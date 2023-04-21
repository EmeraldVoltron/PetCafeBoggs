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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Pets> pets = new ArrayList<Pets>();
		Queue<Adopters> adopters = new LinkedList<>();
		
		printMenu(pets, adopters);

		System.out.println("Goodbye!");
	}

	//Main menu
	public static void printMenu(ArrayList<Pets> p, Queue<Adopters> a) {
		ArrayList<Pets> pets = p;
		Queue<Adopters> adopters = a;
		Map<Pets, Adopters> pairs = new HashMap<Pets, Adopters>();
		
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
			String choice = in.next();
			while(choice.equalsIgnoreCase("a") == false &&
					choice.equalsIgnoreCase("b") == false &&
					choice.equalsIgnoreCase("c") == false &&
					choice.equalsIgnoreCase("e") == false) {
				System.out.println("Invalid option please try again.");
				choice = in.next();
			}
			//go to corresponding menus
			if(choice.equalsIgnoreCase("a")) {
				printAnimalMenu(pets, adopters);
			} else if(choice.equalsIgnoreCase("b")) {
				printAdopterMenu(pets, adopters);
			} else if(choice.equalsIgnoreCase("c")) {
				printMatchingMenu(pets, adopters, pairs);
			}
		} catch (Exception e) {
			
		}
		
		in.close();
	}
	
	//animal menu (option a)
	public static void printAnimalMenu(ArrayList<Pets> pets, Queue<Adopters> a){
		AnimalsHelper anHelp = new AnimalsHelper();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Animal View");
		System.out.println("-----------");
		
		System.out.println("A. View animals");
		System.out.println("B. Add animals");
		System.out.println("C. Delete Animals");
		System.out.println("R. return to main menu");
		
		String choice = in.next();
		
		while(choice.equalsIgnoreCase("a") == false &&
				choice.equalsIgnoreCase("b") == false &&
				choice.equalsIgnoreCase("c") == false &&
				choice.equalsIgnoreCase("r") == false) {
			System.out.print("Invalid choice, try again: ");
			choice = in.next();
		}
		
		if(choice.equalsIgnoreCase("r")) {
			printMenu(pets, a);
		} else if(choice.equalsIgnoreCase("a")){
			if(pets.isEmpty()) {
				System.out.println("No animals available, please add more");
			} else {
				anHelp.viewAnimals(pets);
			}
			printAnimalMenu(pets, a);
		} else if(choice.equalsIgnoreCase("b")) {
			anHelp.addAnimals(pets);
			printAnimalMenu(pets, a);
		} else if(choice.equalsIgnoreCase("c")) {
			if(pets.isEmpty()) {
				System.out.println("No animals to delete.");
			} else {
			anHelp.deleteAnimals(pets);
			}
			printAnimalMenu(pets, a);
		}
		
		in.close();
	}
	
	//adopter menu option B
	public static void printAdopterMenu(ArrayList<Pets> p, Queue<Adopters> adopters) {
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
		
		String choice = in.next();
		while(choice.equalsIgnoreCase("a") == false &&
				choice.equalsIgnoreCase("b") == false &&
				choice.equalsIgnoreCase("c") == false &&
				choice.equalsIgnoreCase("d") == false &&
				choice.equalsIgnoreCase("r") == false) {
			System.out.print("Invalid choice, try again: ");
			choice = in.next();
		}
		
		if(choice.equalsIgnoreCase("r")) {
			printMenu(p, adopters);
		} else if(choice.equalsIgnoreCase("a")){
			if(adopters.isEmpty()) {
				System.out.println("No adopters, please add more");
			} else {
				adHelp.viewAdopters(adopters);
			}
			printAdopterMenu(p, adopters); 
		} else if(choice.equalsIgnoreCase("b")) {
			if(adopters.isEmpty()) {
				System.out.println("No adopters, please add more");
			} else {
				adHelp.showNextInQueue(adopters);
			}
			printAdopterMenu(p, adopters);
		} else if(choice.equalsIgnoreCase("c")) {
			adHelp.addAdopters(adopters);
			printAdopterMenu(p, adopters);
		} else if(choice.equalsIgnoreCase("d")) {
			if(adopters.isEmpty()) {
				System.out.println("No adopters to delete.");
			} else {
				adHelp.deleteAdopters(adopters);
			}
			printAdopterMenu(p, adopters);
		} 
		
		in.close();
		
	}
	
	//match pairs menu
	public static void printMatchingMenu(ArrayList<Pets> p, Queue<Adopters> adopters, Map<Pets, Adopters> pairs){
		AdopterHelper adHelp = new AdopterHelper();
		AnimalsHelper anHelp = new AnimalsHelper();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Match some adoption pairs");
		System.out.println("--------------------------");
		
		System.out.println("A. View Next Adopter in Queue");
		System.out.println("B. View animals (sorted)");
		System.out.println("C. Make a match.");
		System.out.println("R. return to main menu");
		
		String choice = in.next();
		while(choice.equalsIgnoreCase("a") == false &&
				choice.equalsIgnoreCase("b") == false &&
				choice.equalsIgnoreCase("c") == false &&
				choice.equalsIgnoreCase("r") == false) {
			System.out.print("Invalid choice, try again: ");
			choice = in.next();
		}
		
		if(choice.equalsIgnoreCase("r")) {
			printMenu(p, adopters);
		} else if(choice.equalsIgnoreCase("a")){
			if(adopters.isEmpty()) {
				System.out.println("Queue empty, please add more adopters.");
			} else {
				adHelp.showNextInQueue(adopters);
			}
			printMatchingMenu(p, adopters, pairs);
		} else if(choice.equalsIgnoreCase("b")) {
			if(p.isEmpty()) {
				System.out.println("No animals, please add more.");	
			} else {
				anHelp.sortAnimals(p);
				anHelp.viewAnimals(p);
			}
			printMatchingMenu(p, adopters, pairs); 
		} else if(choice.equalsIgnoreCase("c")) {
			if(p.isEmpty() || adopters.isEmpty()) {
				System.out.println("No animals or adopters to pair");
			} else {
				printPairMenu(p, adopters, pairs);
			}
			printMatchingMenu(p, adopters, pairs);
		} 
		in.close();
	}

	/**
	 * @param p
	 * @param adopters
	 * @param pairs
	 */
	private static void printPairMenu(ArrayList<Pets> p, Queue<Adopters> adopters, Map<Pets, Adopters> pairs) {
		AnimalsHelper anHelp = new AnimalsHelper();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter the id of the animal you'd like to pair with the next adopter in line.");
		int animalId = in.nextInt();
		while(!in.hasNextInt() || animalId < 0 || animalId > p.size()) {
			System.out.println("Invalid id, try again");
			animalId = in.nextInt();
		}
		
		Pets pet = p.get(animalId);
		Adopters adopter = adopters.peek();
		
		pairs.put(pet, adopter);
		System.out.println("Pairs " + pairs.toString());
		
		anHelp.deleteAnimals(p, animalId);
		adopters.poll();
	 
		in.close();
	}
}
