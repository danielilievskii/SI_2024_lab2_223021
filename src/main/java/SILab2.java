import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){ // Input
        if (allItems == null){ // A
            throw new RuntimeException("allItems list can't be null!"); // B
        }

        float sum = 0; //C

        for (int i = 0; i < allItems.size(); i++){ //D
            Item item = allItems.get(i); // E
            if (item.getName() == null || item.getName().length() == 0){ // F
                item.setName("unknown"); // G
            }
            if (item.getBarcode() != null){ // H
                String allowed = "0123456789"; // I
                char chars[] = item.getBarcode().toCharArray(); // J
                for (int j = 0; j < item.getBarcode().length(); j++){ // K
                    char c = item.getBarcode().charAt(j); // L
                    if (allowed.indexOf(c) == -1){ // M
                        throw new RuntimeException("Invalid character in item barcode!"); // N
                    }
                }
                if (item.getDiscount() > 0){ // O
                    sum += item.getPrice()*item.getDiscount(); // P
                }
                else { // Q
                    sum += item.getPrice();
                }
            }
            else { // R
                throw new RuntimeException("No barcode!");
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){ // S
                sum -= 30; // T
            }
        }
        if (sum <= payment){ // U
            return true; // V
        }
        else { // W
            return false;
        }
    } // exit
}
