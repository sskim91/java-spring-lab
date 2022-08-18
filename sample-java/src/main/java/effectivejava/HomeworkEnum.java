package effectivejava;

import java.util.Map;

/**
 * @author sskim
 */
public class HomeworkEnum {
    public static void main(String[] args) {

        Map<String, String> colorMap = Map.of("RED", "빨강", "BLUE", "파랑", "GREEN", "초록");

    }

    enum COLORS{
        RED("빨강"),
        BLUE("파랑"),
        GREEN("초록");

        private final String name;

        COLORS(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
