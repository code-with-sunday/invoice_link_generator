package com.sunday.invoice_link_generator.service;

import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public interface JasperReportExporterService {

    byte[] generatePdfFromJson(String jsonData) throws JRException, IOException;

    byte[] generateHtmlFromJson(String jsonData) throws JRException, IOException;

    byte[] generateXlsFromJson(String jsonData) throws JRException, IOException;

    byte[] generateXlsxFromJson(String jsonData) throws JRException, IOException;

    byte[] generateCsvFromJson(String jsonData) throws JRException, IOException;
}
