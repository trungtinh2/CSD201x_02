import java.util.EmptyStackException;

// Xây dựng Stack
public class MyStack {

    protected Node head;

    //Constructor method
    MyStack() {
        head = null;
    }


    // Hàm đẩy 1 phần tử vào stack
    void push(Product x) {
        head = new Node(x, head);
    }

    //    //kiểm tra MyStack có đang rỗng hay không
    boolean isEmpty() {
        return (head == null);
    }

    //lấy thông tin từ stack
    public Product pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Product x = head.info;
        head = head.next;
        return (x);
    }
}

