package com.sunday.invoice_link_generator.repository;

import com.sunday.invoice_link_generator.model.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {

    Optional<Invoice> findByDocUuid(String docUuid);
}
