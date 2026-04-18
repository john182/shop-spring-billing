package com.shop.billing.infrastructure.listener;

import com.shop.billing.domain.model.invoice.InvoiceCanceledEvent;
import com.shop.billing.domain.model.invoice.InvoiceIssuedEvent;
import com.shop.billing.domain.model.invoice.InvoicePaidEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InvoiceEventListener {

    @EventListener
    public void listen(InvoiceIssuedEvent event) {

    }

    @EventListener
    public void listen(InvoiceCanceledEvent event) {

    }

    @EventListener
    public void listen(InvoicePaidEvent event) {

    }

}
