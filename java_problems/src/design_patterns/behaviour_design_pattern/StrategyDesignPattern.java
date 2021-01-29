package design_patterns.behaviour_design_pattern;

/**
 *Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class,
 * and make their objects interchangeable.
 * We decide at the strategy at the client side and in case of state each strategy behaves different in different state that is defined
 * in the strategy method itself
 * */
//The strategy interface declares operations common to all
//supported versions of some algorithm. The context uses this
//interface to call the algorithm defined by the concrete
//strategies.

interface CalculateStrategy {
    public void execute(int a,int b);
}
// concrete strategies
//Concrete strategies implement the algorithm while following
//the base strategy interface. The interface makes them
//interchangeable in the context.
class AddCalculateStrategy implements CalculateStrategy {
    @Override
    public void execute(int a,int b){
        System.out.println("Addition of a & b :: "+(a+b));
    }
}
class MultiplyCalculateStrategy implements CalculateStrategy {

    @Override
    public void execute(int a, int b) {
        System.out.println("Multiply of a & b :: "+a*b);
    }
}

//The context defines the interface of interest to clients.

class MarksContext {
	  // The context maintains a reference to one of the strategy
    // objects. The context doesn't know the concrete class of a
    // strategy. It should work with all strategies via the
    // strategy interface.

    private  CalculateStrategy marksCalculateStrategy ;

    
    // Usually the context accepts a strategy through the
    // constructor, and also provides a setter so that the
    // strategy can be switched at runtime.

    public void setMarksCalculateStrategy(CalculateStrategy strategy){
        this.marksCalculateStrategy = strategy;
    }

    // The context delegates some work to the strategy object
    // instead of implementing multiple versions of the
    // algorithm on its own.

    public void calculateMarks(int a,int b){
        this.marksCalculateStrategy.execute(a,b);
    }
}

//The client code picks a concrete strategy and passes it to
//the context. The client should be aware of the differences
//between strategies in order to make the right choice.

public class StrategyDesignPattern {
    public static  void main(String[] args){
        
    	CalculateStrategy marksCalculateStrategy = new AddCalculateStrategy();
        MarksContext cnts = new MarksContext();
        cnts.setMarksCalculateStrategy(marksCalculateStrategy);
        cnts.calculateMarks(20,20);

        marksCalculateStrategy = new MultiplyCalculateStrategy();
        MarksContext cnts2 = new MarksContext();
        cnts.setMarksCalculateStrategy(marksCalculateStrategy);
        cnts.calculateMarks(20,20);
    }
}

