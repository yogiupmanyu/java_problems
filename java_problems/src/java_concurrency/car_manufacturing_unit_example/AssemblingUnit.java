package java_concurrency.car_manufacturing_unit_example;

import java.util.concurrent.Phaser;

public class AssemblingUnit extends Thread implements Runnable{

	
	Phaser wait = new Phaser(3);
	
	public Phaser getRequiredNumberOfServiceBeforeAssembling() {
		return wait;	
	}
	
	@Override
	public void run() {
		
		try {
			
			wait.awaitAdvance(3);
			System.out.println("Engine , Music and CarBody Completed.");
			System.out.println("Assembling Starts !!!");
			
			Thread.sleep(1000);
			
			System.out.println("Assembling Ends !!!");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
