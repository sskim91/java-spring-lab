package designpattern.decoratorpattern;

/**
 * Created by sskim on 2022/02/04
 * Github : http://github.com/sskim91
 */
public abstract class Beverage {
    String description = "제목없음";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
