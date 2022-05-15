package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMIT_ORDERS = 5;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    private static int nbOrders = 0;
    private MyDate dateOrdered;

    public Order() {
        dateOrdered = new MyDate();
    }

    public static Order createOrder() {
        if (nbOrders >= MAX_LIMIT_ORDERS) {
            System.out.println("Bạn đã đạt đến số lượng đơn đặt hàng tối đa.");
            return null;
        } else {
            nbOrders++;
            return new Order();
        }
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

    public DigitalVideoDisc getALuckyItem() {
        return itemsOrdered[(int) (Math.random() * qtyOrdered)];
    }
}
