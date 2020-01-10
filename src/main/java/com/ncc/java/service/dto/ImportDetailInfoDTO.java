package com.ncc.java.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.ncc.java.domain.ImportDetailInfo} entity.
 */
public class ImportDetailInfoDTO implements Serializable {

    private Long id;

    private String productName;

    private Integer quantityImport;

    private LocalDate importDate;

    private BigDecimal priceImport;


    private Long importInfoId;

    private Long productId;

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

    public Integer getQuantityImport() {
        return quantityImport;
    }

    public void setQuantityImport(Integer quantityImport) {
        this.quantityImport = quantityImport;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public BigDecimal getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(BigDecimal priceImport) {
        this.priceImport = priceImport;
    }

    public Long getImportInfoId() {
        return importInfoId;
    }

    public void setImportInfoId(Long importInfoId) {
        this.importInfoId = importInfoId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ImportDetailInfoDTO importDetailInfoDTO = (ImportDetailInfoDTO) o;
        if (importDetailInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), importDetailInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ImportDetailInfoDTO{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", quantityImport=" + getQuantityImport() +
            ", importDate='" + getImportDate() + "'" +
            ", priceImport=" + getPriceImport() +
            ", importInfoId=" + getImportInfoId() +
            ", productId=" + getProductId() +
            "}";
    }
}
