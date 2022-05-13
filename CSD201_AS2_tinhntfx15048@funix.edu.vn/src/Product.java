// tạo đối tượng Product
public class Product {
    String ID, title;
    int quantity;
    double price;

    // Constructor method
    public Product() {

    }

    public Product(String ID, String title, int quantity, double price) {
        this.ID = ID;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    // khởi tạo  getter setter
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                ID + " | " + title + " | " + quantity + " | " + price;

    }
}
