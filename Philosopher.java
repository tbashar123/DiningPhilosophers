
public class Philosopher implements Runnable {
	
	//1 Creating the forks on either side of this Philosopher
	
	private Object leftFork;
	private Object rightFork;
	
	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	
	//2 Philosopher to perform an action
	
	private void DoAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() +" "+ action);
						   Thread.sleep(((int) (Math.random() * 100)));
	}
	
	//3 
	
	@Override
	public void run() {
		try {
			while(true) {
				//thinking
				DoAction(
						System.nanoTime() + ": Thinking..."
						);
				synchronized(leftFork) {
					DoAction(
							System.nanoTime() + ": Picked up left fork"
							);
					synchronized(rightFork) {
						// eating
							DoAction(
									System.nanoTime() + ": Picked up right fork - eating" 
									);
							
							DoAction(
									System.nanoTime() + ": Put down right fork"
									);
					}
					
					//Back to thinking
					DoAction(
							System.nanoTime() + ": Put down left fork. Back to thinking..."
							);
					
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
		
	}
	
}
