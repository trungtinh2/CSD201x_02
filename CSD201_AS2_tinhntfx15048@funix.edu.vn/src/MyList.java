import java.io.*;
// Xây dựng danh sách liên kết

public class MyList {
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;

    }

}

