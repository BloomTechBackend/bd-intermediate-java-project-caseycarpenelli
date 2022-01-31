package com.amazon.ata.deliveringonourpromise.orderfulfillmentservice;

import com.amazon.ata.deliveringonourpromise.Client;
import com.amazon.ata.deliveringonourpromise.data.OrderDatastore;
import com.amazon.ata.deliverypromiseservice.service.DeliveryPromise;
import com.amazon.ata.deliverypromiseservice.service.DeliveryPromiseService;
import com.amazon.ata.deliveringonourpromise.types.Promise;


public class OrderFulfillmentServiceClient implements Client {
    private OrderDatastore orderDatastore;
    private OrderFulfillmentService ofs;




    public OrderFulfillmentServiceClient(OrderFulfillmentService orderFulfillmentService) {
        this.ofs = orderFulfillmentService;
    }


    public Promise getPromise(String customerOrderItemId) {
        OrderPromise orderPromise = ofs.getOrderPromise(customerOrderItemId);
        if (null == orderPromise) {
            return null;
        }

        return Promise.builder()
                .withPromiseLatestArrivalDate(orderPromise.getPromiseLatestArrivalDate())
                .withCustomerOrderItemId(orderPromise.getCustomerOrderItemId())
                .withPromiseLatestShipDate(orderPromise.getPromiseLatestShipDate())
                .withPromiseEffectiveDate(orderPromise.getPromiseEffectiveDate())
                .withPromiseProvidedBy(orderPromise.getPromiseProvidedBy())
                .withAsin(orderPromise.getAsin())
                .withIsActive(orderPromise.isActive())
                .build();
    }




}

