package com.momo;

import java.util.Scanner;

public class PersonTest {
    private static PersonData personData = new PersonData(); // Instantiation of the person data class
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        boolean isTrue = false;
        menuOptions();
        while (!isTrue){

            int choice = getInteger();
            System.out.println(choice);
            switch (choice){
                case 0:
                    isTrue = true;
                    break;
                case 1:
                    addPersonRecord();
                    break;
                case 2:
                    removePerson();
                    break;
                case 3:
                    editPerson();
                    break;
                case 4:
                    queryAPerson();
                    break;
                case 5:
                    deletePerson();
                    break;
                case 6:
                    displayPersonNames();
                    break;


            }
        }
}


    // A static method that adds a person to our HashSet
    private static void addPersonRecord(){
        String firstName = getStringData("Please enter first name: ");
        String lastName = getStringData("Please enter last name: ");
        personData.addPerson(firstName, lastName);

    }

    // A static method that gets a user input in a string format
    private static String getStringData(String info){
        System.out.print(info);
        String userInput = input.next();
        input.nextLine();
        return userInput;
    }
    // A static method that return an integer entered by a user
    private static int getInteger(){
        boolean quit = false;
        int valid_number = 0;
        do{
            try {
                valid_number = Integer.parseInt(getStringData("Please enter a valid number: "));
                quit = true;
            }catch (NumberFormatException ex){
                System.out.println("Please enter a valid integer.");
            }
        }while (!quit);
     return valid_number;
    }

    // A static method that remove a person from a Hashset
    private static void removePerson(){
        String firstName = getStringData("Please enter the first name of the person you would like to delete: ");
        String lastName = getStringData("Please enter the last name of the person you would like to delete: ");
        personData.removePerson(firstName, lastName);
    }

    // A static method that edits a person object data
    private static void editPerson(){
        String firstName = getStringData("Please enter the first name you would like to edit: ");
        String lastName = getStringData("Please enter the last name you would like to edit: ");
        String oldName = String.format("%s %s", firstName, lastName);
        if(personData.editPersonData(firstName, lastName)){
            firstName = getStringData("Please enter the new first name: ");
            lastName = getStringData("Please enter the new last name: ");
            String currentName = String.format("%s %s", firstName, lastName);
            if(personData.addPerson(firstName, lastName)){
                System.out.printf("%s has been changed to %s.%n", oldName, currentName);
            }

        }
    }

    // A static void method that query a person in our person object HashSet
    private static void queryAPerson(){
        String firstName = getStringData("Please enter first name would you like to search: ");
        String lastName = getStringData("Please enter last name would you like to search: ");
        System.out.println(personData.queryPerson(firstName, lastName));
    }

    // A static void method that delete a person from the Hashset
    private static void deletePerson(){
        String firstName = getStringData("Please enter first name you would like to delete: ");
        String lastName = getStringData("Please enter last name you would like to delete: ");
        personData.deletePerson(firstName, lastName);
    }

    // A static void method that display data from our HashSet
    private static void displayPersonNames(){
        personData.displayNames();
    }
    // A void method that display menu options
    public static void menuOptions(){
        System.out.printf("%d----------> Exit the program%n%d----------> Add a person%n%d----------> Remove a person%n" +
                "%d----------> Edit a person data%n%d----------> Search a person%n%d----------> Delete a person record%n" +
                "%d----------> Display persons record%n7----------> Display menu options%n", 0, 1, 2, 3, 4, 5, 6, 7);
    }

}



