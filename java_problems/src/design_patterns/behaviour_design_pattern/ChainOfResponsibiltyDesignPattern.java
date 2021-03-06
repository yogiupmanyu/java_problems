package design_patterns.behaviour_design_pattern;

/**
 * Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. 
 * Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
 * */


/**
 * in this example each handle checks if it can handle the request . like Dollar50Dispenser  checks if amnt is greater than 50
 * otherwise it next the request
 * */
class Currency {
    private int amount;

    public Currency(int amt){
        this.amount=amt;
    }

    public int getAmount(){
        return this.amount;
    }
}

//The Handler declares the interface, common for all concrete handlers. 
//It usually contains just a single method for handling requests, 
//but sometimes it may also have another method for setting the next handler on the chain.
interface DispenseChain {
    void setNextChain(DispenseChain chain);
    void dispense(Currency cur);
}

//The Base Handler is an optional class where you can put the boilerplate code that�s common to all handler classes.
//Usually, this class defines a field for storing a reference to the next handler. The clients can build a chain by passing a 
//handler to the constructor or setter of the previous handler. 
//The class may also implement the default handling behavior: it can pass execution to the next handler after checking for 
//its existence.
class Dollar50Dispenser implements DispenseChain {

	// contains reference of next chain
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 50){
            int num = cur.getAmount()/50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing "+num+" 50$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
            // calling the next chain which is Dollar20Dispenser defined at ChainOfResponsibiltyDesignPattern method 
        }else{
            this.chain.dispense(cur);
        }
    }

}

class Dollar20Dispenser implements DispenseChain{

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 20){
            int num = cur.getAmount()/20;
            int remainder = cur.getAmount() % 20;
            System.out.println("Dispensing "+num+" 20$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
            this.chain.dispense(cur);
        }
    }

}


class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 10){
            int num = cur.getAmount()/10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing "+num+" 10$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
            this.chain.dispense(cur);
        }
    }

}
//The Client may compose chains just once or compose them dynamically, depending on the application�s logic. 
//Note that a request can be sent to any handler in the chain�it doesn�t have to be the first one.
public class ChainOfResponsibiltyDesignPattern {
	private DispenseChain c1;

	/** here we define the complete chain of requests and in specific request implementation it process than delegate or 
	 *  delegate directly to next in chain without processing */
	 
    public ChainOfResponsibiltyDesignPattern() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ChainOfResponsibiltyDesignPattern atmDispenser = new ChainOfResponsibiltyDesignPattern();
        //while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
           amount = 530;
            //amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        //}

    }
}
