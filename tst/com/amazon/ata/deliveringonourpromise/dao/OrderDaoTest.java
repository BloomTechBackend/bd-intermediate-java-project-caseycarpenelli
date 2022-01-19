package com.amazon.ata.deliveringonourpromise.dao;

import com.amazon.ata.deliveringonourpromise.App;
import com.amazon.ata.deliveringonourpromise.ordermanipulationauthority.OrderManipulationAuthorityClient;
import com.amazon.ata.deliveringonourpromise.types.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderDaoTest {


    private OrderManipulationAuthorityClient omaClient = App.getOrderManipulationAuthorityClient();
    private OrderDao dao = new OrderDao(omaClient);

    /*
    get_forKnownOrderId_returnsOrder
Happy case, verifying that the OrderDao can return an order.

Given
An order ID that we know exists
When
We call get() with that order ID
Then
The result is not null
     */
    @Test
    public void get_forKnownOrderId_returnsOrder() {
        //GIVEN
        String orderId = "900-3746401-0000002";

        //WHEN
        Order ordered = dao.get(orderId);

        //THEN
        assertNotNull(ordered, "Expected not null");
    }
    @Test
    public void get_forKnownNullOrderId_returnsOrder() {
        //GIVEN
        String orderId = "000-0000000-000000";

        //WHEN
        Order ordered = dao.get(orderId);

        //THEN
        assertNull(ordered, "Expected Null");

    }
}
