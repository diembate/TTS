package com.ncc.java.service.dto;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.ncc.java.domain.Report} entity.
 */
public class ReportDTO implements Serializable {

    private Long id;

    private String productName;

    private Integer quantityRemaining;

    private Integer orderQuantityOfProduct;

    private Set<ProductDTO> productDTOS;

    private Set<OrderDetailInfoDTO> orderDetailInfoDTOS;

    public Set<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(Set<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public Set<OrderDetailInfoDTO> getOrderDetailInfoDTOS() {
        return orderDetailInfoDTOS;
    }

    public void setOrderDetailInfoDTOS(Set<OrderDetailInfoDTO> orderDetailInfoDTOS) {
        this.orderDetailInfoDTOS = orderDetailInfoDTOS;
    }

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

    public Integer getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(Integer quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

    public Integer getOrderQuantityOfProduct() {
        return orderQuantityOfProduct;
    }

    public void setOrderQuantityOfProduct(Integer orderQuantityOfProduct) {
        this.orderQuantityOfProduct = orderQuantityOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReportDTO reportDTO = (ReportDTO) o;
        if (reportDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reportDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
//

        @Override
    public String toString() {
        return "ReportDTO{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", quantityRemaining=" + getQuantityRemaining() +
            ", orderQuantityOfProduct=" + getOrderQuantityOfProduct() +
            "}";
    }
}
