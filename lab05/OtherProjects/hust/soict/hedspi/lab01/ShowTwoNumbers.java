package OtherProjects.hust.soict.hedspi.lab01;

import javax.swing.*;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String num1, num2, notification = "Bạn đã nhập ";

        num1 = JOptionPane.showInputDialog(null,
                "Nhập số thứ nhất", "Nhập",
                JOptionPane.INFORMATION_MESSAGE
        );
        num2 = JOptionPane.showInputDialog(null,
                "Nhập số thứ hai", "Nhập",
                JOptionPane.INFORMATION_MESSAGE
        );

        notification += num1 + " và " + num2;

        JOptionPane.showMessageDialog(null,
                notification, "Hiển thị hai số",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.exit(0);
    }
}
