
interface InAddressBook {
	public void addContact(Contact newPerson);
	public void editContact(Contact existingPerson, int option, String newDetails);
	public void deleteContact (String fullNameID);
}
