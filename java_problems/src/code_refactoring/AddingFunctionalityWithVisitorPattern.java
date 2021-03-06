package code_refactoring;

class SalesTrainee implements Visitable{
	
	private int sickDays;
	private int failedTests;
	private double salary;
	
	public SalesTrainee(int sickDays, int failedTests, double salary) {
		this.sickDays = sickDays;
		this.failedTests = failedTests;
		this.salary = salary;
	}
	
	public double accept(Visitor visitor){
		
		return visitor.visit(this);
		
	}
	
	// Getters & Setters
	
	public int getSickDays() {
		return sickDays;
	}
	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}
	public int getFailedTests() {
		return failedTests;
	}
	public void setFailedTests(int failedTests) {
		this.failedTests = failedTests;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}

class Salesman implements Visitable{
	
	private double totalSalesAmount;
	private int newCustomers;
	
	public Salesman(double totalSalesAmount, int newCustomers) {
		this.totalSalesAmount = totalSalesAmount;
		this.newCustomers = newCustomers;
	}

	public double accept(Visitor visitor){
		
		return visitor.visit(this);
		
	}

	// Getters & Setters

	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}

	public int getNewCustomers() {
		return newCustomers;
	}

	public void setNewCustomers(int newCustomers) {
		this.newCustomers = newCustomers;
	}

}


class Boss implements Visitable{
	
	private double totalSalesAmount;
	private int newCustomers;
	private double officeExpenses;

	public Boss(double totalSalesAmount, int newCustomers, double officeExpenses) {
		this.totalSalesAmount = totalSalesAmount;
		this.newCustomers = newCustomers;
		this.officeExpenses = officeExpenses;
	}

	public double accept(Visitor visitor){
		
		return visitor.visit(this);
		
	}
	
	// Getters & Setters

	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}
	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}
	public int getNewCustomers() {
		return newCustomers;
	}
	public void setNewCustomers(int newCustomers) {
		this.newCustomers = newCustomers;
	}
	public double getOfficeExpenses() {
		return officeExpenses;
	}
	public void setOfficeExpenses(double officeExpenses) {
		this.officeExpenses = officeExpenses;
	}
}

// Allows the Visitor to pass in an object
// so the right calculations are done
// depending on the object type

// accept() is in each employee object. Those
// employee objects then pass an object of their 
// specific type to a concrete visitor. The concrete 
// visitors contain a method named visit that is
// overloaded to handle each of the employee types
// and can then perform different calculations based
// on the employee type.

interface Visitable {

	public double accept(Visitor visitor);
	
}

// Each concrete visitor type will implement
// the Visitor interface. Here we define every
// instance of method overloading needed

interface Visitor {
	
	public double visit(SalesTrainee trainee);
	public double visit(Salesman salesman);
	public double visit(Boss boss);

}

class YearlyBonusVisitor implements Visitor{

	public double visit(SalesTrainee trainee) {
		
		System.out.println("Trainees Yearly Bonus");
		
		// Find bonus percentage using ternary operator
		
		double yearlyBonusPercentage = (trainee.getSickDays() < 10 && trainee.getFailedTests() < 2) ? .10 : .02;
		
		double yearlyBonusAmount = trainee.getSalary() * yearlyBonusPercentage;
		
		return yearlyBonusAmount;

	}

	public double visit(Salesman salesman) {
		
		System.out.println("Salesmans Yearly Bonus");
		
		double yearlyBonusPercentage = (salesman.getTotalSalesAmount() > 100000 && salesman.getNewCustomers() > 50) ? .12 : .04;
		
		double yearlyBonusAmount = salesman.getTotalSalesAmount() * yearlyBonusPercentage;
		
		return yearlyBonusAmount;
		
	}

	public double visit(Boss boss) {
		
		System.out.println("Bosses Yearly Bonus");
		
		double yearlyBonusPercentage = (boss.getOfficeExpenses() < 50000 && boss.getNewCustomers() > 1000) ? .15 : .04;
				
		double yearlyBonusAmount = boss.getTotalSalesAmount() * yearlyBonusPercentage;
				
		return yearlyBonusAmount;
		
	}

}

class QuarterlyBonusVisitor implements Visitor{

	public double visit(SalesTrainee trainee) {
		
		System.out.println("Trainees Yearly Bonus");
		
		// Find bonus percentage using ternary operator
		
		double quarterlyBonusPercentage = (trainee.getSickDays() < 2 && trainee.getFailedTests() < 1) ? .01 : 0;
		
		double quarterlyBonusAmount = trainee.getSalary() * quarterlyBonusPercentage;
		
		return quarterlyBonusAmount;

	}

	public double visit(Salesman salesman) {
		
		System.out.println("Salesmans Yearly Bonus");
		
		double quarterlyBonusPercentage = (salesman.getTotalSalesAmount() > 25000 && salesman.getNewCustomers() > 20) ? .03 : 0;
		
		double quarterlyBonusAmount = salesman.getTotalSalesAmount() * quarterlyBonusPercentage;
		
		return quarterlyBonusAmount;
		
	}

	public double visit(Boss boss) {
		
		System.out.println("Bosses Yearly Bonus");
		
		double quarterlyBonusPercentage = (boss.getOfficeExpenses() < 12000 && boss.getNewCustomers() > 250) ? .05 : .01;
				
		double quarterlyBonusAmount = boss.getTotalSalesAmount() * quarterlyBonusPercentage;
				
		return quarterlyBonusAmount;
		
	}

}

class TestBonusCalculator {

	public static void main(String[] args){
		
		// We can have completely different calculations performed
		// on completely different objects just by defining a
		// new concrete Visitor
		
		YearlyBonusVisitor yearlyBonusCalculator = new YearlyBonusVisitor();
		
		SalesTrainee bradTrainee = new SalesTrainee(5, 1, 20000);
		Salesman tomSalesman = new Salesman(150000, 62);
		Boss rossBoss = new Boss(1000000, 1200, 4000000);
		
		System.out.println("YEARLY BONUS");
		
		System.out.println(bradTrainee.accept(yearlyBonusCalculator));
		System.out.println(tomSalesman.accept(yearlyBonusCalculator));
		System.out.println(rossBoss.accept(yearlyBonusCalculator));
		
		// Calculate Quarterly Bonus
		
		QuarterlyBonusVisitor quarterlyBonusCalculator = new QuarterlyBonusVisitor();
		
		bradTrainee = new SalesTrainee(1, 0, 20000);
		tomSalesman = new Salesman(30000, 22);
		rossBoss = new Boss(200000, 300, 11000);
		
		System.out.println("\nQUARTERLY BONUS");
		
		System.out.println(bradTrainee.accept(quarterlyBonusCalculator));
		System.out.println(tomSalesman.accept(quarterlyBonusCalculator));
		System.out.println(rossBoss.accept(quarterlyBonusCalculator));
		
	}
	
}