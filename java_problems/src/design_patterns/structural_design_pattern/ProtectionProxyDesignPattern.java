package design_patterns.structural_design_pattern;

// The interface of Protection ( Drivable ) 
//The Service Interface declares the interface of the Service. 
//The proxy must follow this interface to be able to disguise itself as a service object.
interface Drivable
{
  void drive();
}

// The Service is a class that provides some useful business logic.
class Car implements Drivable
{
  protected Driver driver;

  public Car(Driver driver)
  {
    this.driver = driver;
  }

  @Override
  public void drive()
  {
    System.out.println("Car being driven");
  }
}

//The Proxy class has a reference field that points to a service object. After the proxy finishes its processing 
//(e.g., lazy initialization, logging, access control, caching, etc.), it passes the request to the service object
class CarProxy extends Car
{
  private Driver driver;

  public CarProxy(Driver driver)
  {
    super(driver);
  }

  @Override
  public void drive()
  {
    if (driver.age >= 17)
      super.drive();
    else
      System.out.println("Driver too young");
  }
}

class Driver
{
  public int age;

  public Driver(int age)
  {
    this.age = age;
  }
}
// client
public class ProtectionProxyDesignPattern
{
  public static void main(String[] args)
  {
    Drivable car = new CarProxy(new Driver(12)); // 22
    car.drive();
  }
}
