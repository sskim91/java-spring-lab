package com.example.excelpoiji.poiji;

import com.example.excelpoiji.model.Car;
import com.poiji.bind.Poiji;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

/**
 * @author sskim
 */
public class SuperClassInheritance {
    public static void main(String[] args) throws Exception{

        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "car.xlsx");
        List<Car> cars = Poiji.fromExcel(file, Car.class);

        cars.forEach(System.out::println);
    }
}
