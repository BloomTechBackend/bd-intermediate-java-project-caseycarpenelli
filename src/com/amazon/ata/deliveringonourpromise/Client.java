package com.amazon.ata.deliveringonourpromise;
import com.amazon.ata.deliveringonourpromise.types.Promise;


public interface Client {

    public Promise getPromise(String customerOrderId);
//    List addClients(Clients t);
}
