package designpattern.decoratorpattern;

/**
 * Created by sskim on 2022/02/04
 * Github : http://github.com/sskim91
 */

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 모카";
    }
}
