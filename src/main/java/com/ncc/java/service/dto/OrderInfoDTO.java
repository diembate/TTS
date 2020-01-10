package com.ncc.java.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.ncc.java.domain.OrderInfo} entity.
 */
public class OrderInfoDTO implements Serializable {

    private Long id;

    private BigDecimal amount;

    private LocalDate orderDate;


    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) o;
        if (orderInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), orderInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrderInfoDTO{" +
            "id=" + getId() +
            ", amount=" + getAmount() +
            ", orderDate='" + getOrderDate() + "'" +
            ", customerId=" + getCustomerId() +
            "}";
    }
}
