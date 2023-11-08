package com.example.excelpoiji.poiji;

import com.example.excelpoiji.model.Employee;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

/**
 * @author sskim
 */
public class EmployeeExample {
    public static void main(String[] args) throws Exception {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "employees.xlsx");

        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder
                .settings()
                .addListDelimiter(";")
                .preferNullOverDefault(true)
                .build();

        List<Employee> employees = Poiji.fromExcel(file, Employee.class, options);

        // alternatively
//        InputStream stream = new FileInputStream(new File("employees.xls"));
        //List<Employee> employees = Poiji.fromExcel(stream, PoijiExcelType.XLS, Employee.class, options);

        int size = employees.size();
        System.out.println("size = " + size);

        employees.forEach(System.out::println);
    }
}
