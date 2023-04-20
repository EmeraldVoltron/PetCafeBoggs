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

import java.util.Scanner;

import helperFiles.AdopterHelper;
import helperFiles.AnimalsHelper;

/**
 * @author abbyb
 *
 */
public class DriverClass {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdopterHelper adHelp = new AdopterHelper();
			
		printMenu();

		System.out.println("Goodbye!");
	}

	
	public static void printMenu() {
		System.out.println("Welcome to the pet cafe!");
		System.out.println("------------------------");
		System.out.println("Enter a Letter to choose from: ");
		System.out.println("A. Add/view animals");
		System.out.println("B. Add/view adopters");
		System.out.println("E. Exit");
		
		Scanner in = new Scanner(System.in);
		
		try {
			String choice = in.next();
			while(choice.equalsIgnoreCase("a") == false &&
					choice.equalsIgnoreCase("b") == false &&
					choice.equalsIgnoreCase("e") == false) {
				System.out.println("Invalid option please try again.");
				choice = in.next();
			}
			
			if(choice.equalsIgnoreCase("a")) {
				printAnimalMenu();
			} else if(choice.equalsIgnoreCase("b")) {
				printAdopterMenu();
			} 
		} catch (Exception e) {
			
		}
		
		in.close();
	}
	
	public static void printAnimalMenu(){
		AnimalsHelper anHelp = new AnimalsHelper();
		
		Scanner in = new Scanner(System.in);
		
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
			printMenu();
		} else if(choice.equalsIgnoreCase("a")){
			anHelp.viewAnimals();
		} else if(choice.equalsIgnoreCase("b")) {
			anHelp.addAnimals();
		} else if(choice.equalsIgnoreCase("c")) {
			System.out.println("What animal would you like to delete?");
			System.out.println("Enter the animal's ID number from list.");
			int animalNumber = in.nextInt();
			
		}
		
		in.close();
	}
	
	public static void printAdopterMenu() {
		AdopterHelper adHelp = new AdopterHelper();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Adopter View");
		System.out.println("-----------");
		
		System.out.println("A. View Adopter Queue");
		System.out.println("B. Add Adopter");
		System.out.println("C. Delete Adopter");
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
			printMenu();
		} else if(choice.equalsIgnoreCase("a")){
			adHelp.viewAdopters();
		} else if(choice.equalsIgnoreCase("b")) {
			adHelp.addAdopters();
		} else if(choice.equalsIgnoreCase("c")) {
			System.out.println("What adopter would you like to delete?");
			System.out.println("Enter the adopter's ID number from list.");
			int adopterNumber = in.nextInt();
			
		}
		
		in.close();
		
	}
}
