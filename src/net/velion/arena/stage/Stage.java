package net.velion.arena.stage;

import net.velion.arena.order.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franz Kohout
 */
public class Stage {
    protected List<Order> orders;

    public Stage() {
        orders = new ArrayList<>();
    }

    public void start() {

    }

    public void reset() {
        for(Order order: orders) {
            order.reset();
        }
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
