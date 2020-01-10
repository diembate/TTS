package com.ncc.java.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.ncc.java.domain.OrderDetailInfo} entity.
 */
public class OrderDetailInfoDTO implements Serializable {

    private Long id;

    private String productName;

    private BigDecimal priceProduct;

    private Integer quantityOrder;

    private BigDecimal amount;

    private LocalDate orderDate;


    private Long orderInfoId;

    private Long productId;

    private Long reportId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(BigDecimal priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Integer getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(Integer quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderDetailInfoDTO orderDetailInfoDTO = (OrderDetailInfoDTO) o;
        if (orderDetailInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), orderDetailInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrderDetailInfoDTO{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", priceProduct=" + getPriceProduct() +
            ", quantityOrder=" + getQuantityOrder() +
            ", amount=" + getAmount() +
            ", orderDate='" + getOrderDate() + "'" +
            ", orderInfoId=" + getOrderInfoId() +
            ", productId=" + getProductId() +
            ", reportId=" + getReportId() +
            "}";
    }
}
