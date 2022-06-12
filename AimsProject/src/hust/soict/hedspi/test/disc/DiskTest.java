package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
	public static void Test () {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","John Musker",90,18.99f);
        
		boolean test = dvd1.search("kInG lIoN");
		System.out.println(test);
		
		Order TestOrder = new Order(dvd1, dvd2, dvd3);
		TestOrder.addDigitalVideoDisc(dvd1,dvd2);
		TestOrder.printOrderformally();
		TestOrder.getALuckyItem();
		TestOrder.printOrderformally();
		
	}
	
}
