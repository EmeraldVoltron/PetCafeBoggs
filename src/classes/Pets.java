package classes;
import java.time.LocalDate;

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

/**
 * @author abbyb
 *
 */
public class Pets {
	private int age;
	private String name;
	private String typeOfAnimal;
	private String breed;
	private LocalDate dateOfArrival;
	private boolean goodWithChildren;
	private boolean disabilities;
	
	public Pets() {
		
	} 
	
	public Pets(String name, int age, String typeOfAnimal, String breed,
			boolean goodWithChildren, boolean disabilities) {
		this.age = age;
		this.typeOfAnimal = typeOfAnimal;
		this.name = name;
		this.breed = breed;
		this.dateOfArrival = LocalDate.now();
		this.goodWithChildren = goodWithChildren;
		this.disabilities = disabilities;
	}
	
	public Pets(String name, int age, String typeOfAnimal, String breed, LocalDate dateOfArrival,
			boolean goodWithChildren, boolean disabilities) {
		this.age = age;
		this.typeOfAnimal = typeOfAnimal;
		this.name = name;
		this.breed = breed;			
		this.dateOfArrival = dateOfArrival;
		this.goodWithChildren = goodWithChildren;
		this.disabilities = disabilities;
	}
	
	/**
	 * @return the goodWithChildren
	 */
	public boolean isGoodWithChildren() {
		return goodWithChildren;
	}
	/**
	 * @param goodWithChildren the goodWithChildren to set
	 */
	public void setGoodWithChildren(boolean goodWithChildren) {
		this.goodWithChildren = goodWithChildren;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the disabilities
	 */
	public boolean isDisabilities() {
		return disabilities;
	}
	/**
	 * @param disabilities the disabilities to set
	 */
	public void setDisabilities(boolean disabilities) {
		this.disabilities = disabilities;
	}
	/**
	 * @return the typeOfAnimal
	 */
	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}
	/**
	 * @param typeOfAnimal the typeOfAnimal to set
	 */
	public void setTypeOfAnimal(String typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	/**
	 * @return the dateOfArrival
	 */
	public LocalDate getDateOfArrival() {
		return dateOfArrival;
	}
	/**
	 * @param dateOfArrival the dateOfArrival to set
	 */
	public void setDateOfArrival(LocalDate dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}
	
	@Override
	public String toString() {
		return "Pet name: " + name + " | Age: " + age + " | Disabled? " + disabilities + " | Species: " +
			 typeOfAnimal + " | Breed: " + breed + " | Date of Arrival: " + dateOfArrival;
	}
	
	
	
}
