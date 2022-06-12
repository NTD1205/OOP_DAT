package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args){
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Jungle dvd's title is: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd's title is: " + cinderellaDVD.getTitle());

        DVDswap(jungleDVD, cinderellaDVD);

        //changeTitle(jungleDVD,"que");

        System.out.println("Jungle dvd's title is: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd's title is: " + cinderellaDVD.getTitle());

    }

    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
//      dvd.title = title;
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void DVDswap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        DigitalVideoDisc tmp = new DigitalVideoDisc("");
        dvd1.cloneTo(tmp);
        dvd2.cloneTo(dvd1);
        tmp.cloneTo(dvd2);
    }
}
