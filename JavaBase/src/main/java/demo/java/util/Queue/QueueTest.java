package demo.java.util.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	static Queue<Long> dates = new LinkedList<Long>();
    public static void add(long time){
        dates.add(time);
        if(dates.size() >10){
            dates.remove();
        }
    }
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0;i<100;i++){
			add(System.currentTimeMillis());
			Iterator<Long> ite =  dates.iterator();
			while(ite.hasNext()){
				System.out.print(ite.next()+" ");
			}
			System.out.println();
			Thread.sleep(100);
		}

	}

}
