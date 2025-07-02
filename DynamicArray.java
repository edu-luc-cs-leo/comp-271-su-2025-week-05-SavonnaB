/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */
    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[2 * this.underlying.length];
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    } // method add

    /**
     * method to find the position of an element in the underlying array
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     */
    public int indexOf(String string) {
        for (int i = 0; i < this.occupancy; i++) { //SB: uses loop to return position of given string in array
        if (this.underlying[i].equals(string)) {
            return i;
        }
    }
    return -1; //SB: iteration leaves the block if item is not present and outputs -1
    } // method indexOf

    /** Method to tell if a string exists in the underlying array */
    public boolean contains(String string) {

        return indexOf(string) != -1; //SB: If string does not exist this logic should return false..I may have mixed this up with returning true.
    }

    /** Method to count how many times a string appears in the underlying array*/
    public int countOf(String string) {
        int count = 0;
    for (int i = 0; i < this.occupancy; i++) {
        if (this.underlying[i].equals(string)) { //SB: if the underlying contents equals the string, program keeps counting until conditions are no longer met.
            count++;
        }
    }
    return count; //SB: returns number of time string appeared, string should return 0 if not found
    }

    /** method to remove items from the underlying array */
    public String remove(int index) {
        if (index < 0 || index >= this.occupancy){  //SB: If an index is less than 0 or index is greater than or equal to current occupancy, system should return full/null.
        return null;
    }

    String removed = this.underlying[index];

    for (int i = index; i < this.occupancy - 1; i++) { //SB: If items are supposed to shift to left I maybe should have used i-- but will compare to class notes
        this.underlying[i] = this.underlying[i + 1];// Removes contents and resets available position? (unsure)
    }

    this.underlying[this.occupancy - 1] = null;
    this.occupancy--;

    return removed; //SB: I could do a system.out.println with "item beta has been removed from list" but trying to keep code concise
    }

    /** overload remove */ 
    public String remove(String string) {
        int index = indexOf(string);
        if (index == -1) {
            return null;
         }//SB: returns empty and returns removed index. Maybe redundant I could've just left it null possibly.
        return remove(index);
    }

    /** Complete this method */
    public String toString() {
    if (this.occupancy == 0) return "[Add New Guest]"; //SB: being honest I had to look this one up, I didn't really know what to put here

    StringBuilder sb = new StringBuilder("New Guest"); //SB: keeping with hotel theme looked Stringbuilder to modify strings for loop iterations.
    for (int i = 0; i < this.occupancy; i++) {
        sb.append(this.underlying[i]);
        if (i < this.occupancy - 1) {
            sb.append(", ");
        }
    }
    sb.append("Welcome!"); //SB: attaches to string output. Need to practice with this logic more.
    return sb.toString();
    }
}
 // class DynamicArray