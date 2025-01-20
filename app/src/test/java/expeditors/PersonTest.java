/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package expeditors;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
 
/**
 *
 * @author phdn
 */
public class PersonTest {

    private Address address;
    private Person person;

    @BeforeEach
    public void initilize() {
        address = new Address("1234 Expd Street", "Seattle", "WA");
        person = new Person("First", "Last", address, 100);
    }

    @Test
    public void testConstructorNullNameInput() {
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> {
            Person other = new Person(null, null, address, 100);
        });
        assertEquals("Must provide valid first name, last name, and a non-negative age", 
            exception.getMessage());
    }

    @Test
    public void testConstructorNullAddressInput() {
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> {
            Person other = new Person("First", "Last", null, 10);
        });
        assertEquals("Must provide valid first name, last name, and a non-negative age", 
            exception.getMessage());
    }

    @Test
    public void testConstructorEmptyNameInput() {
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> {
            Person other = new Person("", "Last", null, 10);
        });
        assertEquals("Must provide valid first name, last name, and a non-negative age", 
            exception.getMessage());
    }

    @Test
    public void testConstructorAgeLessThan0() {
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> {
            Person other = new Person("First", "Last", null, -1);
        });
        assertEquals("Must provide valid first name, last name, and a non-negative age", 
            exception.getMessage());
    }

    @Test
    public void testEqualsSamePerson() {
        Person other = new Person("First", "Last", address, 100);
        assertEquals(person, other);
    }

    @Test
    public void testEqualsSamePersonIgnoreCase() {
        Person other = new Person("fIRST", "lAST", address, 100);
        assertEquals(person, other);
    }

    @Test
    public void testNotEqualsDiffPerson() {
        Person other = new Person("Name", "Name", address, 100);
        assertNotEquals(person, other);
    }

    @Test
    public void testNotEqualsSamePersonDiffAddress() {
        Address otherAddress = new Address("999 9th AVE", "Seattle", "WA");
        Person other = new Person("First", "Last", otherAddress, 100);
        assertNotEquals(person, other);
    }

    @Test
    public void testNotEqualsSameNameAddressDiffAge() {
        Person other = new Person("First", "Last", address, 99);
        assertNotEquals(person, other);
    }

}