package net.velion.arena.order;

import net.velion.arena.IArenaEntity;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderList {
    private final List<Order> orders;

    public OrderList() {
        orders = new ArrayList<>();
    }

    public void push(Order order) {
        if (order.getEntity() != null) {
            Optional<Order> foundOrder = orders.stream().filter(order1 -> order1.getEntity().equals(order.getEntity())).findFirst();
            if (foundOrder.isPresent()) {
                foundOrder.get().append(order);
            } else {
                orders.add(order);
            }
        }
    }

    public IArenaEntity check() {
        Optional<Order> wonOrder = orders.stream().filter(Order::check).findFirst();
        return wonOrder.map(Order::getEntity).orElse(null);
    }

    public void deliverAll() {
        for (Order order : orders) {
            order.deliver();
        }
    }

    public void reset() {
        for (Order order : orders) {
            order.reset();
        }
    }

    public void validate() throws ArenaInvalidException {
        if (orders.isEmpty()) {
            throw new ArenaInvalidException(5);
        } else {
            for (Order order : orders) {
                order.validate();
            }
        }
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }
}
