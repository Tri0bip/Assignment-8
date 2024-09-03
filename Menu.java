package buoi8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {

    public static ArrayList<Integer> importData(ArrayList<Integer> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: ");
        int n = sc.nextInt();
        list.clear();
        
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "] = ");
            list.add(sc.nextInt());
        }
        return list;
    }

    public static void printData(ArrayList<Integer> list) {
        System.out.println("Cac phan tu trong mang:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + i + "] = " + list.get(i));
        }
    }

    public static void findMax2(ArrayList<Integer> list) {
        if (list.size() < 2) {
            System.out.println("Danh sach can co it nhat 2 phan tu.");
            return;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max2 = num;
            }
        }

        if (max2 == Integer.MIN_VALUE) {
            System.out.println("Khong co so lon thu 2.");
        } else {
            System.out.println("So lon nhat thu 2 trong mang la: " + max2);
        }
    }

    public static void deleteOddNumber(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num % 2 != 0) {
                iterator.remove();
            }
        }

        System.out.println("Xoa phan tu le trong mang.");
        printData(list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            System.out.println("1. Nhap so phan tu");
            System.out.println("2. Xuat so phan tu");
            System.out.println("3. So lon nhat thu 2 phan tu");
            System.out.println("4. Xoa so le");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    list = importData(list);
                    break;
                case 2:
                    printData(list);
                    break;
                case 3:
                    findMax2(list);
                    break;
                case 4:
                    deleteOddNumber(list);
                    break;
                case 5:
                    System.out.println("Goodbye.");
                    sc.close(); // Close the Scanner to release system resources
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }
}
