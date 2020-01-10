package com.ncc.java.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.ncc.java.domain.Brand} entity.
 */
public class BrandDTO implements Serializable {

    private Long id;

    private String brandName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BrandDTO brandDTO = (BrandDTO) o;
        if (brandDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brandDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
            "id=" + getId() +
            ", brandName='" + getBrandName() + "'" +
            "}";
    }
}
