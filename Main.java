/*
practice of interfaces, classes and OOPs.
Story - The system is a duck simulation game. There are ducks, each having weight and number of wings. All ducks can fly and quack, but different type of ducks fly and quack differently. For instance, let us consider the following–
1.Rubber ducks don’t fly and squeak.
2.Mallard ducks fly fast and quack loud.
3.Redhead ducks fly slow and quack mild.
All ducks have following common property:
Type of Duck – Use enum to represent this value
Design classes and interfaces for the above story to meet the following requirements -
a.Create a duck
b.Show details of a duck, i.e. when you call for e.g. ShowDetails() method of a duck, duck should print its traits.
User following concepts: class, interfaces, polymorphism etc.
*/
interface QuackBehavior{
    void quack();
}
interface FlyBehavior{
    void fly();
}

// We are defining each behaviour separately
class CantFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
class FlyFast implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("flying fastly");
    }
}
class FlySlow implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("flying slowly");
    }
}
class QuackLoud implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quack loudly");
    }
}
class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("squeaking....");
    }
}
class QuackMild implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quacking mild.....");
    }
}

// It will represent the type of Duck
enum DuckType{
    RUBBER, MALLARD, REDHEAD
}

//This is the super class of all types of duck classes
abstract class Duck{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    Duck(){}
    void performFly() {
        this.flyBehavior.fly();
    }
    void performQuack() {
        this.quackBehavior.quack();
    }
    void showDetails(){
        System.out.println("I am duck");
    }
}
class RubberDuck extends Duck{
    RubberDuck(){
        this.flyBehavior =new CantFly();
        this.quackBehavior =new Squeak();
    }

    @Override
    void showDetails() {
        System.out.println("I am "+DuckType.RUBBER+" Duck");
    }
}
class MallardDuck extends Duck{
    MallardDuck()
    {
        this.flyBehavior = new FlyFast();
        this.quackBehavior = new QuackLoud();
    }
    @Override
    void showDetails() {
        System.out.println("I am "+DuckType.MALLARD+" Duck");
    }
}
class ReadheadDuck extends Duck{
    ReadheadDuck()
    {
        this.flyBehavior = new FlySlow();
        this.quackBehavior =new QuackMild();
    }

    @Override
    void showDetails() {
        System.out.println("I am "+DuckType.REDHEAD+" Duck");
    }
}
public class Main{
    public static void main(String[] args) {
        Duck md=new MallardDuck();
        md.showDetails();
        md.performFly();
        md.performQuack();

        System.out.println("==============================================");
        Duck rd=new RubberDuck();
        rd.showDetails();
        rd.performFly();
        rd.performQuack();

        System.out.println("==================================================");
        Duck readheadDuck=new ReadheadDuck();
        readheadDuck.showDetails();
        readheadDuck.performFly();
        readheadDuck.performQuack();
    }
}
