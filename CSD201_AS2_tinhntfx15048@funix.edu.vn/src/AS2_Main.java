import java.io.File;
import java.util.Scanner;

public class AS2_Main {

    public static void main(String[] args) {
        //khởi tạo OperationToProduct và MyList
        OperationToProduct o = new OperationToProduct();
        MyList t = new MyList();
        Scanner input = new Scanner(System.in);
        // vòng lặp do while tạo menu
        do {
            System.out.println("Choose one of this options:");
            System.out.println("Product list:");
            System.out.println("1. Load data from file and display");
            System.out.println("2. Input & add to the end.");
            System.out.println("3. Display data");
            System.out.println("4. Save product list to file.");
            System.out.println("5. Search by ID");
            System.out.println("6. Delete by ID");
            System.out.println("7. Sort by ID.");
            System.out.println("8. Convert to Binary");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display.");
            System.out.println("0. Exit");
            System.out.print(" choice = ");
            int luaChon = Integer.parseInt(input.nextLine());

            if (luaChon == 0) {
                System.out.print("Thanks!!!");
                break;
            }
            // switch case để tạo ra các lựa chọn cho menu
            switch (luaChon) {
                case 1:
                    o.getAllItemsFromFile();
                    System.out.println("Successfully!");

                    break;
                case 2:
                    System.out.print("Input new ID:");
                    String id = input.nextLine();
                    System.out.print("Input Product's Name:");
                    String name = input.nextLine();
                    System.out.println("Input Product's quantity:");
                    int quantity = Integer.parseInt(input.nextLine());
                    System.out.println("Input Product's price:");
                    double price = Double.parseDouble(input.nextLine());
                    Product a = new Product(id, name, quantity, price);
                    o.addLast(a);
                    break;
                case 3:
                    o.displayAll();
                    break;
                case 4:
                    o.writeAllItemsToFile();
                    System.out.println("Successfully!");

                    break;
                case 5:
                    System.out.println("Input the IDto search");
                    String x = input.nextLine();
                    int n = o.findIndex(x);
                    if (n == -1) {
                        System.out.println("không có phần tử cần tìm");
                    } else {
                        o.searchByCode(x);
                    }
                    break;
                case 6:
                    System.out.println("Input the bcode to delete:");
                    String y = input.nextLine();
                    o.deleteByCode(y);
                    break;
                case 7:
                    o.sortByCode();
                    System.out.println("Successfully!");
                    break;
                case 8:
                    o.convert();
                    break;
                case 9:
                    o.readFileAndAddStack();
                    break;
                case 10:
                    o.readFileAndAddQueue();
                    break;
            }
        } while (true);
    }
}
