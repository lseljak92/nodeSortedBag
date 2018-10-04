/**
 * Homework 02
 * BagInterface.java
 * Devon Dy-Liacco, Christian Cortez, Maria Seljak
 */
package nodebasedarray;

import java.util.Arrays;
import java.util.Scanner;


public class NodeBasedBagTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NodeBasedBag<Coin> bag = new NodeBasedBag<>();
        int choice = -1;

        do {
            System.out.println("[1] To add a new item to the bag");
            System.out.println("[2] To remove an item from the bag");
            System.out.println("[3] To remove a specific item from the bag");
            System.out.println("[4] To clear the bag");
            System.out.println("[5] To get a frequency of a given item in the bag");
            System.out.println("[6] To check if an item exist in the bag");
            System.out.println("[7] To print bag content");
            System.out.println("[8] To Exit");
            System.out.println("Enter your choice:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter item:");
                    int item = in.nextInt();
                    if ((item == 10 || item == 25 || item == 75 || item == 100) && bag.add(new Coin(item))) {
                        System.out.println("Item " + item + " is added successfully to the bag");
                    }
                    break;
                case 2:
                    if (bag.isEmpty()) {
                        System.out.println("Bag is empty!");
                    } else {
                        System.out.println("Item " + bag.remove() + " is removed successfully");
                    }
                    break;
                case 3:
                    System.out.println("Enter the item you want to remove from the bag:");
                    item = in.nextInt();
                    if (bag.contains(new Coin(item))) {
                        bag.remove(new Coin(item));
                        System.out.println("Item " + item + " is removed from the bag");
                    } else {
                        System.out.println("The item " + item + " doesnt exist in the bag");
                    }
                    break;
                case 4:
                    bag.clear();
                    System.out.println("Bag is empty now!");
                    break;
                case 5:
                    System.out.println("Enter the item you are looking for:");
                    item = in.nextInt();
                    System.out.println("The item " + item + " is found " + bag.getFrequencyOf(new Coin(item)) + " times");
                    break;
                case 6:
                    System.out.println("Enter the item you are looking for:");
                    item = in.nextInt();
                    if (bag.contains(new Coin(item))) {
                        System.out.println("The item " + item + " is in the bag");
                    } else {
                        System.out.println("The item " + item + " is NOT in the bag");
                    }
                    break;
                case 7:
                    if (bag.isEmpty()) {
                        System.out.println("Bag is empty!");
                    } else {
                        System.out.println("Bag content:");
                        System.out.println(Arrays.toString(bag.toArray()));
                    }
                    break;
                case 8:
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter a number in the range [1-8]");
                    break;
            }
        } while (choice != 8);
    }

    }
    

