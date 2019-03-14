
public class DiningPhilosophers {
	
	//create 5 Philosophers as threads and start them all 
	
	public static void main (String[] args) throws Exception{
		
		System.out.println(" Tanvir Bashar "
				+ "\n --------------------------------"
				);
		
		Philosopher[] philosophers = new Philosopher[5];
		Object[] forks = new Object[philosophers.length];
		
		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}
		
		for (int i = 0; i < philosophers.length; i++) {
			Object leftFork = forks[i]; 	//looping for the left fork 
			Object rightFork = forks[(i + 1) % forks.length]; //looping for the right fork
			
			if (i == philosophers.length -1) {
				
				//The last philosopher picks up the right fork first
				philosophers[i] = new Philosopher(rightFork, leftFork);
			}
			else {
				philosophers[i] = new Philosopher(leftFork, rightFork);
			}
			
			Thread k = new Thread(philosophers[i], "Philosopher " + (i + 1));
			k.start();
		}
	}
}
