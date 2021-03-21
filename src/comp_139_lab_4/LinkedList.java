//C0490418
//William Plummer
//Comp 132, section 1B
//2019-02-12
/*This program creates references to the front and rear of the linked list as
well as a count of every modifacation made to it. This program also provides
methods for removing an element from the list, removing the first element
from the list, removing the last element from the list, returning the first
element from the list, returning the last element form the list, checking if
the list contains an element specified by the user, checking if the list is
empty, returning an integer representing the size of the list, displaying
every element form the list in the form of a string, and creating an iterator.
 */
package comp_139_lab_4;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.*;

/**
 * this program supplies methods used to alter linked list and get
 * information from it
 *
 * @author C0490418
 */
public class LinkedList<T> implements ListADT<T>, Iterable<T> {

    protected SinglyLinkedNode<T> front;
//create a reference to the front of the list
    protected SinglyLinkedNode<T> rear;
//create a reference to the rear of the list
    protected int modCount = 0; //number of modifacations made to linked list

    public LinkedList() {
        front = null; //set front to null by default
        rear = null; //set rear to null by default
    }

    /**
     * finds the first element in linked list, copies it to temp, and changes
     * pointer of first node to null to remove it from linked list
     *
     * @return copy of fist element in linked list
     * @throws EmptyCollectionException
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) { //if linked list is empty
            throw new EmptyCollectionException("List is empty");
            //
        }
        SinglyLinkedNode<T> temp = front; //create reference to front of list
        if (front != rear) { //if list has more then one node in it
            front = front.getNext(); //move front to point to next node
            return temp.getElement(); //return element front now points to
        } else { //if linked list has only one node in it
            front = null; //set front to null
            rear = null; //set rear to null
        }
        modCount++; //add one to modCount
        return temp.getElement(); //return new first element
    }

    /**
     * finds the last element in linked list, copies it to temp, and changes
     * pointer of second to last node to null to remove last node from
     * linked list
     *
     * @return copy of last element in linked list
     * @throws EmptyCollectionException
     * @throws NullPointerException
     */
    @Override
    public T removeLast() throws EmptyCollectionException,
            NullPointerException {
        if (isEmpty()) { //is linked list is empty
            throw new EmptyCollectionException("List is empty");
            //
        }
        SinglyLinkedNode<T> temp = front; //create reference to front of list
        if (rear != front) { //if list has more then one node in it
            while (temp.getNext() != rear) {
            //while temp isn't at the end of the list
                temp = temp.getNext(); //move temp to next node
            }
            rear = temp; //set temp to last node in linked list
            temp.setNext(null); //set next node to null
            return temp.getElement(); //return new last node
        } else { //if there is only one element in linked list
            front = null; //set front to null
            rear = null; //set rear to null
        }
        modCount++; //add one to modCount
        return temp.getElement(); //return new last element
    }

    /**
     * checks linked list for element of users choice, copies element to
     * variable "removal", and changes the pointers of the surrounding
     * objects to remove node
     *
     * @param element
     * @return copy of the element(s) of the node that was removed
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException
     */
    @Override
    public T remove(T element) throws EmptyCollectionException,
            ElementNotFoundException {
        if (isEmpty()) { //if linked list is empty
            throw new EmptyCollectionException("List is empty");
            //
        }
        SinglyLinkedNode<T> temp = front; //create reference to front of list
        SinglyLinkedNode<T> prev = null; //create reference to previous node
        T removal = null;//create new variable to contain copy of removed node
        if (element.equals(temp)) { //if element to be removed has been found
            removal = temp.getElement(); //copy it to removal
            prev.setNext(temp.getNext());
            //and make previous node point to node after node to be removed
            return removal; //return copy of removed element
        } else { //otherwise
            prev = temp; //set prev to temp
            temp = temp.getNext(); //move temp to next node in linked list
        }
        modCount++; //add one to modCount
        return removal; //return copy of removed element
    }

    /**
     * returns the element of the first node in the linked list
     *
     * @return the first element in the linked list
     * @throws EmptyCollectionException
     */
    public T first() throws EmptyCollectionException {
        if (isEmpty()) { //if linked list is empty
            throw new EmptyCollectionException("List is empty");
            //
        }
       return front.getElement();//return the first element in the linked list
    }

    /**
     * returns the element of the last node in the linked list
     *
     * @return element of last node in linked list
     * @throws EmptyCollectionException
     */
    public T last() throws EmptyCollectionException {
        if (isEmpty()) { //if linked list is empty
            throw new EmptyCollectionException("List is empty");
            //
        }
        return rear.getElement(); //return the last element in the linked list
    }

