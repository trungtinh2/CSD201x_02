// Lớp Node chứa thông tin của sản phẩm và biến next để trỏ tới nút tiếp theo

public class Node {

    Product info;
    Node next;

    public Node(Product x, Node p) {
        info = x;
        next = p;
    }

    //Constructor method
    public Node(Product x) {
        this(x, null);
    }

    // khởi tạo  getter setter
    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}