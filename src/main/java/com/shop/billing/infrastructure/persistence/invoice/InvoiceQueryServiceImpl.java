package com.shop.billing.infrastructure.persistence.invoice;

import com.shop.billing.application.invoice.query.InvoiceOutput;
import com.shop.billing.application.invoice.query.InvoiceQueryService;
import com.shop.billing.application.util.Mapper;
import com.shop.billing.domain.model.invoice.Invoice;
import com.shop.billing.domain.model.invoice.InvoiceNotFoundException;
import com.shop.billing.domain.model.invoice.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InvoiceQueryServiceImpl implements InvoiceQueryService {

    private final InvoiceRepository invoiceRepository;
    private final Mapper mapper;

    @Override
    public InvoiceOutput findByOrderId(String orderId) {
        Invoice invoice = invoiceRepository.findByOrderId(orderId).orElseThrow(InvoiceNotFoundException::new);
        return mapper.convert(invoice, InvoiceOutput.class);
    }
}
