package com.amazon.ata.deliveringonourpromise.comparators;

import com.amazon.ata.deliveringonourpromise.types.OrderItem;

import java.util.Comparator;

public class OrderItemComparator implements Comparator<OrderItem> {

    @Override
    public int compare(OrderItem o1, OrderItem o2) {
        return o1.getAsin().compareTo(o2.getAsin());
    }

}
