 import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm {
    List<Float> a = new ArrayList<>();

    // hiển thị giá trị của mảng
    void display(float[] array) {
        for (float item : array) {
            System.out.print("  " + item);
        }
        System.out.println();
    }

    // tiến hành dổi vị trí
    void swap(int i, int k, float[] array) {
        Float x;
        x = array[i];
        array[i] = array[k];
        array[k] = x;

    }

    //sắp xếp theo thứ tự giảm dần
    public void sort() {
        System.out.println("danh sách sau khi sắp xếp");
        //collections.sort để sắp xếp lại các đối tượng trong mảng
        Collections.sort(a, (a, b) -> (int) (b - a));
        for (float item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public void writeFile(String fileName, float[] arr) {
// ghi file  bởi vì có 2 cách ghi file khác nhau nên cần chia làm 2 trường hợp
        try {
            if (fileName.equals("input.txt")) {
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);

                for (float s : arr) {
                    bw.write(String.valueOf(s) + " ");
                }
                bw.close();
            } else {
                FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter bw = new BufferedWriter(fw);

                for (float s : arr) {
                    bw.write(String.valueOf(s) + " ");
                }
                bw.newLine();
                bw.close();
            }
        } catch (IOException e) {
        }

    }

    public void readFile(String fileName) {

// dọc file
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = "";

            while ((line = br.readLine()) != null) {
                String[] c = line.split(" ");
                for (int i = 0; i < c.length; i++) {
                    a.add((Float.parseFloat(c[i])));
                }
                System.out.println("Array a:" + a.toString());

            }
            br.close();

        } catch (IOException e) {

        }

    }

    public void bubbleSort() {
        float[] b = new float[a.size()];
        // sao chép mảng
        for (int i = 0; i < a.size(); i++) {
            b[i] = a.get(i);
        }
        boolean check;
        // lấy thời gian ban đầu
        Long timeIn = System.currentTimeMillis();
        do {
            check = false;
            for (int j = 0; j < b.length - 1; j++) {
                if (b[j] > b[j + 1]) {
                    swap(j, j + 1, b);
                    check = true;
                }

                writeFile("output1.txt", b);
            }
            display(b);
        }
        while (check);
        // lấy thời gian sau sắp xếp và tính toán
        Long timeOut = System.currentTimeMillis();
        long timeSort = timeOut - timeIn;
        System.out.println("thời gian sắp xếp:" + timeSort + "ms");
    }

    public void selectionSort() {

        float[] b = new float[a.size()];
        // sao chép mảng
        for (int n = 0; n < a.size(); n++) {
            b[n] = a.get(n);
        }
        // lấy thời gian ban đầu
        Long timeIn = System.currentTimeMillis();
        // sắp xếp theo thuật toán Selection sort
        for (int i = 0; i < b.length - 1; i++) {
            float minvalue = b[i];
            int minIndex = i;
            for (int j = i + 1; j < b.length; j++) {

                if (minvalue > b[j]) {
                    minvalue = b[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex, b);
            }

            display(b);
            writeFile("output2.txt", b);
        }
        // lấy thời gian sau sắp xếp và tính toán
        Long timeOut = System.currentTimeMillis();
        long timeSort = timeOut - timeIn;
        System.out.println("thời gian sắp xếp:" + timeSort + "ms");


    }

    public float[] insertionSort() {
        float[] b = new float[a.size()];
        // sao chép mảng
        for (int n = 0; n < a.size(); n++) {
            b[n] = a.get(n);
        }
        int i, j;
        float x;
        // lấy thời gian ban đầu
        Long timeIn = System.currentTimeMillis();
        // thuật toán  sắp xếp insertionSort
        for (i = 1; i < a.size(); i++) {
            x = b[i];
            j = i;
            while (j > 0 && x < b[j - 1]) {
                b[j] = b[j - 1];
                j--;

            }
            b[j] = x;
            display(b);
            writeFile("output3.txt", b);
        }
        // lấy thời gian sau sắp xếp và tính toán
        Long timeOut = System.currentTimeMillis();
        long timeSort = timeOut - timeIn;
        System.out.println("thời gian sắp xếp:" + timeSort + "ms");
        return b;
    }

    public void search(float value) {
        List<Integer> index = new ArrayList<>();
        System.out.print("chỉ số là:");
        // thuật toán tìm kiếm tuyến tính
        for (int i = 0; i < a.size(); i++) {
            if (value < a.get(i)) {

                System.out.print(" " + i + " ");
                index.add(i);
            } else {
                System.out.print(" " + -1 + " ");
            }
        }
        System.out.println();
        float[] c = new float[index.size()];
        // sao chép mảng
        for (int n = 0; n < c.length; n++) {
            c[n] = index.get(n);
        }
        writeFile("output4.txt", c);
    }

    public int binarySearch(float value) {

        float[] b = new float[a.size()];
        // sao chép mảng a
        for (int n = 0; n < a.size(); n++) {
            b[n] = a.get(n);
        }
        //sắp xếp mảng
        for (int i = 0; i < b.length - 1; i++) {
            float minvalue = b[i];
            int minIndex = i;
            for (int j = i + 1; j < b.length; j++) {

                if (minvalue > b[j]) {
                    minvalue = b[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex, b);
            }
        }


        int left = 0;
        int right = b.length - 1;
        // thuật toán tìm kiếm nhị phân
        while (left <= right) {
            int mid = (left + right) / 2;
            if (b[mid] == value) {
                float[] c = {mid};
                writeFile("output5.txt", c);
                return mid;
            } else if (b[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}