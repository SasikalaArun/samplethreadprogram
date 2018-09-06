import java.util.concurrent.*;
import java.util.*;

public class InvokeAnyandAll {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Set<Callable<String>> callables = new HashSet<Callable<String>>();
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});
		System.out.println("InvokeAny");
		String result = executorService.invokeAny(callables);
		System.out.println("result = " + result);
		System.out.println("InvokeAll");
		List<Future<String>> futures = executorService.invokeAll(callables);
		for(Future<String> future : futures){
		    System.out.println("future.get = " + future.get());
		}
		executorService.shutdown();
	}
}
