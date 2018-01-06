package com.momo;

import java.util.HashSet;
import java.util.Set;

public class PersonData {
    private Set<Person> personInfo; // A set of person Objects

    public PersonData(){
        this.personInfo = new HashSet<>();
    }

    // A method that adds a person to Hashset, return false if the exact name exist in the Hashset, otherwise returns true
    public boolean addPerson(String firstName, String lastName){
        Person foundPerson = findPerson(firstName, lastName);
        if(foundPerson != null){
            System.out.printf("%s %s has already been added to our person HashSet%n", foundPerson.getFirstName(),foundPerson.getLastName());
            return false;
        }else {
            this.personInfo.add(new Person(firstName, lastName));
            return true;
        }
    }

    // A method that finds a person in our Hashset Searches for a person using first name and last name, returns a person object if the person exist
    // Otherwise return null
    private Person findPerson(String firstName, String lastName){
        for(Person person: this.personInfo){
            if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)){
                return person;
            }
        }

        return null;
    }

    // A method that removed a person object from our set. Returns true if person object exist otherwise false
    public boolean removePerson(String firstName, String lastName){
        Person foundPerson = findPerson(firstName, lastName);
        if(foundPerson != null){
            System.out.printf("%s %s has been remove from the HashSet successfully.%n", foundPerson.getFirstName(), foundPerson.getLastName());
            this.personInfo.remove(foundPerson);
            return true;
        }
        else{
            System.out.printf("There was information that matches %s %s in our HashSet. %n", firstName, lastName);
            return false;
        }
    }
    // return true if a person is editable otherwise false
    public boolean editPersonData(String firstName, String lastName){
        Person foundPerson = findPerson(firstName, lastName);
        if(foundPerson != null){
            System.out.printf("You want to edit %s %s information%n", foundPerson.getFirstName(), foundPerson.getLastName());
            this.personInfo.remove(foundPerson);
            return true;
        }
        else{
            System.out.printf("%s %s isn't in our HashSet. You can't edit an unavailable data%n", firstName, lastName);
            return false;
        }

    }
    // Return the string representation of a person found in the Hashset
    public String queryPerson(String firstName, String lastName){
        Person foundPerson = findPerson(firstName, lastName);
            if(foundPerson != null){
                return String.format("Found %s %s in our person HashSet", foundPerson.getFirstName(), foundPerson.getLastName());
            }else{
                return String.format("%s %s isn't available in our person HashSet", firstName, lastName);
            }
        }
        // Return true if a person is deleted otherwise return false
        public boolean deletePerson(String firstName, String lastName){
        Person foundPerson = findPerson(firstName, lastName);
        if(foundPerson != null){
            this.personInfo.remove(foundPerson);
            System.out.printf("%s %s has been deleted from the person HashSet. %n", firstName, lastName);
            return true;
        }else{
            System.out.printf("%s %s is not in our person HashSet %n", firstName, lastName);
            return false;
        }
        }
    // Display names of various persons in our person Hashset.
    public void displayNames(){
        for(Person person: this.personInfo){
            System.out.println(person.toString());
        }
    }

}
