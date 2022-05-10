package json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author sskim
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String id;
    private String address;
    private Contact contact;
    private Job job;
    private List<Hobby> hobby;
}
