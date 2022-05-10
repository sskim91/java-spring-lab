package groupingby;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author sskim
 */
public class GroupingBy {
    public static void main(String[] args) {

        List<Order> orders = GroupingBy.orders();

        //단일키로 grouping
        Map<OrderType, List<Order>> collect =
                orders.stream().collect(groupingBy((Order::getOrderType)));

        System.out.println("collect = " + collect);

        /**
         {
         DELIVERY=[
         Order(itemName=후라이드 치킨, amount=17000, orderType=DELIVERY, orderBy=Andrew),
         Order(itemName=양념 치킨, amount=18000, orderType=DELIVERY, orderBy=Andrew)],
         PRESENT=[
         Order(itemName=모둠초밥, amount=13000, orderType=PRESENT, orderBy=Andrew)],
         PICKUP=[
         Order(itemName=피자, amount=18000, orderType=PICKUP, orderBy=Andrew),
         Order(itemName=돈가스, amount=10000, orderType=PICKUP, orderBy=Andrew)]
         }
         **/

        //복합키로 grouping by
        Map<OrderTuple, List<Order>> collect1 =
                orders.stream().collect(groupingBy(order -> new OrderTuple(order.getItemName(), order.getOrderType())));

        System.out.println("collect1 = " + collect1);

        //groupingBy 집계 변경 (toSet())
        Map<OrderType, Set<Order>> collect2 =
                orders.stream().collect(groupingBy(Order::getOrderType, toSet()));
        System.out.println("collect2 = " + collect2);


        //groupingBy 안의 groupingBy(중첩, multiple fields)
        Map<String, Map<OrderType, List<Order>>> collect3 =
                orders.stream().collect(groupingBy(Order::getOrderBy, groupingBy(Order::getOrderType)));
        System.out.println("collect3 = " + collect3);

        /**
         {
         Andrew = {
         DELIVERY =[Order(itemName = 후라이드 치킨, amount = 17000, orderType = DELIVERY, orderBy = Andrew), Order(itemName = 양념 치킨, amount = 18000, orderType = DELIVERY, orderBy = Andrew)],
         PRESENT =[Order(itemName = 모둠초밥, amount = 13000, orderType = PRESENT, orderBy = Andrew)],
         PICKUP =[Order(itemName = 피자, amount = 18000, orderType = PICKUP, orderBy = Andrew), Order(itemName = 돈가스, amount = 10000, orderType = PICKUP, orderBy = Andrew)]}}
         **/

        //sum 합계
        Map<OrderType, Integer> collect4 =
                orders.stream().collect(groupingBy(Order::getOrderType, summingInt(Order::getAmount)));
        System.out.println("collect4 = " + collect4);

        //average 평균
        Map<OrderType, Double> collect5 =
                orders.stream().collect(groupingBy(Order::getOrderType, averagingDouble(Order::getAmount)));
        System.out.println("collect5 = " + collect5);

        //maximum 최대값, minumum 최소값
        Map<OrderType, Optional<Order>> collect6 =
                orders.stream().collect(groupingBy(Order::getOrderType, maxBy(Comparator.comparingInt(Order::getAmount))));
        System.out.println("collect6 = " + collect6);

        Map<OrderType, Optional<Order>> collect6_ =
                orders.stream().collect(groupingBy(Order::getOrderType, minBy(Comparator.comparingInt(Order::getAmount))));
        System.out.println("collect6_ = " + collect6_);

        //summary 정보
        Map<OrderType, IntSummaryStatistics> collect7 =
                orders.stream().collect(groupingBy(Order::getOrderType, summarizingInt(Order::getAmount)));
        System.out.println("collect7 = " + collect7);

        //Map의 value값을 다른 타입으로 리턴
        Map<OrderType, String> collect8 =
                orders.stream().collect(groupingBy(Order::getOrderType, mapping(Order::getItemName, joining(",", "[", "]"))));
        System.out.println("collect8 = " + collect8);

        //Map를 다른 타입으로 리턴하기
        EnumMap<OrderType, List<Order>> collect9 =
                orders.stream().collect(groupingBy(Order::getOrderType, () -> new EnumMap<>(OrderType.class), toList()));
        System.out.println("collect9 = " + collect9);
    }


    private static List<Order> orders() {
        return List.of(
                new Order("후라이드 치킨", 17_000, OrderType.DELIVERY, "Andrew"),
                new Order("양념 치킨", 18_000, OrderType.DELIVERY, "Andrew"),
                new Order("피자", 18_000, OrderType.PICKUP, "Andrew"),
                new Order("돈가스", 10_000, OrderType.PICKUP, "Andrew"),
                new Order("모둠초밥", 13_000, OrderType.PRESENT, "Andrew")
        );
    }

    @Data
    @AllArgsConstructor
    static class Parent {
        private String id;
        private String value;
    }

    @Data
    @AllArgsConstructor
    static class Child {
        private String parentId;
        private String value;
    }

}


