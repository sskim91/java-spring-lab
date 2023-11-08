package designpattern.decoratorpattern;

/**
 * Created by sskim on 2022/02/04
 * Github : http://github.com/sskim91
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        //아무것도 넣지 않은거
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        //데코레이터로 감싸다.
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

    }
}
