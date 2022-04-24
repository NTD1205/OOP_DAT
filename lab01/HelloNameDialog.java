package com.uni.lab01;

import javax.swing.*;

public class HelloNameDialog {
    public static void main(String[] args) {
        String result;

        result = JOptionPane.showInputDialog("Nhập tên");
        JOptionPane.showMessageDialog(null, "Chào " + result);
        System.exit(0);
    }
}
