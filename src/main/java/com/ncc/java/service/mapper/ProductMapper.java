package com.ncc.java.service.mapper;

import com.ncc.java.domain.*;
import com.ncc.java.service.dto.ProductDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class, BrandMapper.class, ReportMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "report.id", target = "reportId")
    ProductDTO toDto(Product product);

    @Mapping(source = "categoryId", target = "category")
    @Mapping(source = "brandId", target = "brand")
    @Mapping(source = "reportId", target = "report")
    Product toEntity(ProductDTO productDTO);

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
