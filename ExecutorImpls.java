import java.util.concurrent.*;

public class ExecutorImpls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Using Submit method " + threadName);
		});
		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		executor2.execute(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Using Execute method " + threadName);
		});

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

	}
}
