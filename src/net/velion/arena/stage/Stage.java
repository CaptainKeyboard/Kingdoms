package net.velion.arena.stage;

import net.velion.arena.IArenaEntity;
import net.velion.arena.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stage {
    protected List<Order> orders;

    public Stage() {
        orders = new ArrayList<>();
    }

    public void start() {
        orders.forEach(Order::deliver);
    }

    public void reset() {
        for (Order order : orders) {
            order.reset();
        }
    }

    public void addOrder(Order order) {
        if (orders.stream().noneMatch(order1 -> order1.getEntity().equals(order.getEntity()))) {
            orders.add(order);
        }
    }

    public void check() {
        List<IArenaEntity> winner = new ArrayList<>();
        winner = orders.stream().filter(Order::check).map(Order::getEntity).collect(Collectors.toList());
    }
}
