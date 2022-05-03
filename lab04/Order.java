package com.uni.lab04;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public Order() {
        qtyOrdered = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered > MAX_NUMBERS_ORDERED) {
            System.out.println("Đơn hàng đã đầy!");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] disc) {
        List<DigitalVideoDisc> discList = new ArrayList<>();
        if (qtyOrdered > MAX_NUMBERS_ORDERED) {
            System.out.println("Đơn hàng đã đầy!");
        } else {
            for (DigitalVideoDisc digitalVideoDisc : disc) {
                if (qtyOrdered > MAX_NUMBERS_ORDERED) {
                    discList.add(digitalVideoDisc);
                    continue;
                }
                itemsOrdered[qtyOrdered] = digitalVideoDisc;
                qtyOrdered++;
            }
        }
        if (discList.size() != 0) {
            System.out.println("Danh sách các mặt hàng không thể thêm.");
            discList.forEach(digitalVideoDisc -> System.out.println(digitalVideoDisc.getTitle()));
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                while (i < qtyOrdered)
                    itemsOrdered[i] = itemsOrdered[++i];
                qtyOrdered--;
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
