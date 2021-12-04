package br.com.bsi.pi.ticketsbsi.entities.dto;

import java.util.Date;

public interface DashboardDTO {
    Long getProductId();
    Integer getTotalTickets();
    Double getTotalValue();
    String getName();
    String getAddress();
    Date getDateShow();
    Integer getTotalOrder();
}