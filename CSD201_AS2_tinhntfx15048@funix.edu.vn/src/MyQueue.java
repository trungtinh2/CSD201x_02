
// Xây dựng lớp  MyQueue là 1 hàng đợi

class MyQueue {
    protected Node head, tail;

    //Constructor method
    public MyQueue() {
        head = tail = null;
    }

    //kiểm tra MyQueue có đang rỗng hay không
    public boolean isEmpty() {
        return (head == null);
    }

    //lấy thông tin từ hàng đợi
    public Product dequeue() throws Exception {
        if (isEmpty()) throw new Exception();
        Product x = head.info;
        head = head.next;
        if (head == null) tail = null;
        return (x);
    }

    // thêm vào hàng đợi
    void enqueue(Product x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }

}
