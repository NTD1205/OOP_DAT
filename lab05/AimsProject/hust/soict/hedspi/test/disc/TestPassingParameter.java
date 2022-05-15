package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("JungleDVD title: " + jungleDVD.getTitle());
        System.out.println("CinderellaDVD title: " + cinderellaDVD.getTitle());

        //changeTitle(jungleDVD, cinderellaDVD.getTitle());
        //System.out.println("JungleDVD title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        DigitalVideoDisc tmp = new DigitalVideoDisc(disc1.getTitle(), disc1.getCategory(),
                disc1.getDirector(), disc1.getLength(), disc1.getCost());

        disc1.setTitle(disc2.getTitle());
        disc1.setCategory(disc2.getCategory());
        disc1.setDirector(disc2.getDirector());
        disc1.setCost(disc2.getCost());
        disc1.setLength(disc2.getLength());

        disc2.setTitle(tmp.getTitle());
        disc2.setCategory(tmp.getCategory());
        disc2.setDirector(tmp.getDirector());
        disc2.setCost(tmp.getCost());
        disc2.setLength(tmp.getLength());
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
