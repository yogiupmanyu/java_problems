package java_concurrency.car_manufacturing_unit_example;

public class ElectricityProvidingUnit {
	
	static public void provideElectricity() throws InterruptedException {
		System.out.println("Electricity Providing Unit !!!");
		System.out.println("======================================================");
		Thread.sleep(500);
		System.out.println("Electricity Providing Unit Completes its process !!!");
		System.out.println("======================================================");
		
	}

}
