package com.ncc.java.service.mapper;

import com.ncc.java.domain.*;
import com.ncc.java.service.dto.OrderInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrderInfo} and its DTO {@link OrderInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface OrderInfoMapper extends EntityMapper<OrderInfoDTO, OrderInfo> {

    @Mapping(source = "customer.id", target = "customerId")
    OrderInfoDTO toDto(OrderInfo orderInfo);

    @Mapping(source = "customerId", target = "customer")
    @Mapping(target = "orderDetailInfos", ignore = true)
    @Mapping(target = "removeOrderDetailInfo", ignore = true)
    OrderInfo toEntity(OrderInfoDTO orderInfoDTO);

    default OrderInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(id);
        return orderInfo;
    }
}
