package java_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java_concurrency.car_manufacturing_unit_example.AssemblingUnit;
import java_concurrency.car_manufacturing_unit_example.CarBodyManufacturingUnit;
import java_concurrency.car_manufacturing_unit_example.DesignManufacturingUnit;
import java_concurrency.car_manufacturing_unit_example.EngineManufacturingUnit;
import java_concurrency.car_manufacturing_unit_example.MusicSystemManufacturingUnit;

public class JavaConcurrencyPracticeApplication {

	private static final Integer nThreads = 10;

	public static void main(String[] args) {

		try {
			ExecutorService service = Executors.newFixedThreadPool(nThreads);

			Semaphore electricUnitSemaphore = new Semaphore(2);

			AssemblingUnit assemble = new AssemblingUnit();
			
			Phaser assemblingWait = assemble.getRequiredNumberOfServiceBeforeAssembling();

			EngineManufacturingUnit engineUnit = new EngineManufacturingUnit(electricUnitSemaphore,assemblingWait);
			CarBodyManufacturingUnit carBodyUnit = new CarBodyManufacturingUnit(electricUnitSemaphore,assemblingWait);
			MusicSystemManufacturingUnit musicSystemUnit = new MusicSystemManufacturingUnit(electricUnitSemaphore,assemblingWait);
			DesignManufacturingUnit designUnit = new DesignManufacturingUnit();
			
			Lock designLock = new ReentrantLock();
			Condition designCondition = designLock.newCondition();
			carBodyUnit.setDesignManufacturingUnitLock(designCondition);
			designUnit.setDesignNotReadyCondition(designCondition);
			
			service.execute(engineUnit);
			service.execute(designUnit);
			service.execute(carBodyUnit);
			service.execute(musicSystemUnit);
			service.execute(assemble);

			assemble.join();
			
			System.out.print("Completes !!!");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
