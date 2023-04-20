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
import classes.Pets;


/**
 * @author abbyb
 *
 */
class petsTest {
	@Test
	void testPetsSettersNoDate() {
		
		Pets p = new Pets("Winnie", 6, "dog", "Mini Yorkie", true, false);
	
		assertEquals(6, p.getAge());
		assertEquals("Winnie", p.getName());
		assertEquals("Mini Yorkie", p.getBreed());
		assertEquals(true, p.isGoodWithChildren());
		assertEquals(false, p.isDisabilities());
	}
	
	@Test
	void testPetsSettersWithDate() {
		//testing different constructor
		Pets p = new Pets("Winnie", 6, "dog", "Mini Yorkie", "2015-05-14", true, false);
	
		assertEquals(6, p.getAge());
		assertEquals("Winnie", p.getName());
		assertEquals("Mini Yorkie", p.getBreed());
		assertEquals(true, p.isGoodWithChildren());
		assertEquals(false, p.isDisabilities());
		
	}
	
	@Test
	void testIfDateSetCorreclyWithDate() {
		Pets p = new Pets("Winnie", 6, "dog", "Mini Yorkie", "2015-05-14", true, false);
		
		LocalDate ld = LocalDate.parse("2015-05-14");
		assertEquals(ld, p.getDateOfArrival());
	}
	
	@Test
	void testIfDateSetCorreclyWODate() {
		Pets p = new Pets("Winnie", 6, "dog", "Mini Yorkie", true, false);
	
		assertEquals(LocalDate.now(), p.getDateOfArrival());
	}
	
	

}
