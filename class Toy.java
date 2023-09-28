// import java.io.*;
// import java.util.*;

class Toy {
    private String name;
    private String ageCategory;
    private int quantity;

    public Toy(String name, String ageCategory, int quantity) {
        this.name = name;
        this.ageCategory = ageCategory;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return name + " (" + ageCategory + ") - " + quantity;
    }
}
