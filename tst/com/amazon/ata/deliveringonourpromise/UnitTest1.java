package com.amazon.ata.deliveringonourpromise;

import com.amazon.ata.deliveringonourpromise.dao.ReadOnlyDao;
import com.amazon.ata.deliveringonourpromise.types.Order;
import com.amazon.ata.deliveringonourpromise.types.OrderItem;
import com.amazon.ata.deliveringonourpromise.types.Promise;
import com.amazon.ata.deliveringonourpromise.types.PromiseHistory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class UnitTest1 {
        private final String OrderIdM = "900-3746401-0000003";

        private ReadOnlyDao<String, Order> orderDao;
        Order order = orderDao.get(OrderIdM);
        private ReadOnlyDao<String, List<Promise>> promiseDao;
    @Test
    public void nullPointerException_inGetPromiseHistoryByOrderIdActivity() {

        if (order == null) {
            fail("order should not be null");
        }
        List<OrderItem> customerOrderItems = order.getCustomerOrderItemList();
        OrderItem customerOrderItem = null;
        PromiseHistory history = new PromiseHistory(order);
        if (customerOrderItem != null) {
            List<Promise> promises = promiseDao.get(customerOrderItem.getCustomerOrderItemId());
            for (Promise promise : promises) {
                promise.setConfidence(customerOrderItem.isConfidenceTracked(), customerOrderItem.getConfidence());
                history.addPromise(promise);
            }
        }
    }
}