    /**
     * checks the linked list for an object of the users choice and returns a
     * boolean to show if object was found in linked list
     *
     * @param target
     * @return boolean representing if the linked list contains the targeted
     * object
     * @throws EmptyCollectionException
     */
    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if (isEmpty()) { //if linked list is empty
            throw new EmptyCollectionException("List is empty");
            //
        }
        SinglyLinkedNode<T> temp = front;
        //create reference to front of linked list
        while (!target.equals(temp) && temp != null) { /*while target hasn't
            found a match and hasn't reached the end of the linked list*/
            temp = temp.getNext();
            //move temp to point to the next node in the linked list
        }
        if (temp == null){ /*if temp has reached the end of linked list
            without finding any matches for the target*/
            return false; //return false
        }
        return true; //return true
    }

    /**
     * checks if the linked list is empty or not and returns a boolean as
     * true if linked list is empty or false if it isn't
     *
     * @return boolean representing if the linked list is empty or not
     */
    @Override
    public boolean isEmpty() {
        if (front == null) { //if the front of the linked list isn't empty
            return true; //return true
        } else { //if the front of the linked list is empty
            return false; //return false
        }
    }

    /**
     * sets temp to front and move it through list until it reaches the end
     * all while counting the number of nodes it passes through and returning
     * that number as the size of the linked list
     *
     * @return integer representing the size of the linked list
     */
    @Override
    public int size() {
        int size = 0;//create new integer representing the size of linked list
        SinglyLinkedNode<T> temp = front;
        //create new reference to front of linked list
        while (temp != null) { //while the front of linked list isn't null
            size++; //count one new element in the linked list
            temp = temp.getNext(); //move temp to the next element in the list
        }
        return size; //return size of linked list
    }

    /**
     * creates new iterator object
     *
     * @return iterator object
     */
    @Override
    public Iterator<T> iterator() {
        LinkedIterator iterator = new LinkedIterator();
        //create new iiterator object
        return iterator; //return iterator object
    }

    /**
     * Calls method toString with front reference as parameter
     *
     * @return String made up of all elements from linked list
     */
    public String Display() {
        return toString(front);
        //return the result of toString class and send front as parameter
    }

    /**
     * Returns all elements in queue as String s
     *
     * @param element
     * @return String made up of all elements from linked list
     */
    private String toString(SinglyLinkedNode element) {
        String s = ""; //create new empty string called s
        if (element != null) { //if "element" sent to toString isn;t null
            s = s + element.getElement().toString() + "\n"
                    + toString(element.getNext());
            /*copy element to string s and call toString again to copy every
            element after "element"*/
        }
        return s; //return string of elements
    }

    /**
     * this class provides methods for the iterator object that can be made
     * with the Iterator method in the above class. The methods provided
     * include: next, which returns the element proceeding the current
     * element; and hasNext, which checks if the current element, specified
     * by the user, is pointing to any nodes
     */
    private class LinkedIterator implements Iterator<T> {

        SinglyLinkedNode<T> current;
        //create new SinglyLinkedNode called current
        int iteratorModCount;
        /*create new integer counting the number of times iterator has
        been modified*/

        /**
         * sets current reference to the front of the linked list and sets
         * iterator's mod count to the LinkedList classes mod count
         */
        public LinkedIterator() {
            current = front;
            //set current reference to front of linked list
            iteratorModCount = modCount;
            //set iterator's mod count to the LinkedList classes mod count
        }

        /**
         * checks if the current node is pointing to any other nodes
         *
         * @return true if current element is pointing to another node and
         * false if it isn't
         * @throws ConcurrentModificationException
         */
        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != modCount) {
            //if iterators mod count is different from main classes mod count
                throw new ConcurrentModificationException();
                //then throw a ConcurrentModificationException
            }
            return current != null;
            //return whether or not current is pointing to another node
        }

        /**
         * checks if current node is pointing to another node and returns the
         * elements of the node current is pointing to
         *
         * @return element proceeding current node
         * @throws ConcurrentModificationException
         * @throws ElementNotFoundException
         */
        @Override
        public T next() throws ConcurrentModificationException,
                ElementNotFoundException {
            T element = null;
            //create new variable of type T and set it to null
            if (iteratorModCount != modCount) {
            //if iterators mod count is different from main classes mod count
                throw new ConcurrentModificationException();
                //then throw a ConcurrentModificationException
            }
            if (hasNext() == true) { //if current is pointing to a node
                element = current.getElement();
                //copy the element of the next node to element
                current = current.getNext();
                //set current node to the node it was pointing to
            } else { //otherwise
                throw new ElementNotFoundException("");
                ////throw a ElementNotFoundException
            }
            return element; //return element
        }
    }
}
