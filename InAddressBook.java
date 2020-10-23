import java.util.Map;

interface InAddressBook {
	public void addContact(Contact newPerson);
	public void editContact(Contact existingPerson, int option, String newDetails);
	public void deleteContact (String fullNameID);
	public void sortAlphabetically (Map<String, Contact> addressBook);
    public void sortByCity(Map<String, Contact> addressBook);
    public void sortByState(Map<String, Contact> addressBook);
    public void sortByZip(Map<String, Contact> addressBook);
    public Map<String, Contact> cityDictionary (Map<String, Contact> addressBook);
    public Map<String, Contact> stateDictionary (Map<String, Contact> addressBook);
    public void searchByCity(Map<String, Contact> addressBook, String city);
    public void searchByState(Map<String, Contact> addressBook, String state);
}
