//C0490418
//William Plummer
//Comp 132, section 1B
//2020-03-11
/*This program represents an Animal object and sets the name, weight, and
age variables input by the user*/
package animals;

import exceptions.InvalidNameException;
import exceptions.InvalidWeightException;

/**
 * Animal.Java This program is used to create a new object of type animal with
 * the name, weight, & age parameters given by the user.
 *
 * @author willp
 */
public class Animals implements Comparable<Animals> {

    /**
     * This String represents the name of the animal object
     */
    private String name;
    /**
     * This double represents the weight of the animal object
     */
    private double weight;
    /**
     * This integer represents the age of the animal object
     */
    private int age;

    /**
     * Changes the name, weight, and age of the animal to the users input.
     *
     * @param name
     * @param weight
     * @param age
     * @throws InvalidNameException
     * @throws InvalidWeightException
     */
    public Animals(String name, double weight, int age)
            throws InvalidNameException, InvalidWeightException {
        if (name.length() < 2) {
//if the user inputs a name with less then two letters...
            throw new InvalidNameException("Name must be two characters or"
                    + " more");
//then throw an InvalidNameException to be handeled in another .java file
        }
        if (weight <= 0) { //if the user inputs a weight of 0 or less...
            throw new InvalidWeightException("Weight must be greater then 0");
//then throw an InvalidWeightException to be handeled in another .java file
        }
        this.name = name; //set new name string
        this.weight = weight; //set new weight double
        this.age = age; //set new age int
    }

    /**
     * Sets the name of the animal to a new name value.
     *
     * @param newName
     * @throws InvalidNameException
     */
    public void setName(String newName) throws InvalidNameException {
        if (name.length() < 2) {
            //if the user inputs a name with less then two letters...
            throw new InvalidNameException("Name must be two characters or"
                    + " more");
//then throw an InvalidNameException to be handeled in another .java file
        }
        name = newName; //set new name int
    }

    /**
     * Sets the weight of the animal to a new weight value.
     *
     * @param newWeight
     * @throws InvalidWeightException
     */
    public void setWeight(double newWeight) throws InvalidWeightException {
        weight = newWeight; //set new weight double
    }

    /**
     * Sets the age of the animal to a new age value.
     *
     * @param newAge
     */
    public void setAge(int newAge) {
        age = newAge; //set new age int
    }

    /**
     * Gets the name of the animal.
     *
     * @return the name of the animal
     */
    public String getName() {
        return name; //return name string
    }

    /**
     * Gets the weight of the animal.
     *
     * @return the weight of the animal
     */
    public double getWeight() {
        return weight; //return weight double
    }

    /**
     * Gets the age of the animal.
     *
     * @return the age of the animal
     */
    public int getAge() {
        return age; //return age int
    }

    /**
     * Tells the user the name, weight, and age of the animal object.
     *
     * @return a string telling the user the name, weight, and age of the
     * animal
     */
    public String toString() {
        return "Name: " + name + ", Weight: " + weight + ", Age: " + age
                + ", "; //output the name, weight, and age to the user
    }

    /**
     * Returns an integer that determines which name String is first
     * alphabetically
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Animals o) {
        return name.compareTo(o.name);
    }
}
