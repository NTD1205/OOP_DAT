package AimsProject.hust.soict.hedspi.aims;

import AimsProject.hust.soict.hedspi.aims.media.Book;
import AimsProject.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class Aims {
    static Order order;

    public static void main(String[] args) {
        while (true) showMenu();
    }

    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4: ");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose) {
            case 0:
                System.out.println("Exit");
                System.exit(0);
            case 1:
                order = Order.createOrder();
                System.out.println("Tạo đơn hàng mới thành công.");
                break;
            case 2:
                if (order == null) {
                    System.out.println("Bạn cần tạo đơn hàng trước.");
                } else {
                    System.out.println("""
                            Chọn loại item:
                            1.Book
                            2.CompactDisc(chưa có gì)
                            3.DigitalVideoDisc
                            """);
                    int case2 = sc.nextInt();
                    switch (case2) {
                        case 1 -> {
                            System.out.println("Nhập title Book: ");
                            sc = new Scanner(System.in);
                            order.addMedia(new Book(sc.nextLine()));
                        }
                        case 3 -> {
                            System.out.println("Nhập title DigitalVideoDisc: ");
                            sc = new Scanner(System.in);
                            order.addMedia(new DigitalVideoDisc(sc.nextLine()));
                        }
                        default -> {
                            System.out.println("lỗi");
                            System.exit(1);
                        }
                    }
                }
                break;
            case 3:
                if (order == null) {
                    System.out.println("Bạn cần tạo đơn hàng trước.");
                } else {
                    order.show();
                    System.out.println("Nhập id: ");
                    order.removeMedia(sc.nextInt());
                    System.out.println("Xóa thành công.");
                }
                break;
            case 4:
                if (order == null) {
                    System.out.println("Bạn cần tạo đơn hàng trước.");
                } else {
                    System.out.println("Danh sách sản phẩm trong đơn hàng");
                    order.show();
                }
                break;
            default:
                System.out.println("Lỗi lựa chọn.");

        }
    }
}
