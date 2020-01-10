package com.ncc.java.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ncc.java.web.rest.TestUtil;

public class OrderDetailInfoDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(OrderDetailInfoDTO.class);
        OrderDetailInfoDTO orderDetailInfoDTO1 = new OrderDetailInfoDTO();
        orderDetailInfoDTO1.setId(1L);
        OrderDetailInfoDTO orderDetailInfoDTO2 = new OrderDetailInfoDTO();
        assertThat(orderDetailInfoDTO1).isNotEqualTo(orderDetailInfoDTO2);
        orderDetailInfoDTO2.setId(orderDetailInfoDTO1.getId());
        assertThat(orderDetailInfoDTO1).isEqualTo(orderDetailInfoDTO2);
        orderDetailInfoDTO2.setId(2L);
        assertThat(orderDetailInfoDTO1).isNotEqualTo(orderDetailInfoDTO2);
        orderDetailInfoDTO1.setId(null);
        assertThat(orderDetailInfoDTO1).isNotEqualTo(orderDetailInfoDTO2);
    }
}
