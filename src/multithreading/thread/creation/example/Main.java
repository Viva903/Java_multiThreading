package multithreading.thread.creation.example;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// lambda expression
		Thread newThread = new Thread(() -> {
			System.out.println("We are in the new thread : " + Thread.currentThread().getName());
			System.out.println(
					Thread.currentThread().getName() + " Priority is : " + Thread.currentThread().getPriority());
			throw new RuntimeException("Intentional Exception for demo");
		});

		newThread.setName("Misbehaving Thread");
		newThread.setPriority(Thread.MAX_PRIORITY);
		newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"A critical error happend in thread " + t.getName() + " the error is " + e.getMessage());

			}
		});

		System.out.println("We are in thread : " + Thread.currentThread().getName() + " before starting new thread");
		newThread.start();
		System.out.println("We are in thread : " + Thread.currentThread().getName() + " after starting new thread");

//		Thread.sleep(10000);
	}
}
