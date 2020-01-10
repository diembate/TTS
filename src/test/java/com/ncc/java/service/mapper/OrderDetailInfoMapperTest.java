package com.ncc.java.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class OrderDetailInfoMapperTest {

    private OrderDetailInfoMapper orderDetailInfoMapper;

    @BeforeEach
    public void setUp() {
        orderDetailInfoMapper = new OrderDetailInfoMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(orderDetailInfoMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(orderDetailInfoMapper.fromId(null)).isNull();
    }
}
