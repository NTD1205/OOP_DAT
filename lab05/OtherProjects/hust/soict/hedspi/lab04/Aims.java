package OtherProjects.hust.soict.hedspi.lab04;

import AimsProject.hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Order anOrder = Order.createOrder();
        if (anOrder != null) {
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
            dvd1.setCategory("Animation");
            dvd1.setCost(19.95f);
            dvd1.setDirector("Roger Allers");
            dvd1.setLength(87);

            anOrder.addDigitalVideoDisc(dvd1);

            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
            dvd2.setCategory("Science Fiction");
            dvd2.setCost(24.95f);
            dvd2.setDirector("George Lucas");
            dvd2.setLength(124);

            anOrder.addDigitalVideoDisc(dvd2);

            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
            dvd3.setCategory("Animation");
            dvd3.setCost(18.99f);
            dvd3.setDirector("John Musker");
            dvd3.setLength(90);

            anOrder.addDigitalVideoDisc(dvd3);

            System.out.println("Total cost is: " + anOrder.totalCost());
            anOrder.removeDigitalVideoDisc(dvd3);
            System.out.println("Total cost is: " + anOrder.totalCost());
        }

        Order o1 = Order.createOrder();
        Order o2 = Order.createOrder();
        Order o3 = Order.createOrder();
        Order o4 = Order.createOrder();
        Order o5 = Order.createOrder();

        System.out.println(o5);
    }
}
