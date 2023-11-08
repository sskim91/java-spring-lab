package com.example.excelpoiji.poiji;

import com.example.excelpoiji.model.Person;
import com.poiji.bind.Poiji;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

/**
 * @author sskim
 */
public class PersonExample {
    public static void main(String[] args) throws Exception{

        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "person.xlsx");
        List<Person> people = Poiji.fromExcel(file, Person.class);
        int size = people.size();
        System.out.println("size = " + size);
        // 2
        Person person = people.get(0);
        System.out.println("person = " + person);
        // Joe
        // San Francisco, CA
        // 30
        // joe@doe.com
    }
}
