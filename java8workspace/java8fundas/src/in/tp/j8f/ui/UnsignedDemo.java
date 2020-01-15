package in.tp.j8f.ui;

public class UnsignedDemo {

	public static void main(String[] args) {
		
		byte n1 = Byte.MAX_VALUE;
		byte n2 = Byte.MIN_VALUE;
		
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n1/n2);
		System.out.println(n1%n2);
		System.out.println(Integer.divideUnsigned(n1, n2));
		System.out.println(Integer.remainderUnsigned(n1, n2));
		
		System.out.println(Integer.toString(n2,2));
		System.out.println(Integer.toUnsignedString(n2,2));
		System.out.println(Integer.toUnsignedString(n2,2).length());
	}

}
