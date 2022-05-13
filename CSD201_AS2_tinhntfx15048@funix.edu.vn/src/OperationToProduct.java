import java.io.*;

public class OperationToProduct {
    MyList t = new MyList();
    MyStack s = new MyStack();
    MyQueue m = new MyQueue();

    // đọc dữ liệu từ flie data và thêm vào linkedlist
    public void getAllItemsFromFile() {
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] c = line.split(" \\| ");
                int x = Integer.parseInt(c[2]);
                double y = Double.parseDouble(c[3]);
                Product a = new Product(c[0], c[1], x, y);
                addLast(a);
            }
            br.close();
            displayAll();
        } catch (IOException e) {

        }

    }

    // thêm đối tượng vào linkedlist
    public void addLast(Product a) {
        Node newNode = new Node(a);
        if (t.head == null) {
            // Nếu danh sách rong, thêm node mới và gán vào head và tail
            t.head = newNode;
            t.tail = newNode;
            return;
        }
        t.tail.setNext(newNode);
        t.tail = newNode;
    }

    // in ra màn hình
    public void displayAll() {
        Node current = t.head;
        System.out.println("ID" + " | " +
                "title" + " | " +
                "quantity" + " | " +
                "price");
        while (current != null) {
            System.out.println(current.getInfo());
            current = current.getNext();
        }
        System.out.println("===============================");

    }

    // ghi dữ liệu từ linkedlist vào file
    public void writeAllItemsToFile() {
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Node current = t.head;
            while (current != null) {
                bw.write(String.valueOf(current.getInfo()));
                bw.newLine();
                current = current.getNext();
            }

            bw.close();
        } catch (IOException ex) {
        }

    }

    // tìm kiếm theo id
    public void searchByCode(String x) {
        Node current = t.head;

        while (current != null) {
            if (current.getInfo().getID().equals(x)) {
                System.out.println(current.getInfo());
            }
            current = current.getNext();

        }

    }


    // sắp xếp lại theo id
    public void sortByCode() {

        for (Node p = t.head; p != null; p = p.getNext()) {
            for (Node q = p.getNext(); q != null; q = q.getNext()) {
                if (p.getInfo().getID().compareTo(q.getInfo().getID()) > 0) {
                    Product t = p.getInfo();
                    p.setInfo(q.getInfo());
                    q.setInfo(t);
                }
            }
        }

    }

    // in kết quả sau khi chuyển đổi từ hệ thạp phân sang hệ nhị phân
    public void convert() {
        int number = t.head.getInfo().getQuantity();
        System.out.print(number + " >>> ");
        convertToBinary(number);
        System.out.println();
    }

    // chuyển đổi từ hệ thạp phân sang hệ nhị phân
    public void convertToBinary(int number) {
        int remainder;
        if (number <= 1) {
            System.out.print(number);
            return;
        }
        remainder = number % 2;
        number = number / 2;
        convertToBinary(number);
        System.out.print(remainder);

    }

    // lấy độ dài
    public int length() {
        Node current = t.head;
        int i = 1;
        while (current != null) {
            current = current.getNext();
            i++;
        }
        return i;
    }

    // tìm kiếm theo id trả về vị trí của id cần tìm
    public int findIndex(String x) {
        Node current = t.head;
        int i = 0;
        while (current != null) {
            if (current.getInfo().getID().equals(x)) {
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }

    // xoá ở vị trí cuối
    public void delTail() {
        if (!t.isEmpty()) {
            Node p = t.head;
            while (p.getNext() != t.tail) {
                p = p.getNext();// tim node ngay truoc tail
            }
            p.setNext(null);//p chinh la node tail can xoa
            t.tail = p;
        }
    }

    // xoá ở đầu
    public void delHead() { // xoa node o dau List
        if (!t.isEmpty()) {
            t.head = t.head.getNext();
        }
    }

    // xoá ở vị trí bất kì
    public void deleteByCode(String x) {
        int z = findIndex(x);
        int n = length();
        if (z == -1) {
            System.out.println("không có phàn tử cần xoá");
        } else if (z == 0) {
            delHead();
            System.out.println("Deleted!!");
        } else if (z == n - 1) {
            delTail();
            System.out.println("Deleted!!");
        } else {
            Node current = t.head;
            while (!current.getNext().getInfo().getID().equals(x)) {
                current = current.getNext();
            }
            Node g = current.getNext();
            current.setNext(g.getNext());
            System.out.println("Deleted!!");

        }


    }

    // đọc fie và thêm vào stack
    public void readFileAndAddStack() {
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] c = line.split(" \\| ");
                int x = Integer.parseInt(c[2]);
                double y = Double.parseDouble(c[3]);
                Product a = new Product(c[0], c[1], x, y);
                s.push(a);
            }
            br.close();
            // in ra màn hình
            System.out.println("ID" + " | " +
                    "title" + " | " +
                    "quantity" + " | " +
                    "price");
            while (!s.isEmpty()) {
                System.out.print(s.pop());
                System.out.println();
            }
        } catch (IOException e) {

        }
    }

    // đọc fie và thêm vào Queue
    public void readFileAndAddQueue() {
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] c = line.split(" \\| ");
                int x = Integer.parseInt(c[2]);
                double y = Double.parseDouble(c[3]);
                Product a = new Product(c[0], c[1], x, y);
                m.enqueue(a);
            }
            br.close();
            // in ra màn hình
            System.out.println("ID" + " | " +
                    "title" + " | " +
                    "quantity" + " | " +
                    "price");
            while (!m.isEmpty()) {
                System.out.print(m.dequeue());
                System.out.println();
            }
        } catch (IOException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}