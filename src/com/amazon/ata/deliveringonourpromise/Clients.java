package com.amazon.ata.deliveringonourpromise;
import com.amazon.ata.deliveringonourpromise.types.Promise;

import java.util.ArrayList;
import java.util.List;

public interface Clients {

    public Promise getClients(String customerOrderId);
//    List addClients(Clients t);
}
