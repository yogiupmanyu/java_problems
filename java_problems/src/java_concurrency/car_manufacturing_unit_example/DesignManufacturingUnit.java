package java_concurrency.car_manufacturing_unit_example;

import java.util.concurrent.locks.Condition;

public class DesignManufacturingUnit implements Runnable{
	
	private Condition designNotReadyCondition = null; 
	
	public void setDesignNotReadyCondition(Condition condition) {
		this.designNotReadyCondition = condition;
	}
	
	@Override
	public void run() {
		
		try {
			
			System.out.println("DesignManufacturingUnit starts working !!!");
			Thread.sleep(100);
			System.out.println("======================================================");
			
			designNotReadyCondition.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
