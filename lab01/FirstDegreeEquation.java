package com.uni.lab01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        JFrame f = new JFrame("JOptionPane Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Ask");
        ActionListener actionListener = actionEvent -> {
            Component source = (Component) actionEvent.getSource();
            Object response = JOptionPane.showInputDialog(source,
                    "Chọn loại phương trình muốn giải!!", "JOptionPane Sample",
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"Phương trình bậc nhất 1 ẩn",
                            "Phương trình bậc nhất 2 ẩn",
                            "Phương trình bậc 2 một ẩn"},
                    "B");
            if ("Phương trình bậc nhất 1 ẩn".equals(response)) {
                method1();
            } else if ("Phương trình bậc nhất 2 ẩn".equals(response)) {
                method2();
            } else {
                method3();
            }

        };
        button.addActionListener(actionListener);
        f.add(button, BorderLayout.CENTER);
        f.setSize(500, 500);
        f.setVisible(true);
    }

    private static void method3() {
        String num1 = JOptionPane.showInputDialog(null,
                "Pls input a number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        String num2 = JOptionPane.showInputDialog(null,
                "Pls input b number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        String num3 = JOptionPane.showInputDialog(null,
                "Pls input c number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        double c = Double.parseDouble(num3);
        if (a == 0) {
            JOptionPane.showMessageDialog(null,
                    "Yêu cầu nhập a khác 0",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            double dental = b * b - 4 * a * c;
            if (dental == 0) {
                JOptionPane.showMessageDialog(null,
                        "Phương trình có nghiệm kép : x1 = x2 =  " + (-b / (2 * a)), "Kết quả",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {

                JOptionPane.showMessageDialog(null,
                        "Phương trình có 2 nghiệm phân biệt : x1 =  " + ((-b + Math.sqrt(dental)) / (2 * a))
                                + "\nx2 = " + ((-b - Math.sqrt(dental)) / (2 * a)), "Kết quả",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }

    }

    private static void method2() {
        String a11 = JOptionPane.showInputDialog(null,
                "Pls input a11 number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        String a12 = JOptionPane.showInputDialog(null,
                "Pls input a12 number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        String b1 = JOptionPane.showInputDialog(null,
                "Pls input b1 number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        String a21 = JOptionPane.showInputDialog(null,
                "Pls input a21 number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        String a22 = JOptionPane.showInputDialog(null,
                "Pls input a22 number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        String b2 = JOptionPane.showInputDialog(null,
                "Pls input b2 number: ",
                "Input  number",
                JOptionPane.INFORMATION_MESSAGE);
        double num11 = Double.parseDouble(a11);
        double num12 = Double.parseDouble(a12);
        double num1 = Double.parseDouble(b1);
        double num2 = Double.parseDouble(b2);
        double num21 = Double.parseDouble(a21);
        double num22 = Double.parseDouble(a22);
        double D = num11 * num22 - num21 * num12;
        if (D == 0) {
            JOptionPane.showMessageDialog(null,
                    "Phương trình có vô số nghiệm", "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else if (D != 0) {
            double D1 = num1 * num22 - num2 * num12;
            double D2 = num11 * num2 - num21 * num1;
            JOptionPane.showMessageDialog(null,
                    "Phương trình có 2 nghiệm: \nx1 =  " + D1 / D + "\nx2 = " + D2 / D, "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(null,
                    "Hệ thống không có giải pháp", "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private static void method1() {
        String a = JOptionPane.showInputDialog(null,
                "Pls input A number: ",
                "Input the A number",
                JOptionPane.INFORMATION_MESSAGE);
        String b = JOptionPane.showInputDialog(null,
                "Pls input B number: ",
                "Input the B number",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);
        if (num1 == 0) {
            JOptionPane.showMessageDialog(null,
                    "Phương trình vô nghiệm", "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {
            JOptionPane.showMessageDialog(null,
                    "Phương trình có nghiệm duy nhất = " + (-num2 / num1), "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
