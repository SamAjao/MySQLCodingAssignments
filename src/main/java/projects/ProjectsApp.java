/*
// Program: Promineo Tech Backend Java Development Course
// Author:  Samuel Ajao
// Subject:  Java- MySQL Project
// Create Date: May 31, 2024
//
*/

package projects;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.exception.DbException;


public class ProjectsApp {
	
	private Scanner scanner = new Scanner(System.in);
	
	// @formatter:off
	private List<String> operations = List.of(
			"1) Add a project"
	);			
	// @formatter:on
	

	public static void main(String[] args) {
		//
		new ProjectsApp().processUserSelections();

	}
	
	public void processUserSelections() {
		boolean done = false;
		
		while(!done) {
			try {
				int selection = getUserSelection();
				
				switch (selection) {
				case -1:
					done = exitMenu();
					break;				
				default:
					System.out.println("\n" + selection + " is not a valid selection. Try again.");
					break;
				}
			}
			catch(Exception e) {
				System.out.println("\nError: " + e + " Try again.");
			}
		}
		
	}

	private boolean exitMenu() {
		System.out.println("\nExiting the menu.");
		return true;
	}

	private int getUserSelection() {
		printOperations();
		
		Integer input = getIntInput("Enter a menu selection");
		
		return Objects.isNull(input) ? -1 : input;
	}

	private void printOperations() {
		System.out.println("\nThese are the available selections. Press the Enter key to quit:");
		
		operations.forEach(line -> System.out.println("   " + line));
		
	}
	
	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		
		if(Objects.isNull(input)) {
			return null;
		}
		
		try {
			return Integer.valueOf(input);
		}
		catch(NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}
		
	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String line = scanner.nextLine();
		
		return line.isBlank() ? null : line.trim();
	}

} //End 'Projects' class
