package com.sunday.invoice_link_generator.vo;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceDataVo {
    private String buyer;
    private String buyerAddress;
    private String buyerGstin;
    private List<Item> items;
    private String seller;
    private String sellerAddress;
    private String sellerGstin;
}
