package net.velion.arena.builder.builders.orderBuilder;

import net.velion.arena.Arena;
import net.velion.arena.order.OrderList;

import java.util.Arrays;
import java.util.List;

public class OrderListBuilder {
    private List<OrderBuilder> orderBuilders;

    public OrderListBuilder setOrders(OrderBuilder... orders) {
        this.orderBuilders = Arrays.asList(orders);
        return this;
    }

    public OrderList build(Arena arena) {
        OrderList orderList = new OrderList();
        for (OrderBuilder orderBuilder : orderBuilders) {
            orderList.push(orderBuilder.build(arena));
        }
        return orderList;
    }
}
