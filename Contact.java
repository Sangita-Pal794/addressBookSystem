
public class Contact {
	
	private String firstName;
    private String lastName;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;

    /*Constructor*/
    public Contact(String firstName, String lastName, String city, String state, int zip, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    /*Getters & Setters*/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*Overriding the toString method to return the content as per preference*/
    @Override
    public String toString() {
        return "\nFirstName : "+this.firstName +"\nLastName : "+this.lastName +"\nCity : "+this.city +"\nState : "+this.state +"\nZip : "+this.zip +"\nPhoneNumber : "+this.phoneNumber;
    }

}
