import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class main {
	public AddressBook user = new AddressBook();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
	        System.out.println("---------------------------\n");
	        System.out.println("\nWelcome To Address Book!");
	        main usrApp = new main();

	        app: while(true) {
	            System.out.println("\n1. Add New Contact"
	                            + "\n2. Edit Contact"
	                            + "\n3. Display Address Book"
	                            + "\n4. Delete Contact"
	                            + "\n4. Sort Address Book Alphabetically"
	                            + "\n5. Sort Address Book by City"
	                            + "\n6. Sort Address Book by State"
	                            + "\n7. Sort Address Book by Zip"
	                            + "\n8. View City Dictionary Contacts"
	                            + "\n9. View State Dictionary Contacts"
	                            + "\n10. Search Contacts by City"
	                            + "\n11. Search Contacts by State"
	                            + "\n12. Exit Address Book");
	            System.out.println("Enter Option: ");
	            int choice = sc.nextInt();

	            switch (choice) {
                case 1:
                    usrApp.newContactEntry();
                    break;
                case 2:
                    usrApp.editContactScreen();
                    break;
                case 3:
                    usrApp.streamDisplayAddressBook();
                    break;
                case 4:
                    usrApp.deleteContactScreen();
                    break;
                case 5:
                    System.out.println("\nAddress Book Sorted Alphabetically below:");
                    usrApp.user.sortAlphabetically(usrApp.user.getContactList());
                    break;
                case 6:
                    System.out.println("\nAddress Book Sorted by City below:");
                    usrApp.user.sortByCity(usrApp.user.getContactList());
                    break;
                case 7:
                    System.out.println("\nAddress Book Sorted by State below:");
                    usrApp.user.sortByState(usrApp.user.getContactList());
                    break;
                case 8:
                    System.out.println("\nAddress Book Sorted by Zip below:");
                    usrApp.user.sortByZip(usrApp.user.getContactList());
                    break;
                case 9:
                    System.out.println("\nContacts by City: ");
                    usrApp.displayMapContents(usrApp.user.cityDictionary(usrApp.user.getContactList()));
                    break;
                case 10:
                    System.out.println("Contacts by State: ");
                    usrApp.displayMapContents(usrApp.user.stateDictionary(usrApp.user.getContactList()));
                    break;
                case 11:
                    System.out.println("Search by City results: ");
                    usrApp.searchByCityScreen();
                    break;
                case 12:
                    System.out.println("Search by State results: ");
                    usrApp.searchByStateScreen();
                    break;
                case 13:
                    System.out.println("\nExiting ... Application Closed!");
                    break app;
	            default:
	                    System.out.println("\nError: Invalid option...\nTry Again...");
	                    break;
	            }
	        }
	        public void newContactEntry() {
	            Scanner scan = new Scanner(System.in);
	            String firstName, lastName, address, city, state;
	            int zip;
	            long phoneNum;

	            System.out.println("Enter First Name: ");
	            firstName = scan.nextLine();
	            System.out.println("Enter Last Name: ");
	            lastName = scan.nextLine();
	            System.out.println("Enter Address: ");
	            address = scan.nextLine();
	            System.out.println("Enter City: ");
	            city = scan.nextLine();
	            System.out.println("Enter State: ");
	            state = scan.nextLine();
	            zipNum: while(true) {
	                try {
	                    System.out.println("Enter Zip: ");
	                    scan = new Scanner(System.in);
	                    zip = scan.nextInt();
	                    break zipNum;
	                } catch (InputMismatchException e) {
	                    System.out.println("Error: Invalid Input\nTry Again...");
	                    continue;
	                }
	            }
	            phNum: while (true) {
	                try {
	                    System.out.println("Enter Phone Number: ");
	                    scan = new Scanner(System.in);
	                    phoneNum = scan.nextLong();
	                    break phNum;
	                } catch (InputMismatchException e) {
	                    System.out.println("Error: Invalid Input\nTry Again...");
	                    continue;
	                }
	            }

	            // Creating a new Contact and saving into Map
	            Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNum);
	            user.addContact(newContact);
	            System.out.println("\nNewly Added Contact Details: " + user.findContact(firstName.concat(lastName)));
	        }

	        public void editContactScreen() {

	            String tempFirst, tempLast, tempID, newAddress, newCity, newState, newZip, newPhone;
	            Scanner scan = new Scanner(System.in);
	            System.out.println("Enter the First Name of the Contact to be Edited: ");
	            tempFirst = scan.nextLine();
	            System.out.println("Enter the Last Name of the Contact to be Edited: ");
	            tempLast = scan.nextLine();
	            tempID = tempFirst.concat(tempLast);

	            // Finding the person and Displaying the details before editing
	            Contact foundPerson = user.findContact(tempID);
	            System.out.println("\n----------------------");
	            System.out.println("\nDetails of the Person Found: \n" +  foundPerson);

	            editLoop: while(true) {
	                scan = new Scanner(System.in);
	                System.out.println("\nChoose Fields to edit: "
	                        + "\n1. Address"
	                        + "\n2. City"
	                        + "\n3. State"
	                        + "\n4. Zip"
	                        + "\n5. Phone Number"
	                        + "\n6. Exit Editing");
	                System.out.println("\nEnter Choice: ");
	                int choice = scan.nextInt();
	                scan.nextLine();

	                switch (choice) {
	                    case 1:
	                        System.out.println("\nEnter the New Address: ");
	                        newAddress = scan.nextLine();
	                        user.editContact(foundPerson, 1, newAddress);
	                        break;
	                    case 2:
	                        System.out.println("\nEnter the New City: ");
	                        newCity = scan.nextLine();
	                        user.editContact(foundPerson, 2, newCity);
	                        break;
	                    case 3:
	                        System.out.println("\nEnter the New State: ");
	                        newState = scan.nextLine();
	                        user.editContact(foundPerson, 3, newState);
	                        break;
	                    case 4:
	                        System.out.println("\nEnter the New Zip: ");
	                        newZip = scan.nextLine();
	                        user.editContact(foundPerson, 4, newZip);
	                        break;
	                    case 5:
	                        System.out.println("\nEnter the New Phone Number: ");
	                        newPhone = scan.nextLine();
	                        user.editContact(foundPerson, 2, newPhone);
	                        break;
	                    case 6:
	                        break editLoop;
	                    default:
	                }
	            }
	            System.out.println("Edited Details: " + user.findContact(tempID));
	        }
	        public void deleteContactScreen() {
		        String tempFirst, tempLast, tempID;
		        Scanner scan = new Scanner(System.in);
		        System.out.println("Enter the First Name of the Contact to be Edited: ");
		        tempFirst = scan.nextLine();
		        System.out.println("Enter the Last Name of the Contact to be Edited: ");
		        tempLast = scan.nextLine();
		        tempID = tempFirst.concat(tempLast);
		        user.deleteContact(tempID);
		        System.out.println("\nContact Deleted Successfully!");
		    }

		    /* Method to display All the Contacts of the Address Book*/
	        /**
	         * Method to display All the Contacts of the Address Book
	         */
	        public void streamDisplayAddressBook() {
	            if (user.getContactList().isEmpty()) {
	                System.out.println("\nAddress Book is Empty! Add New Contacts!");
	            } else {
	                user.getContactList()
	                        .forEach((fullName, people) -> {
	                            System.out.println();
	                            System.out.print(fullName);
	                            System.out.print(people);
	                            System.out.println();
	                        });
	            }
	        }

	        /**
	         * Methods to search Contacts by City & State using Java Streams
	         */
	        public void searchByCityScreen() {
	            String city;
	            Scanner scan = new Scanner(System.in);
	            System.out.println("Enter City: ");
	            city = scan.nextLine();
	            user.searchByCity(user.getContactList(), city);
	        }

	        public void searchByStateScreen() {
	            String state;
	            Scanner scan = new Scanner(System.in);
	            System.out.println("Enter State: ");
	            state = scan.nextLine();
	            user.searchByState(user.getContactList(), state);
	        }

	        /**
	         * Method to Pass a Map and Print out its Contents
	         * @param mapToBeDisplayed
	         */
	        public void displayMapContents(Map<String, Contact> mapToBeDisplayed) {
	            mapToBeDisplayed.forEach((id, people) -> {
	                System.out.println();
	                System.out.print(id);
	                System.out.print(people);
	                System.out.println();
	            });
	        }
	    

	    }
	
	


