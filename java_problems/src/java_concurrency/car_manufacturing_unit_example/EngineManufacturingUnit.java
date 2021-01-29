package java_concurrency.car_manufacturing_unit_example;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class EngineManufacturingUnit implements Runnable{

	private Semaphore electricUnitKey;
	private boolean isElecticityProvided = false;
	private Phaser signalForAssemling ;
	
	public EngineManufacturingUnit(Semaphore semaphore,Phaser signalForAssemling) {
		this.electricUnitKey = semaphore;
		this.signalForAssemling = signalForAssemling;
	}
	
	
	@Override
	public void run() {
		try {
			// Creates EngineManufacturingUnit thread and do some operation
			System.out.println("EngineManufacturingUnit  starts working !!!");
			Thread.sleep(100);
			System.out.println("======================================================");
			
			System.out.println("EngineManufacturingUnit Accessing Electricity Unit !!!");
			while(!isElecticityProvided &&  electricUnitKey.tryAcquire(10,TimeUnit.SECONDS)) {
				ElectricityProvidingUnit.provideElectricity();
				isElecticityProvided = true;
				electricUnitKey.release();
			}
			
			if(isElecticityProvided) {
				// now getting sanction amount from MoneyProvidingUnit
				System.out.println("======================================================");
				System.out.println("Engine Manufacturing Processing !!! ");
				Thread.sleep(100);
				System.out.println("Engine Manufacturing Completes !!! ");				
				System.out.println("======================================================");
				signalForAssemling.arrive();
			}
			
			
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
