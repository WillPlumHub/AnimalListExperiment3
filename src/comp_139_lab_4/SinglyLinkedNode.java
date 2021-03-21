package comp_139_lab_4;

/**
 * A simple node for a singly-linked list
 *
 * @author J. Downarowicz
 */
public class SinglyLinkedNode<T> {

  /**
   * element stored at this node
   */
  private T element = null;
  /**
   * Link to the next node in list
   */
  private SinglyLinkedNode<T> next;

  /**
   * Creates an empty node
   */
  public SinglyLinkedNode() {
    next = null;
    element = null;
  }

  /**
   * Creates a node storing the specified element
   *
   * @param element element to be stored
   */
  public SinglyLinkedNode(T element) {
    this.element = element;
    next = null;
  }

  /**
   * Creates a node storing the specified element and the specified node
   *
   * @param element Item to be stored
   * @param next Reference to the next node in the list
   */
  public SinglyLinkedNode(T element, SinglyLinkedNode<T> next) {
    this.element = element;
    this.next = next;
  }

  /**
   * Returns the element stored at this node
   *
   * @return T element stored element at this node
   */
  public T getElement() {
    return element;
  }

  /**
   * Set the reference to the stored element
   *
   * @param element The item to be stored at this node
   */
  public void setElement(T elem) {
    element = elem;
  }

  /**
   * Returns the next node
   *
   * @return SinglyLinkedNode<T> reference to next node
   */
  public SinglyLinkedNode<T> getNext() {
    return next;
  }

  /**
   * Sets the reference to the next node in the list
   *
   * @param next The next node
   */
  public void setNext(SinglyLinkedNode<T> node) {
    next = node;
  }
}
