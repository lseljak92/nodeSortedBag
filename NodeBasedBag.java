/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodebasedarray;

/**
 *
 * @author abeer
 */
public class NodeBasedBag<T> implements BagInterface<T> {

    Node firstNode;
    int numberOfNodes = 0;

    public NodeBasedBag() {
        firstNode = null;
        numberOfNodes = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfNodes;
    }

    @Override
    public boolean isEmpty() {
        return numberOfNodes == 0;
    }

    @Override
    public boolean add(T newEntry) {
        // add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // make new node reference rest of chain
// (firstNode is null if chain is empty)
        firstNode = newNode; // new node is at beginning of chain
        numberOfNodes++;
        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.item;
            firstNode = firstNode.next; // remove first node from chain
            numberOfNodes--;
        } // end if
        return result;
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.item)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        } // end while
        return currentNode;
    } // end getReferenceTo

    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.item = firstNode.item; // replace located entry with entry
// in first node
            remove(); // remove first node
            result = true;
        } // end if
        return result;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfNodes) && (currentNode != null)) {
            if (anEntry.equals(currentNode.item)) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.next;
        } // end while
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.item)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        } // end while
        return found;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfNodes]; // unchecked cast
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfNodes) && (currentNode != null)) {
            result[index] = currentNode.item;
            index++;
            currentNode = currentNode.next;
        } // end while
        return result;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    class Node {

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        
        T item;
        Node next;

        Node(T item) {
            this(item, null);
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
