	import java.util.ArrayList;
	import java.util.List;

	public class AddressBook implements InAddressBook{
	    private List<Contact> contactList;
	    private String userName;
	    public AddressBook(String userName) {
	        contactList = new ArrayList<>();
	    }

	    @Override
	    public void addContact(Contact newPerson) {
	        contactList.add(newPerson);
	    }
	     public List<Contact> getContactList() {
	        return contactList;
	     }
	}


