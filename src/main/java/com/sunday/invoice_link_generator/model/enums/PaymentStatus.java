package com.sunday.invoice_link_generator.model.enums;

public enum PaymentStatus {
    PENDING(1),
    PAID(2),
    OVERDUE(3),
    PARTIALLY_PAID(4),
    REFUNDED(5),
    FAILED(6),
    PROCESSING(7),
    CANCELLED(8);
    int statusId;

    PaymentStatus(int paymentStatusId) {
        this.statusId = paymentStatusId;
    }

    public int getStatusId(){
        return statusId;
    }

}
