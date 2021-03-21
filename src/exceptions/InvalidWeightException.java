//C0490418
//William Plummer
//Comp 132, section 1B
//2020-03-11
/*The program sends an error message to the user in response to a thrown
exception where the user inputs a weight value of zero or less*/
package exceptions;
/**
 * InvalidWeightException.Java
 * This program is has any runtime errors thrown to it and responds by
 * outputting a message to the user.
 * @author willp
 */
public class InvalidWeightException extends Exception{
    /**
     * This method displays a message to the user if user inputs a weight of
     * zero or less.
     * @param msg
     */
    public InvalidWeightException (String msg){
//if InvalidWeightException is thrown to this program
    super(msg); /*then use the output command from the parent class to
    send message*/
    }
}