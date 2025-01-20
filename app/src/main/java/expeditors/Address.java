package expeditors;

import java.util.Objects;

/**
 * This class creates an Address object,
 * containing information about street name, city, and state.
 */
public class Address {

    private static final String ST = "ST";
    private static final String STREET = "STREET";
    private String address;
    private String city;
    private String state;

    /**
     * Creates an Address object
     * 
     * @param address   The address and street name
     * @param city      The city of the address
     * @param state     The state of the city
     */
    public Address (String address, String city, String state) {
        // Check for valid input
        if (address == null || city == null || state == null 
            || address.isEmpty() || city.isEmpty() || state.isEmpty()) {
                throw new IllegalArgumentException(
                    "Must enter a valid address, cannot be null or empty.");
        }
        
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }

    
    /**
     * Overrides equals method.
     * 
     * Returns whether some other Address is 'equal to' this one.
     * 
     * Assumption: two Address(es) are equal  
     * if they have the same address, city, state.
     */
    @Override
    public boolean equals(Object obj) {
        // Compare object to itself
        if (this == obj) { return true; }
        
        // Check object is an instance of 'Address'
        if (!(obj instanceof Address)) { return false; }
        
        Address other = (Address) obj;
        String[] thisAddressArr = address.split(" ");
        String[] otherAddressArr = other.address.split(" ");

        // Compare length of addresses
        if (thisAddressArr.length != otherAddressArr.length) {
            return false;
        }

        // Compare each segment of address for equality
        for (int i = 0; i < thisAddressArr.length; i++) {
            String thisSubstring = thisAddressArr[i];
            String otherSubstring = otherAddressArr[i];

            // Check for ST vs STREET, 
            // would ideally check for Ave == Avenue and Blvd == Boulevard as well, 
            // but it is not needed for this example input
            if (ST.equalsIgnoreCase(thisSubstring) 
                || STREET.equalsIgnoreCase(thisSubstring)) {

                if (!(ST.equalsIgnoreCase(otherSubstring)) 
                    && !(STREET.equalsIgnoreCase(otherSubstring))) {
                    return false;
                }

            } else {
                if (!(thisSubstring.equalsIgnoreCase(otherSubstring))) {
                    return false;
                }
            }
        }
        
        // Address is equal, now compare city and state, while ignore case
        return city.equalsIgnoreCase(other.city) && state.equalsIgnoreCase(other.state);
    }

    /**
     * Overrides hashCode method.
     * 
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(address.toLowerCase(), 
                            city.toLowerCase(), 
                            state.toLowerCase());
    }

    /**
     * Overrides toString method.
     * 
     * Return a string representation of the object.
    */
    @Override
    public String toString() {
        return  address + ", " + city + ", " + state;
    }
    
}
