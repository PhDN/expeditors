package expeditors;

import java.util.Objects;

/**
 * This class creates a Person object, 
 * containing information about their first name, 
 * last name, address, and age.
 */
public class Person {

    private String firstName;
    private String lastName;
    private Address address;
    private int age;

    /**
     * Creates a Person object.
     * 
     * @param firstName Their first name
     * @param lastName  Their last name
     * @param address   Their address
     * @param age       Their age
     */
    public Person(String firstName, String lastName,
                Address address, int age) {
        
        // Check for valid input
        if (firstName == null || lastName == null || address == null || age < 0 
            || firstName.isEmpty() || lastName.isEmpty()) {
                throw new IllegalArgumentException(
                    "Must provide valid first name, last name, and a non-negative age");
        }
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public Address getAddress() { return address; }

    public int getAge() { return age; }

    /**
     * Overrides equals method
     * 
     * Returns whether some other Address is 'equal to' this one.
     * 
     * Assumption: two Person are equal if they have 
     * the same first name, last name, age, and address
     */
    @Override
    public boolean equals(Object obj) {
        // Compare object to itself
        if (this == obj) { return true; }
        
        // Check object is an instance of 'Person'
        if (!(obj instanceof Person)) { return false; }
        
        Person p = (Person) obj;
        
        return firstName.equalsIgnoreCase(p.firstName) 
               && lastName.equalsIgnoreCase(p.lastName)
               && address.equals(p.address)
               && age == p.age;
    }

    /**
     * Overrides hashCode method.
     * 
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), 
                            lastName.toLowerCase(), 
                            address, age);
    }

    /**
     * Overrides toString method.
     * 
     * Return a string representation of the object.
    */
    @Override
    public String toString() {
        return  firstName + ", " 
                + lastName + ", " 
                + address.toString() + ", " 
                + age;
    }
}
