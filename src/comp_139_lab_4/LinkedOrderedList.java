//C0490418
//William Plummer
//Comp 132, section 1B
//2019-02-12
/*This program creates references to the front and rear of the queue and*/
package comp_139_lab_4;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import animals.*;

/**
 *
 * @author C0490418
 * @param <T>
 */
public class LinkedOrderedList<T> extends LinkedList<T>
        implements OrderedListADT<T> {

  @Override
  public void add(T element) {
    SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(element);
    //create new node
    Comparable<T> compElement = (Comparable<T>) element;
 //create new comparable element and set it to the values of newly added node
    SinglyLinkedNode<T> temp = front;
    //create a reference to the front of the linked list
    SinglyLinkedNode<T> prev = null;
    //create a reference to the previous node in the linked list

    if (isEmpty()) { //if linked list is empty
      front = node; //set front to newly added node
      rear = node; //set rear to newly added node
    } else if (compElement.compareTo(front.getElement()) <= 0) {
      //if newly added node come before front element alphabetically 
      node.setNext(front); //make node point to front
      front = node; //set front to node
    } else if (compElement.compareTo(rear.getElement()) >= 0) {
      //
      rear.setNext(node); //make node point to front
      rear = node; //set front to node
    } else { //if node doesn't come before front or after rear alphabetically
      while (temp != null && compElement.compareTo(temp.getElement()) > 0) {
      /*then, as long as temp isn't null and newly node element doesn't come
          before temp alphabetically*/
        prev = temp; //set prev to temp
        temp = temp.getNext(); //set temp to next node in linked list
      }
      node.setNext(temp); //make newly added node point to temp
      prev.setNext(node); //make previous node point to newly added node
    }
    modCount++; //add one to modCount
  }
}
