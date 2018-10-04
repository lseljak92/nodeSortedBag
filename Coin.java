/**
 * Homework 02
 * BagInterface.java
 * Devon Dy-Liacco, Christian Cortez, Maria Seljak
 */
package nodebasedarray;

public class Coin implements Comparable<Coin> {

    private int coinValue;
    private static int DEFAULT_VALUE = 0;
    
    public Coin() {
        this(DEFAULT_VALUE);
    }
    public Coin(int value) {
        coinValue = value;
    }

    public void setValue(int value) {
        coinValue = value;
    }
    public int getValue() {
        return coinValue;
    }

    public boolean equals(Coin c) {
        return coinValue==c.getValue();
    }

    public int compareTo(Coin c) {
        return coinValue-c.getValue();
    }

    public String toString() {
        return "coin: " + coinValue;
    }

}
