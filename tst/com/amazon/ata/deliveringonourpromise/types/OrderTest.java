package com.amazon.ata.deliveringonourpromise.types;

import com.amazon.ata.ordermanipulationauthority.OrderCondition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class OrderTest {

    Order.Builder order = new Order.Builder();


    @Test
    public void testSecurity_forOrderClass() {
        // GIVEN
        OrderItem customerOrderItem = OrderItem.builder()
                .withCustomerOrderItemId("1")
                .build();

        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(customerOrderItem);

        Order order = Order.builder()
                .withCustomerOrderItemList(orderItemList)
                .build();

        String maliciousCustomerOrderItemId = "2";
        OrderItem maliciousCustomerOrderItem = OrderItem.builder()
                .withCustomerOrderItemId(maliciousCustomerOrderItemId)
                .build();

        // WHEN
        List<OrderItem> customerOrderItemList = order.getCustomerOrderItemList();
        try {
            customerOrderItemList.remove(0);
        } catch (UnsupportedOperationException e) {
        }

        try {
            customerOrderItemList.add(maliciousCustomerOrderItem);
        } catch (UnsupportedOperationException e) {
            // exception acceptable if list unmodified
        }
        // THEN
        assertEquals(
                order.getCustomerOrderItemList().size(),
                1,
                "Expected only original OrderItem to exist in Order, but found: " + order.getCustomerOrderItemList()
        );
        String orderItemId = order.getCustomerOrderItemList().get(0).getCustomerOrderItemId();
        assertNotEquals(orderItemId, maliciousCustomerOrderItemId,
                "Expected Order class to not allow item to be maliciously inserted but it was!");
    }

}
