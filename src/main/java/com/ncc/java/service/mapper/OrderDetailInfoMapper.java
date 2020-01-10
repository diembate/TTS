package com.ncc.java.service.mapper;

import com.ncc.java.domain.*;
import com.ncc.java.service.dto.OrderDetailInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrderDetailInfo} and its DTO {@link OrderDetailInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {OrderInfoMapper.class, ProductMapper.class, ReportMapper.class})
public interface OrderDetailInfoMapper extends EntityMapper<OrderDetailInfoDTO, OrderDetailInfo> {

    @Mapping(source = "orderInfo.id", target = "orderInfoId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "report.id", target = "reportId")
    OrderDetailInfoDTO toDto(OrderDetailInfo orderDetailInfo);

    @Mapping(source = "orderInfoId", target = "orderInfo")
    @Mapping(source = "productId", target = "product")
    @Mapping(source = "reportId", target = "report")
    OrderDetailInfo toEntity(OrderDetailInfoDTO orderDetailInfoDTO);

    default OrderDetailInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
        orderDetailInfo.setId(id);
        return orderDetailInfo;
    }
}
