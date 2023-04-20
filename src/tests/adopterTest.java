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

package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import classes.Adopters;

/**
 * @author abbyb
 *
 */
class adopterTest {
	
	@Test
	void testAllSettersWithOutDate() {
		Adopters n = new Adopters(19, "Abby", "123 Main St, Des Moines, Iowa 50310", "319-999-9999", "amboggs@dmacc.edu",
				"dog", true, false);
		
		assertEquals("Abby", n.getName());
		assertEquals(19, n.getAge());
		assertEquals("123 Main St, Des Moines, Iowa 50310", n.getAddress());
		assertEquals("amboggs@dmacc.edu", n.getEmail());
		assertEquals("dog", n.getAnimalTypePreference());
		assertEquals(true, n.isInterestInDisabledPets());
		assertEquals(false, n.isHaveChildren());
		
		
	}
	
	@Test
	void testAllSettersWithDate() {
		Adopters n = new Adopters(19, "Abby", "123 Main St, Des Moines, Iowa 50310", "319-999-9999", "amboggs@dmacc.edu",
				"2022-10-13", "dog", true, false);
		
		assertEquals("Abby", n.getName());
		assertEquals(19, n.getAge());
		assertEquals("123 Main St, Des Moines, Iowa 50310", n.getAddress());
		assertEquals("amboggs@dmacc.edu", n.getEmail());
		assertEquals("dog", n.getAnimalTypePreference());
		assertEquals(true, n.isInterestInDisabledPets());
		assertEquals(false, n.isHaveChildren());
	}
	
	@Test
	void testIfDateSetCorrectlyWithDate() {
		Adopters n = new Adopters(19, "Abby", "123 Main St, Des Moines, Iowa 50310", "319-999-9999", "amboggs@dmacc.edu",
				"2022-10-13", "dog", true, false);
		
		LocalDate ld = LocalDate.parse("2022-10-13");
		assertEquals(ld, n.getFirstVisit());
	}
	
	@Test
	void testIfDateSetCorreclyWODate() {
		Adopters n = new Adopters(19, "Abby", "123 Main St, Des Moines, Iowa 50310", "319-999-9999", "amboggs@dmacc.edu",
				"dog", true, false);
		
		assertEquals(LocalDate.now(), n.getFirstVisit());
	}

}
