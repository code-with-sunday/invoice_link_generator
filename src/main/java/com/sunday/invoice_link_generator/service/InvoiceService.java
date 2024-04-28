package com.sunday.invoice_link_generator.service;

import com.sunday.invoice_link_generator.vo.InvoiceDataVo;

public interface InvoiceService {

    String generateInvoice(InvoiceDataVo invoiceDataVo);
}
