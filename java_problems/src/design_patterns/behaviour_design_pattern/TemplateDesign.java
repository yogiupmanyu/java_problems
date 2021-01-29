package design_patterns.behaviour_design_pattern;

//The abstract class defines a template method that contains a
//skeleton of some algorithm composed of calls, usually to
//abstract primitive operations. Concrete subclasses implement
//these operations, but leave the template method itself
//intact.
abstract class GameAI{
	// The template method defines the skeleton of an algorithm. a class can have several template methods
	public void takeTurn() {
		System.out.println("Take Turn similar to all the type of User in game");
	}
	
	// And some of them may be defined as abstract.
	public abstract void typeOfWeapon();
}

//Concrete classes have to implement all abstract operations of
//the base class but they must not override the template method
//itself.
class OrcsAI extends GameAI{

	@Override
	public void typeOfWeapon() {
		// TODO Auto-generated method stub
		System.out.println("Orcs have Pistols as weapon....");
	}
	
}


class MonstersAI extends GameAI {

	@Override
	public void typeOfWeapon() {
		// TODO Auto-generated method stub
		System.out.println("Monsters have Machine Hun as weapon....");
	}
	
}
public class TemplateDesign {
	
	public static void main(String[] args) {
		OrcsAI orcs = new OrcsAI();
		MonstersAI monsters = new MonstersAI();
		
		// both type of player can use the implementation of takeTurn . we don't need to implement these in all of the player;
		
		orcs.takeTurn();
		monsters.takeTurn();
	}
}
