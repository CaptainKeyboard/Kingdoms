package net.velion.arena.builder.builders.stagingBuilder;

import net.velion.arena.Arena;
import net.velion.arena.builder.builders.orderBuilder.GlobalOrderBuilder;
import net.velion.arena.builder.builders.orderBuilder.OrderListBuilder;
import net.velion.arena.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StageBuilder {
    private String name;
    private GlobalOrderBuilder globalOrderBuilder;
    private List<OrderListBuilder> orderListBuilders;

    public StageBuilder(String name) {
        this.name = name;
        orderListBuilders = new ArrayList<>();
    }

    public StageBuilder setGlobalOrder(GlobalOrderBuilder globalOrder) {
        this.globalOrderBuilder = globalOrder;
        return this;
    }

    public Stage build(Arena arena) {
        Stage stage = new Stage(name, arena);
        stage.setGlobalOrder(globalOrderBuilder.build(arena));
        for (OrderListBuilder orderListBuilder : orderListBuilders) {
            stage.setOrderList(orderListBuilder.build(arena));
        }
        return stage;
    }

    public StageBuilder setOrderLists(OrderListBuilder... orderLists) {
        this.orderListBuilders = Arrays.asList(orderLists);
        return this;
    }
}
