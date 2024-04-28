package com.sunday.invoice_link_generator.service.serviceImpl;

import com.sunday.invoice_link_generator.repository.InvoiceRepository;
import com.sunday.invoice_link_generator.service.InvoiceService;
import com.sunday.invoice_link_generator.vo.InvoiceDataVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepo;
    @Override
    public String generateInvoice(InvoiceDataVo invoiceDataVo) {
        return null;
    }
}
