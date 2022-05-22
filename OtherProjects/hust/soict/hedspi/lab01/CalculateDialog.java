package OtherProjects.hust.soict.hedspi.lab01;

import javax.swing.*;

public class CalculateDialog {
    public static void main(String[] args) {
        double x, y;

        try {
            x = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhập số thứ nhất"));
            y = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhập số thứ hai"));

            if (0 == y) {
                JOptionPane.showMessageDialog(null,
                        "Không thể chia cho 0", "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );
                System.exit(0);
            }

            JOptionPane.showMessageDialog(null, """
                            Tổng: %g
                            Hiệu: %g
                            Tích: %g
                            Thương: %g
                            """.formatted(x + y, x - y, x * y, x / y),
                    "Tính toán", JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null,
                    "Bạn đã nhập sai định dạng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        System.exit(0);
    }
}
