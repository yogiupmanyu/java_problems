package java_concurrency.car_manufacturing_unit_example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MoneyProvidingUnit {
	

		
		private volatile Integer savedAmount;
			
		
		private static Lock amountAddLock;
		private Condition waitForFinanceDepartmentCondition = amountAddLock.newCondition();
	//	private Condition amountAddedNotification = amountAddLock.newCondition();
		

		private static Lock amountDeductlock;
	//	private Condition condition = amountDeductlock.newCondition();
		
		public static void setAmoutDeductLock(Lock lock) {
			amountDeductlock = lock;
		}
		
		public static void setAmountAddLock(Lock lock) {
			amountAddLock = lock;
		}
	
	
	private Integer demand;
	/**
	 * Returns true if amount is approved otherwise false 
	 * */
	public boolean provideMoney(Integer demand) throws InterruptedException {
		try {
			
			this.demand = demand;
			
			while(amountDeductlock.tryLock(10, TimeUnit.SECONDS)) {
				addMoney();
				while(savedAmount < demand) {
					System.out.println("Wait for Finance to add money !!!");
					waitForFinanceDepartmentCondition.await();
					
				}
				if(savedAmount >= this.demand) {
					savedAmount -= this.demand;
					return true;
				}
			}
			
			
		}finally {
			amountDeductlock.unlock();
			amountAddLock.unlock();
		}
		return false;
	}
	
	private void addMoney() {
		while(savedAmount < this.demand) {
			savedAmount = 1000000;
			waitForFinanceDepartmentCondition.signalAll();
		}
	}

}
