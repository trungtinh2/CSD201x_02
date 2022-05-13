
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Algorithm t = new Algorithm();
//vòng lặp do while để tạo menu  hạn chế số lần lựa chọn
        do {
            System.out.println("+------------------------Menu----------------------+");
            System.out.println("|      1.Input                                     |");
            System.out.println("|      2.Output                                    |");
            System.out.println("|      3.Bubble sort                               |");
            System.out.println("|      4.Selection sort                            |");
            System.out.println("|      5.Insertion sort                            |");
            System.out.println("|      6.Search > value                            |");
            System.out.println("|      7.Search = value                            |");
            System.out.println("|      8.sắp xếp theo thứ tự giảm dần lên mảng a   |");
            System.out.println("|      0.Exit                                      |");
            System.out.println("+-------------------------------------------------.+");
            System.out.print("Choice:");
            int luaChon = input.nextInt();

            if (luaChon == 0) {
                System.out.print("Thanks!!!");
                break;
            }
            // switch case để tạo ra các lựa chọn cho menu
            switch (luaChon) {
                case 1: // nhập dử liệu
                    System.out.println("chọn cách tạo dữ liệu(1: nhập tay - 2: nhập random )");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1: // nhập bằng tay
                            System.out.println("Input number of elements:");
                            int number = input.nextInt();
                            System.out.println("Input elements:");

                            float[] arr = new float[number];
                            for (int i = 0; i < number; i++) {
                                arr[i] = input.nextInt();
                            }
                            t.writeFile("input.txt", arr);
                            break;

                        case 2:// nhập ngẫu nhiên
                            System.out.println("Input number of elements:");
                            int num = input.nextInt();
                            float[] array = new float[num];
                            for (int i = 0; i < num; i++) {
                                int randomNumber = (int) ((Math.random() * num) + 1);
                                array[i] = randomNumber;
                            }
                            t.writeFile("input.txt", array);
                            break;
                    }
                    break;
                case 2: // đọc dữ liệu từ file
                    System.out.println("Read from file");
                    t.readFile("input.txt");
                    break;
                case 3: // sắp xếp theo thuật toán Bubble sort
                    System.out.println("Bubble sort");
                    t.bubbleSort();
                    break;
                case 4: // sắp xếp theo thuật toán Selection sort
                    System.out.println("Selection sort");
                    t.selectionSort();
                    break;
                case 5: // sắp xếp theo thuật toán Insertion sort
                    System.out.println("Insertion sort");
                    t.insertionSort();
                    break;
                case 6: // Tìm kiếm theo thuật toán Tìm Kiếm Tuyến Tính
                    System.out.println("Linear Search");
                    System.out.print("Input value:");
                    float val = input.nextInt();
                    t.search(val);
                    break;
                case 7: //Tìm kiếm theo thuật toán nhị phân
                    System.out.println("Binary Search");
                    System.out.print("Input value:");
                    float value = input.nextInt();
                    System.out.print("Index fist Element: " + (t.binarySearch(value)));
                    System.out.println();
                    break;
                case 8:
                    t.sort();
                    break;
            }
        } while (true);
    }
}
