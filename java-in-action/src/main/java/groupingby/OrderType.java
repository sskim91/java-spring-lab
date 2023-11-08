package groupingby;

/**
 * @author sskim
 */
public enum OrderType {
    PICKUP("포장"),
    DELIVERY("배달"),
    PRESENT("선물하기");

    private final String text;

    OrderType(String text) {
        this.text = text;
    }
}
