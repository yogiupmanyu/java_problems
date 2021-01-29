package java_concurrency.car_manufacturing_unit_example;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class CarBodyManufacturingUnit implements Runnable{

	private Semaphore electricUnitKey;
	private boolean isElecticityProvided = false;
	//private Lock designLock  = null;
	private Condition designNotReadyCondition = null; 
	private Phaser signalForAssemling ;
	
	
	public CarBodyManufacturingUnit(Semaphore semaphore,Phaser signalForAssemling) {
		this.electricUnitKey = semaphore;
		this.signalForAssemling = signalForAssemling;
	}
	
	public void setDesignManufacturingUnitLock(Condition condition) {
		//this.designLock = design;
		this.designNotReadyCondition = condition;
	}

	@Override
	public void run() {
		try {
			// Creates CarBodyManufacturingUnit thread and do some operation
			System.out.println("CarBodyManufacturingUnit starts working !!!");
			Thread.sleep(100);
			System.out.println("======================================================");

			System.out.println("CarBodyManufacturingUnit Accessing Electricity Unit !!!");
			while (!isElecticityProvided && electricUnitKey.tryAcquire(10, TimeUnit.SECONDS)) {
				ElectricityProvidingUnit.provideElectricity();
				isElecticityProvided = true;
				electricUnitKey.release();
			}

			if (isElecticityProvided) {
				// now getting sanction amount from MoneyProvidingUnit
				
				// wait for Design Unit to completes design 
				designNotReadyCondition.await();
				
				System.out.println("======================================================");
				System.out.println("Car Body Processing !!! ");
				Thread.sleep(700);
				System.out.println("Car Body Completes !!! ");				
				System.out.println("======================================================");
				signalForAssemling.arrive();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}
