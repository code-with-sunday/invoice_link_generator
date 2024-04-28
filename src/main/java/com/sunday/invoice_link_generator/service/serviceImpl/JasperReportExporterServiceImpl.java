package com.sunday.invoice_link_generator.service.serviceImpl;

import com.sunday.invoice_link_generator.service.JasperReportExporterService;
import com.sunday.invoice_link_generator.utils.JasperReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

@Service
public class JasperReportExporterServiceImpl implements JasperReportExporterService {
    @Autowired
    JasperReportService jasperReportService;

    public byte[] generatePdfFromJson(String jsonData) throws JRException, IOException {
        JasperReport jasperReport =jasperReportService.getJasperReport();

        ByteArrayInputStream jsonDataInputStream = new ByteArrayInputStream(jsonData.getBytes());
        JsonDataSource jsonDataSource = new JsonDataSource(jsonDataInputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), jsonDataSource);
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        return pdfBytes;
    }
    public byte[] generateHtmlFromJson(String jsonData) throws JRException, IOException {
        JasperReport jasperReport = jasperReportService.getJasperReport();

        ByteArrayInputStream jsonDataInputStream = new ByteArrayInputStream(jsonData.getBytes());
        JsonDataSource jsonDataSource = new JsonDataSource(jsonDataInputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), jsonDataSource);

        ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(htmlStream));
        exporter.exportReport();

        return htmlStream.toByteArray();
    }
    public byte[] generateXlsFromJson(String jsonData) throws JRException, IOException {
        JasperReport jasperReport = jasperReportService.getJasperReport();

        ByteArrayInputStream jsonDataInputStream = new ByteArrayInputStream(jsonData.getBytes());
        JsonDataSource jsonDataSource = new JsonDataSource(jsonDataInputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), jsonDataSource);

        ByteArrayOutputStream xlsOutputStream = new ByteArrayOutputStream();
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsOutputStream));
        SimpleXlsReportConfiguration reportConfigXls = new SimpleXlsReportConfiguration();
        reportConfigXls.setSheetNames(new String[] {"Sheet1"});
        reportConfigXls.setDetectCellType(true);
        reportConfigXls.setCollapseRowSpan(false);
        exporter.setConfiguration(reportConfigXls);
        exporter.exportReport();

        return xlsOutputStream.toByteArray();
    }

    public byte[] generateXlsxFromJson(String jsonData) throws JRException, IOException {
        JasperReport jasperReport = jasperReportService.getJasperReport();

        ByteArrayInputStream jsonDataInputStream = new ByteArrayInputStream(jsonData.getBytes());
        JsonDataSource jsonDataSource = new JsonDataSource(jsonDataInputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), jsonDataSource);

        ByteArrayOutputStream xlsxOutputStream = new ByteArrayOutputStream();
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsxOutputStream));
        SimpleXlsxReportConfiguration reportConfigXlsx = new SimpleXlsxReportConfiguration();
        reportConfigXlsx.setSheetNames(new String[] {"Sheet1"});
        reportConfigXlsx.setDetectCellType(true);
        reportConfigXlsx.setCollapseRowSpan(false);
        exporter.setConfiguration(reportConfigXlsx);
        exporter.exportReport();

        return xlsxOutputStream.toByteArray();
    }

    public byte[] generateCsvFromJson(String jsonData) throws JRException, IOException {
        JasperReport jasperReport = jasperReportService.getJasperReport();

        ByteArrayInputStream jsonDataInputStream = new ByteArrayInputStream(jsonData.getBytes());
        JsonDataSource jsonDataSource = new JsonDataSource(jsonDataInputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), jsonDataSource);

        ByteArrayOutputStream csvOutputStream = new ByteArrayOutputStream();
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(csvOutputStream));
        SimpleCsvExporterConfiguration reportConfigCsv = new SimpleCsvExporterConfiguration();
        reportConfigCsv.setFieldDelimiter(",");
        exporter.setConfiguration(reportConfigCsv);
        exporter.exportReport();

        return csvOutputStream.toByteArray();
    }


}
