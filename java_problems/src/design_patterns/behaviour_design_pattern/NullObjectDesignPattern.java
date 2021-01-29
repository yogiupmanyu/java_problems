package design_patterns.behaviour_design_pattern;
/**
 * Null Object design pattern use to provide value where no operation can be done for particular functionality, in that case 
 * we just provide NO-OP method that does nothing , but removes null values possibility 
 * */


// Dependency
interface Log
{
  void info(String msg);
  void warn(String msg);
}
// Dependency implementation defines one case
class ConsoleLog implements Log
{

  @Override
  public void info(String msg)
  {
    System.out.println(msg);
  }

  @Override
  public void warn(String msg)
  {
    System.out.println("WARNING: " + msg);
  }
}

// No operation case implementation defines one case
final class NullLog implements Log
{
  @Override
  public void info(String msg)
  {

  }

  @Override
  public void warn(String msg)
  {

  }
}

class BankAccountDef
{
  private Log log;
  private int balance;

  public BankAccountDef(Log log)
  {
    this.log = log;
  }

  public void deposit(int amount)
  {
    balance += amount;

    // check for null everywhere?
    if (log != null)
    {
      log.info("Deposited " + amount
        + ", balance is now " + balance);
    }
  }

  public void withdraw(int amount)
  {
    if (balance >= amount)
    {
      balance -= amount;
      if (log != null)
      {
        log.info("Withdrew " + amount
          + ", we have " + balance + " left");
      }
    }
    else {
      if (log != null)
      {
        log.warn("Could not withdraw "
          + amount + " because balance is only " + balance);
      }
    }
  }
}

public class NullObjectDesignPattern {

}
