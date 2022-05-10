package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sskim
 */
public class JacksonReadValue {
    public static void main(String[] args) throws JsonProcessingException {


        String json = "{\n" +
                "  \"name\": \"zooneon\",\n" +
                "  \"age\": 25,\n" +
                "  \"address\": \"seoul\",\n" +
                "  \"contact\": {\n" +
                "    \"phone_number\": \"0102222\",\n" +
                "    \"email\": \"foo@google.com\"\n" +
                "  },\n" +
                "  \"job\": {\n" +
                "    \"working\": true\n" +
                "  },\n" +
                "  \"hobby\": [\n" +
                "        {\"name\": \"농구\"},\n" +
                "        {\"name\": \"축구\"},\n" +
                "        {\"name\": \"탁구\"}\n" +
                "  ]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        System.out.println("person = " + person);

        person.getHobby().removeIf(JacksonReadValue::nameRemove);

        System.out.println("person = " + person);

    }

    public static boolean nameRemove(Hobby name) {
        return name.getName().equals("축구");
    }

}
