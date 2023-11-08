package designpattern.decoratorpattern;

/**
 * Created by sskim on 2022/02/04
 * Github : http://github.com/sskim91
 */
public class Espresso extends Beverage {
    public Espresso() {
        super.description = "에스프레소";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
