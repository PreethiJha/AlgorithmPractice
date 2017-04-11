
public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {
		Counter c1 = new Counter();
		Thread t1= new Thread(c1);
		Thread t2 = new Thread(c1);
		Thread t3 = new Thread(c1);
		Thread t4 = new Thread(c1);
		Thread t5 = new Thread(c1);
		for(int i=0;i<100;i++){
			t1.run();
			t1.sleep((long)10);
			t2.run();
			t2.sleep((long)10);
			t3.run();
			t3.sleep((long)10);
			t4.run();
			t4.sleep((long)10);
			t5.run();
			t5.sleep((long)10);
		}
		
	}
}
