package hust.soict.hedspi.aims;

public class Two extends One{
	public int k = 3;
    void f() {
        count = count * 3;
        System.out.println("in two, count = " +count);
    }
    
    public Two() {
		// TODO Auto-generated constructor stub
//    	super();
    	System.out.println("Class two");
	}
    
//    void k() {
//    	System.out.println("in two k, count = " +count);
//    }
    
    public static void main(String[] args) {
        One x = new Two();
//        One y = (One) x;
//        x.f();
//        y.f();
////        System.out.println(x.k);
//        Two z = (Two) new One();
//        z.f();
    }    
}
