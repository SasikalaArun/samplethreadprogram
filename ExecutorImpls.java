import java.util.concurrent.*;

public class ExecutorImpls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		Runnable ruobj= ()-> {
			System.out.println("Threadname: "+Thread.currentThread().getName());
		};
		executor2.execute(ruobj);
		
		Runnable robj= ()-> {
			System.out.println("Threadname: "+Thread.currentThread().getName());
		};
		Future fut=executor.submit(robj);
		System.out.println("Is thread using Runnable Interface done: "+fut.isDone());

		try {
		    System.out.println("attempt to shutdown executor");
		    executor.shutdown();
		    executor.awaitTermination(5, TimeUnit.SECONDS);
		    executor2.shutdown();
		    executor2.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!executor.isTerminated()&&!executor2.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    executor.shutdownNow();
		    executor2.shutdownNow();
		    System.out.println("shutdown finished");
		}
		System.out.println("Is thread using Runnable Interface done: "+fut.isDone());

	}
}
