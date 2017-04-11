public class Counter implements Runnable{

     protected long count = 0;

     public void add(long value){
         this.count = this.count + value;
         System.out.println(count);
     }

	@Override
	public void run() {
		add(1);
	}
  }