import java.util.concurrent;

package Thread;

public class Threadsampleprogram implements Runnable{
public void run(){
	Runnable task = () -> {
	    String threadName = Thread.currentThread().getName();
	    System.out.println("Hello " + threadName);
	};

	task.run();

	Thread thread = new Thread(task);
	thread.start();

	System.out.println("Done!");
}
}
