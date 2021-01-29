package design_patterns.behaviour_design_pattern;

import java.util.ArrayList;
import java.util.List;
/**
 * Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about
 *  the request. This transformation lets you parameterize methods with different requests, delay or queue the request's execution,
 *  and support undo-able operations.

 * */

/**
 * Example :
 * 1. Use BankAccount to user of command 
 * 2. Add interface (Command)
 * 3. Add class for each Operation like Deposit ,WithDraw etc. ( ConcreteCommand )
 *  
 * */
//The Bank class has actual amount editing operations. It plays
//the role of a receiver: all commands end up delegating
//execution to the Bank's methods.
class BankAccount { 
	
	public void deposit(Double amount) {
		System.out.println("Deposit amount : "+amount);
	}
	
	public void withDraw(Double amount) {
		System.out.println("Withdraw amount : "+amount);
	}
}

// Command 
/** we are actually encapsulate the request like WithDrawCommand , DepositCommand ( encapsulate means creating Class ) 
 * 2. we can encapsulate ( create different class ) for all the commands that can execute for the BankAccount */
interface AbstractBankCommand{
	
	void call(Double amount,BankOperations op);
}


//The concrete commands go here.
class WithDrawCommand implements AbstractBankCommand  {

	private BankAccount bank;
	private OperationHistory history;
	
	public WithDrawCommand(BankAccount bank,OperationHistory hist) {
		this.history = hist;
		this.bank = bank;
	}
	
	@Override
	public void call(Double amount,BankOperations op) {
		bank.withDraw(amount);
		history.addOperation(op);
	}
	
}

class DepositCommand implements AbstractBankCommand {
	private BankAccount bank;
	private OperationHistory history;
	
	public DepositCommand(BankAccount bank,OperationHistory hist) {
		this.history = hist;
		this.bank = bank;
	}
	
	@Override
	public void call(Double amount,BankOperations op) {
		bank.deposit(amount);
		history.addOperation(op);
	}
		
}

class OperationHistory{
	private final List<BankOperations> history;
	
	public OperationHistory() {
		this.history = new ArrayList<BankOperations>();
	}
	
	public void addOperation(BankOperations op) {
		this.history.add(op);
	}
	
	public List<BankOperations> getStatement(){
		return this.history;
	}
}

enum BankOperations{
	DEPOSIT ,
	WITHDRAW;
}

//The application class sets up object relations. It acts as a
//sender: when something needs to be done, it creates a command
//object and executes it.

public class CommandDesignPattern {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		OperationHistory statement = new OperationHistory();
		AbstractBankCommand deposit = new DepositCommand(account, statement);
		AbstractBankCommand withDraw = new WithDrawCommand(account, statement);
		
		
		//when salary deposit operation 
		deposit.call(41354D, BankOperations.DEPOSIT);

		// when go to bar
		withDraw.call(3500D, BankOperations.WITHDRAW);
		
		// when go to cafe 
		withDraw.call(350D, BankOperations.WITHDRAW);
		
		// when borrow from friend
		deposit.call(4000D, BankOperations.DEPOSIT);
		
		for(BankOperations op: statement.getStatement()) {
			System.out.println("Your transaction : "+op);
		}
		
	}

}
