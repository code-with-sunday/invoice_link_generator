package com.sunday.invoice_link_generator.model;

import com.sunday.invoice_link_generator.exception.InvalidDisplayFormatException;
import com.sunday.invoice_link_generator.model.enums.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "invoice_table")
public class Invoice extends Base{
    @Column(name = "sha_key", length = 64, nullable = false)
    private String shaKey;

    @Column(name = "docUuid", length = 36, nullable = false)
    private String docUuid;

    @Column(name = "json_data", nullable = false)
    private String jsonData;

    @Column(name = "html_exists")
    private boolean htmlExists;

    @Column(name = "xls_exists")
    private boolean xlsExists;

    @Column(name = "xlsx_exists")
    private boolean xlsxExists;

    @Column(name = "csv_exists")
    private boolean csvExists;

    @Enumerated(EnumType.STRING)
    @Column(name= "payment_status")
    private PaymentStatus payment_status;

    public boolean hasDisplayFormat(String displayFormat) throws Exception {
        switch (displayFormat.toLowerCase()) {
            case "pdf":
                return true;
            case "html":
                return htmlExists;
            case "xls":
                return xlsExists;
            case "xlsx":
                return xlsxExists;
            case "csv":
                return csvExists;
            default:
                throw new InvalidDisplayFormatException("Invalid display format!");
        }
    }
    public void setDisplayFormat(String displayFormat) throws Exception {
        switch (displayFormat.toLowerCase()) {
            case "pdf":
                // No need to set anything, always true for all invoices
                break;
            case "html":
                htmlExists = true;
                break;
            case "xls":
                xlsExists = true;
                break;
            case "xlsx":
                xlsxExists = true;
                break;
            case "csv":
                csvExists = true;
                break;
            default:
                throw new InvalidDisplayFormatException("Invalid display format!");
        }
    }

    public Invoice(String shaKey,String docUuid, String jsonData) {
        this.shaKey= shaKey;
        this.docUuid = docUuid;
        this.jsonData = jsonData;
    }


}
