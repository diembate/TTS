package com.ncc.java.service.dto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.ncc.java.domain.ImportInfo} entity.
 */
public class ImportInfoDTO implements Serializable {

    private Long id;

    private String deliverPerson;

    private String supplier;

    private BigDecimal cost;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliverPerson() {
        return deliverPerson;
    }

    public void setDeliverPerson(String deliverPerson) {
        this.deliverPerson = deliverPerson;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ImportInfoDTO importInfoDTO = (ImportInfoDTO) o;
        if (importInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), importInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ImportInfoDTO{" +
            "id=" + getId() +
            ", deliverPerson='" + getDeliverPerson() + "'" +
            ", supplier='" + getSupplier() + "'" +
            ", cost=" + getCost() +
            "}";
    }
}
