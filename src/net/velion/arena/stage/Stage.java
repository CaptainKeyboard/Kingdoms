package net.velion.arena.stage;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.order.GlobalOrder;
import net.velion.arena.order.Order;
import net.velion.arena.order.OrderList;
import net.velion.arena.validation.ArenaInvalidException;

public class Stage {
    private final Arena arena;
    private final OrderList orderList;
    private final String name;
    private GlobalOrder globalOrder;

    public Stage(String name, Arena arena) {
        this.name = name;
        this.arena = arena;
        orderList = new OrderList();
        globalOrder = new GlobalOrder();
    }

    public void start() {
        //TODO Implement logger
        System.out.println("Stage: \"" + name + "\" starting");
        orderList.reset();

        for (IArenaEntity entity : arena.getEntities()) {
            orderList.push(globalOrder.copy(entity));
        }
        orderList.deliverAll();
    }

    public void reset() {
        orderList.reset();
    }

    public void setGlobalOrder(GlobalOrder order) {
        globalOrder = order;
    }

    public void addOrder(Order order) {
        orderList.push(order);
    }

    public IArenaEntity check() {
        return orderList.check();
    }

    public void validate() throws ArenaInvalidException {
        if (orderList.isEmpty() && globalOrder == null) {
            throw new ArenaInvalidException(4);
        } else if (!orderList.isEmpty()) {
            orderList.validate();
        }
        if (globalOrder != null) {
            globalOrder.validate();
        }
    }
}
