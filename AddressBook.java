	//import java.security.Key;
	import java.util.*;
	import java.util.function.Function;
	import java.util.stream.Collectors;


	public class AddressBook implements InAddressBook{
		private Map<String, Contact> contactList;
	    private Contact person;
	    private String id;

	    public AddressBook() {
	        contactList = new LinkedHashMap<>();
	    }

	    /*
	    * Storing the Contact Details in Map
	    * Key = person ID (String)
	    * Value = Contact (String)
	    */
	    @Override
	    public void addContact(Contact newPerson) {
	        this.id = newPerson.getId();
	        contactList.put(this.id, newPerson);
	    }

	    public Map<String, Contact> getContactList() {
	        return contactList;
	    }

	    public Contact findContact(String findID) {
	        Contact tempCon = contactList.get(findID);
	        return tempCon;
	    }

	    @Override
	    public void editContact(Contact existingPerson, int option, String newDetails) {
	        this.person = existingPerson;
	        switch (option) {
	            case 1:
	                editAddress(this.person, newDetails);
	                break;
	            case 2:
	                editCity(this.person, newDetails);
	                break;
	            case 3:
	                editState(this.person, newDetails);
	                break;
	            case 4:
	                editZip(this.person, Integer.parseInt(newDetails));
	                break;
	            case 5:
	                editPhoneNumber(this.person, Long.parseLong(newDetails));
	                break;
	            default:
	                System.out.println("Error: Invalid option number");
	                break;
	        }
	    }

	    private void editAddress(Contact person, String newAddress) {
	        this.id = person.getId();
	        Contact tempContact = contactList.get(this.id);
	        tempContact.setAddress(newAddress);
	        contactList.replace(this.id, tempContact);
	    }

	    private void editCity(Contact person, String newCity) {
	        this.id = person.getId();
	        Contact tempContact = contactList.get(this.id);
	        tempContact.setCity(newCity);
	        contactList.replace(this.id, tempContact);
	    }

	    private void editState(Contact person, String newState) {
	        this.id = person.getId();
	        Contact tempContact = contactList.get(this.id);
	        tempContact.setState(newState);
	        contactList.replace(this.id, tempContact);
	    }

	    private void editZip(Contact person, int newZip) {
	        this.id = person.getId();
	        Contact tempContact = contactList.get(this.id);
	        tempContact.setZip(newZip);
	        contactList.replace(this.id, tempContact);
	    }

	    private void editPhoneNumber(Contact person, long newPhoneNumber) {
	        this.id = person.getId();
	        Contact tempContact = contactList.get(this.id);
	        tempContact.setPhoneNumber(newPhoneNumber);
	        contactList.replace(this.id, tempContact);
	    }
	    
	    /* Method to delete a Contact from the Address Book*/
	    public void deleteContact(String fullNameID) {
	        contactList.remove(fullNameID);
	    }

	    /**
	     * Method to Check for Duplicate Contacts using Java Streams
	     * @parameter fullName
	     * @return duplicateContact
	     */
	    public Contact duplicateEntry(String fullName) {
	        boolean testDuplicate =  contactList.keySet()
	                .stream()
	                .noneMatch(string -> string.equals(fullName));
	        Contact duplicateContact = testDuplicate == false ?
	                contactList.get(fullName) : null;
	        return  duplicateContact;
	    }

	    /**
	     * Using Java Streams to Sort the Address Book Alphabetically
	     * @parameter addressBook
	     */
	    @Override
	    public void sortAlphabetically(Map<String, Contact> addressBook) {
	        Map<String, Contact> contactsSortedAlphabetically = contactList.entrySet()
	                .stream()
	                .sorted(Map.Entry.<String, Contact>comparingByKey())
	                .collect(Collectors.toMap(Map.Entry::getKey,
	                        Map.Entry::getValue,
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new));
	        contactsSortedAlphabetically.forEach((fullName, people) -> {
	            System.out.println();
	            System.out.print(fullName);
	            System.out.print(people);
	            System.out.println();
	        });
	    }

	    /**
	     * Using Java Streams to Sort the Address Book by City, State & Zip
	     * @param addressBook
	     */
	    @Override
	    public void sortByCity(Map<String, Contact> addressBook) {
	        Map<String, Contact> contactsSortedByCity = contactList.entrySet()
	                .stream()
	                .sorted(Map.Entry.<String, Contact>comparingByValue(Comparator.comparing(Contact::getCity)))
	                .collect(Collectors.toMap(Map.Entry::getKey,
	                        Map.Entry::getValue,
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new));
	        contactsSortedByCity.forEach((fullName, people) -> {
	            System.out.println();
	            System.out.print(fullName);
	            System.out.print(people);
	            System.out.println();
	        });
	    }

	    @Override
	    public void sortByState(Map<String, Contact> addressBook) {
	        Map<String, Contact> contactsSortedByState = contactList.entrySet()
	                .stream()
	                .sorted(Map.Entry.<String, Contact>comparingByValue(Comparator.comparing(Contact::getState)))
	                .collect(Collectors.toMap(Map.Entry::getKey,
	                        Map.Entry::getValue,
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new));
	        contactsSortedByState.forEach((fullName, people) -> {
	            System.out.println();
	            System.out.print(fullName);
	            System.out.print(people);
	            System.out.println();
	        });
	    }

	    @Override
	    public void sortByZip(Map<String, Contact> addressBook) {
	        Map<String, Contact> contactsSortedByZip = contactList.entrySet()
	                .stream()
	                .sorted(Map.Entry.<String, Contact>comparingByValue(Comparator.comparing(Contact::getZip)))
	                .collect(Collectors.toMap(Map.Entry::getKey,
	                        Map.Entry::getValue,
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new));
	        contactsSortedByZip.forEach((fullName, people) -> {
	            System.out.println();
	            System.out.print(fullName);
	            System.out.print(people);
	            System.out.println();
	        });
	    }

	    /**
	     * Using Java Streams to Create City & State Dictionaries
	     * @param addressBook
	     * @return dictionary
	     */
	    public Map<String, Contact> cityDictionary (Map<String, Contact> addressBook) {
	        Map<String, Contact> cityDict = addressBook.values()
	                .stream()
	                .collect(Collectors.toMap(Contact::getCity,
	                        Function.identity(),
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new));
	        return cityDict;
	    }

	    public Map<String, Contact> stateDictionary (Map<String, Contact> addressBook) {
	        Map<String, Contact> stateDict = addressBook.values()
	                .stream()
	                .collect(Collectors.toMap(Contact::getState,
	                        Function.identity(),
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new));
	        return stateDict;
	    }

	    /**
	     * Using Java Streams searching Contacts by City & State
	     * @param addressBook
	     * @param city
	     */
	    public void searchByCity(Map<String, Contact> addressBook, String city) {
	            addressBook.values()
	                    .stream()
	                    .filter(tempContact -> tempContact.getCity().equals(city))
	                    .forEach(System.out::println);
	    }

	    public void searchByState(Map<String, Contact> addressBook, String state) {
	        addressBook.values()
	                .stream()
	                .filter(tempContact -> tempContact.getState().equals(state))
	                .forEach(System.out::println);
	    }
	}

	    
	    
	

	


