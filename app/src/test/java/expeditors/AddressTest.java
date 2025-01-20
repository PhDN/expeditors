/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package expeditors;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
 

public class AddressTest {

    private Address address;

    @BeforeEach 
    public void initilize() {
        address = new Address("1234 Expd Street", "Seattle", "WA");
    }

    @Test
    public void testConstructorNullInput() {
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> {
            Address other = new Address(null, null, "not null");
        });
        assertEquals("Must enter a valid address, cannot be null or empty.", 
            exception.getMessage());
    }

    @Test
    public void testConstructorEmptyInput() {
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> {
            Address other = new Address("", "Seattle", "WA");
        });
        assertEquals("Must enter a valid address, cannot be null or empty.", 
            exception.getMessage());
    }

    @Test
    public void testEqualsSameAddress() {
        Address other = new Address("1234 Expd Street", "Seattle", "WA");
        assertEquals(address, other);
    }

    @Test
    public void testEqualsSameAddresSTInsteadOfStreet() {
        Address other = new Address("1234 Expd St", "Seattle", "WA");
        assertEquals(address, other);
    }

    @Test
    public void testEqualsSameAddressIgnoreCase() {
        Address other = new Address("1234 Expd STREET", "SEATTLE", "WA");
        assertEquals(address, other);
    }

    @Test
    public void testNotEqualsDiffAddress() {
        Address other = new Address("1234 Expd AVE", "Bellevue", "CA");
        assertNotEquals(address, other);
    }

    @Test
    public void testNotEqualsSameCityStateDiffAddress() {
        Address other = new Address("1234 Expeditors Street", "Seattle", "WA");
        assertNotEquals(address, other);
    }

    @Test
    public void testNotEqualsSameAddressDiffCity() {
        Address other = new Address("1234 Expd Street", "Bellevue", "WA");
        assertNotEquals(address, other);
    }

    @Test
    public void testNotEqualsSameAddressDiffState() {
        Address other = new Address("1234 Expd Street", "Seattle", "CA");
        assertNotEquals(address, other);
    }

}