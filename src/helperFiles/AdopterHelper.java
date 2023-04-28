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

import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

import classes.Adopters;

/**
 * @author abbyb
 *
 */
public class AdopterHelper {

	Scanner in = new Scanner(System.in);
	
	public AdopterHelper(){
	}
	
	//View all of the adopters
	public void viewAdopters(Queue<Adopters> adoptersQueue) {
		
		System.out.println("Adopters: ");
		
		//if the adopter list is empty tell user and return
		if(adoptersQueue.isEmpty()) {
			System.out.println("No animals available.");
			return;
		}
		Iterator<Adopters> it = adoptersQueue.iterator();		
		//go through each adopter in the Queue
		while(it.hasNext()) {
			System.out.println(it.next().toString());
//			System.out.println("Id: " + count + " | Name: " + adoptersQueue.get().getName() +
//					" | Email: " + it.getEmail() + " | Age: " + adoptersQueue.get(i).getAge() +
//					" | Phone Number: " + adoptersQueue.get(i).getPhoneNumber() + " | Address: " + adoptersQueue.get(i).getAddress() +
//					" | Date of First Visit: " + adoptersQueue.get(i).getFirstVisit() + " | Species Preference: " +
//					adoptersQueue.get(i).getAnimalTypePreference() + " | Have children? " + adoptersQueue.get(i).isHaveChildren() +
//					" | Interested in Disabled pets? " + adoptersQueue.get(i).isInterestInDisabledPets());
			
		}
		System.out.println();
	}
	
	//Add Adopters
	public void addAdopters(Queue<Adopters> adoptersQueue) {
		Adopters adopter;
	
		System.out.println("Please enter the adopter's information: ");
		System.out.print("Adopter's name: ");
		String name = in.nextLine();
		
	
		Integer age = (Integer) null;
		//checks to make sure the age inputed is in number for and is 18 or older
		do {
			System.out.print("Age: ");
			String ageString = in.nextLine();
		
		try {
			age = Integer.parseInt(ageString);
		} catch(NumberFormatException e) {
			System.out.println("Invalid input, try again");
		} 
		} while (age == null || age < 18); //makes sure the age is not less than 18, have to be 18 to adopt an animal

		System.out.print("Email: ");
		String email = in.nextLine();
		
		System.out.print("Phone number: ");
		String phoneNumber = in.nextLine();
		
		System.out.print("Address: ");
		String address = in.nextLine();
		
		System.out.print("Species preference: ");
		String preference = in.nextLine();
		
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

		//create new object, date is defined in the constructor of adopter
		adopter = new Adopters(age, name, address, phoneNumber, email, preference, disabledyn, kidsyn);
		
		//add adopter to array
		adoptersQueue.add(adopter);
		System.out.println("Adopter added");
		System.out.println();
		
	}

	/**
	 *  Delete Adopters
	 */
	public void deleteAdopters(Queue<Adopters> adoptersQueue) {	
		System.out.println("What adopter would you like to delete?");
		//if the list is empty, output tht there are no adopters available and return the list
		if(adoptersQueue.isEmpty()) {
			System.out.println("No adopters available.");
			return;
		}
		
		//gets adopters ID
		System.out.println("Adopter from head of queue will be removed.");
		//removes adopter from list
		System.out.println("Adopter removed: " + adoptersQueue.poll());
		System.out.println();
	}
	
	//shows next adopter in the queue
	public void showNextInQueue(Queue<Adopters> adoptersQueue) {
		System.out.println("Adopter next in line: " + adoptersQueue.peek().toString());	
		System.out.println();
	}
	
	
}
