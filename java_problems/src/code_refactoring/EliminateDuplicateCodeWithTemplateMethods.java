// Generalization is used to transform specific code
// into general purpose code. This simplifies, and 
// removes duplicate code

// The Template Method Pattern helps you eliminate 
// duplicate code. When objects perform similar steps
// in the same order implement the similar code in
// a template method and allow subclasses to override
// the behavior that varies.

abstract class Sandwich {
	
	// This is the template method
	// It is declared final so subclasses
	// can't override it
	
	final void makeSandwich(){
		
		System.out.println("\n------NEW ORDER------\n");
		
		cutBun();
		
		if(customerWantsMeat()){
			
			addMeat();
			
		}
		
		addVegetables();
		
		if(customerWantsCondiments()){
		
			addCondiments();
		
		}
		
		wrapSandwich();
		
	}
	
	// These methods must be overridden by subclasses
	
	abstract void addMeat();
	abstract void addCondiments();
	
	// These methods are used for every sandwich
	
	public void cutBun(){
		
		System.out.println("The Bun is Cut");
		
	}
	
	public void addVegetables(){
		
		System.out.println("Lettuce, onions & Tomatoes Added");
		
	}
	
	public void wrapSandwich(){
		
		System.out.println("The Sandwich is Wrapped");
		
	}
	
	// These are called hooks. They can be overridden
	// Use abstract methods when you want to force the
	// user to override and a hook when it is optional
	
	boolean customerWantsMeat(){ return true; }
	
	boolean customerWantsCondiments(){ return true; }

}

class Hamburger extends Sandwich{
	
	// BAD WAY
	/*
	private boolean customerWantsCondiments = true;
	
	Hamburger(boolean wantsCondiments){
		
		customerWantsCondiments = wantsCondiments;
		
	}
	
	public void makeSandwich(){
		
		cutBun();
		
		// addMeat() will be overridden by subclasses
		
		addMeat();
			
		addVegetables();
		
		// addCondiments() will be overridden by subclasses
		// customerWantsCondiments() should be created as
		// a hook method that executes optional code
		
		if(customerWantsCondiments()){
		
			addCondiments();
		
		}
		
		wrapSandwich();
		
	}
	*/
	
	void addMeat() {
		
		System.out.println("Hamburger Added");
		
	}


	void addCondiments() {
		
		System.out.println("Special Sauce Added");
		
	}

}

class VeggieSub extends Sandwich{
	
	// BAD WAY
	/*
	private boolean customerWantsCondiments = true;
		
	VeggieSub(boolean wantsCondiments){
			
		customerWantsCondiments = wantsCondiments;
			
	}
		
	public void makeSandwich(){
			
		cutBun();
				
		addVegetables();
			
		if(customerWantsCondiments()){
			
			addCondiments();
			
		}
			
		wrapSandwich();
			
	}
	*/
	
	boolean customerWantsMeat(){ return false; }

	void addMeat() {
		
	}


	void addCondiments() {
		
		System.out.println("Vinegar and Oil Added");
		
	}

}

public class Cook{
	
	public static void main(String[] args){
		
		Sandwich customer1 = new Hamburger();
		
		customer1.makeSandwich();
		
		Sandwich customer2 = new VeggieSub();
		
		customer2.makeSandwich();
		
	}

}