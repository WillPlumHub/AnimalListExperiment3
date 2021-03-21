//C0490418
//William Plummer
//Comp 132, section 1B
//2019-11-
/*This program extends the Animal class to add a variable representing the
length of the reptile to the object and displays that variable to the user
along with the other variables from the animal class*/
package animals;

import exceptions.InvalidNameException;
import exceptions.InvalidWeightException;
/**
 * Reptile.Java
 * This program is used to create a new object of type reptile with the name,
 * weight, age, & length parameters given by the user.
 * @author willp
 */
public class Reptiles extends Animals {
    /**
     * This integer represents the length of the reptile object
     */
    private int length;
    /**
     * Gets the name, weight, age, and length from the Animal class
     * and applies it to a new reptile object.
     * @param name
     * @param weight
     * @param age
     * @param length
     * @throws InvalidNameException
     * @throws InvalidWeightException 
     */
    public Reptiles(String name, double weight, int age, int length)
            throws InvalidNameException, InvalidWeightException {
        super(name, weight, age); /*take the name, weight, and age variables
        from the parent class*/
        this.length = length; //set new length value
    }
/**
 * Changes length variable to a new length value.
 * @param newLength 
 */
    public void setLength(int newLength) {
        length = newLength; //set new length value
    }
/**
 * Returns length value.
 * @return length value
 */
    public int getLength() {
        return length; //return length value
    }
/**
 * Overrides the toString method in Animal class to add a string telling the
 * user the length of the reptile.
 * @return string telling the user the value of the length variable
 */
    @Override
    public String toString() {
        return super.toString() + "Length: " + length;
/*return parent classes output but add on the length value from this program*/
    }
}
