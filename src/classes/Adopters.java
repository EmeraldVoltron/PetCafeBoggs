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
public class Adopters {
	private int age;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private LocalDate firstVisit;
	private String animalTypePreference;
	private boolean interestInDisabledPets;
	private boolean haveChildren;
	
	public Adopters() {
		
	}
	
	public Adopters(int age, String name, String address, String phoneNumber, String email,
			String animalTypePreference, boolean interestInDisabledPets, boolean haveChildren) {
		this.age = age;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.animalTypePreference = animalTypePreference;
		this.interestInDisabledPets = interestInDisabledPets;
		this.haveChildren = haveChildren;
		
		this.firstVisit = LocalDate.now();
	}
	
	public Adopters(int age, String name, String address, String phoneNumber, String email,
			String firstVisit, String animalTypePreference, boolean interestInDisabledPets, boolean haveChildren) {
		this.age = age;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.firstVisit = LocalDate.parse(firstVisit);
		this.animalTypePreference = animalTypePreference;
		this.interestInDisabledPets = interestInDisabledPets;
		this.haveChildren = haveChildren;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the firstVisit
	 */
	public LocalDate getFirstVisit() {
		return firstVisit;
	}
	/**
	 * @param firstVisit the firstVisit to set
	 */
	public void setFirstVisit(LocalDate firstVisit) {
		this.firstVisit = firstVisit;
	}
	/**
	 * @return the animalTypePreference
	 */
	public String getAnimalTypePreference() {
		return animalTypePreference;
	}
	/**
	 * @param animalTypePreference the animalTypePreference to set
	 */
	public void setAnimalTypePreference(String animalTypePreference) {
		this.animalTypePreference = animalTypePreference;
	}
	
	/**
	 * @return the interestInDisabledPets
	 */
	public boolean isInterestInDisabledPets() {
		return interestInDisabledPets;
	}

	/**
	 * @param interestInDisabledPets the interestInDisabledPets to set
	 */
	public void setInterestInDisabledPets(boolean interestInDisabledPets) {
		this.interestInDisabledPets = interestInDisabledPets;
	}
	
	/**
	 * @return the haveChildren
	 */
	public boolean isHaveChildren() {
		return haveChildren;
	}
	/**
	 * @param haveChildren the haveChildren to set
	 */
	public void setHaveChildren(boolean haveChildren) {
		this.haveChildren = haveChildren;
	}

	@Override
	public String toString() {
		return "Adopters [age=" + age + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", firstVisit=" + firstVisit + ", animalTypePreference=" + animalTypePreference
				+ ", interestInDisabledPets=" + interestInDisabledPets + ", haveChildren=" + haveChildren + "]";
	}
	
	
	
	
	
	
	
}
