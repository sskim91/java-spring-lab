package designpattern.decoratorpattern;

/**
 * Created by sskim on 2022/02/04
 * Github : http://github.com/sskim91
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        super.description = "하우스 블렌드 커피";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
