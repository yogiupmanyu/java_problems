package design_patterns.structural_design_pattern;

/** 
 * We have two interface Turkey and Duck we need to adapt Turkey with Duck so all the functionality provided for Duck interface can be 
 * used by Turkey
 * */
interface Duck {
	public void quack();
	public void fly();
}
interface Turkey {
	public void gobble();
	public void fly();
}

class WildTurkey implements Turkey{

	@Override
	public void gobble() {
		System.out.println("Turkey Gobbles !!!");
	}

	@Override
	public void fly() {
		System.out.println("Turkey Flies !!!");
	}
	
}

class TurkeyAdapter implements Duck{

	private Turkey turkey;
	
	TurkeyAdapter(Turkey turkey){
		this.turkey = turkey;
	}
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}
	
}
public class SimpleAdapterDesignPatter {
	public void main(String[] args) {
		Turkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		testDuck(turkeyAdapter);
	}

	private void testDuck(Duck turkeyAdapter) {
		turkeyAdapter.fly();
		turkeyAdapter.quack();
	}
}
