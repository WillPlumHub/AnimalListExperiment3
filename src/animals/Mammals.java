//C0490418
//William Plummer
//Comp 132, section 1B
//2019-11-
/*This program extends the Animal class to add a variable representing the
color of the mammal's hair to the object and displays that variable to the
user along with the other variables from the animal class*/
package animals;

import exceptions.InvalidNameException;
import exceptions.InvalidWeightException;
/**
 * Mammal.Java
 * This program is used to create a new object of type mammal with the name,
 * weight, age, & hair color parameters given by the user.
 * @author willp
 */
public class Mammals extends Animals {
    /**
     * This String represents the color of the mammals hair
     */
    private String color;
/**
 * Gets the name, weight, age, and hair color from the Animal class and applies
 * it to a new reptile object.
 * @param name
 * @param weight
 * @param age
 * @param color
 * @throws InvalidNameException
 * @throws InvalidWeightException 
 */
    public Mammals(String name, double weight, int age, String color)
            throws InvalidNameException, InvalidWeightException {
        super(name, weight, age);
        /*use the name, weight, and age variables from the parent class*/
        this.color = color; //set new color variable
    }
/**
 * Sets the hair color variable to the new value input by the user.
 * @param newColor 
 */
    public void setHairColor(String newColor) {
        color = newColor; //set new color value
    }
/**
 * Returns String telling user what color the mammal's hair is.
 * @return hair color value
 */
    public String getHairColor() {
        return color; //return color string
    }
/**
 * Overrides the toString method in Animal class to add a string telling the
 * user the length of the reptile.
 * @return string telling the user the what color the mammal's hair is
 */
    @Override
    public String toString() {
        return super.toString() + "Hair Color: " + color;
/*return parent classes output but add on the hair color string from
        this program*/
    }

}
