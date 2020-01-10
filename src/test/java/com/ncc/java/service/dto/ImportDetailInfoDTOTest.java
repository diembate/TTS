package com.ncc.java.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ncc.java.web.rest.TestUtil;

public class ImportDetailInfoDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImportDetailInfoDTO.class);
        ImportDetailInfoDTO importDetailInfoDTO1 = new ImportDetailInfoDTO();
        importDetailInfoDTO1.setId(1L);
        ImportDetailInfoDTO importDetailInfoDTO2 = new ImportDetailInfoDTO();
        assertThat(importDetailInfoDTO1).isNotEqualTo(importDetailInfoDTO2);
        importDetailInfoDTO2.setId(importDetailInfoDTO1.getId());
        assertThat(importDetailInfoDTO1).isEqualTo(importDetailInfoDTO2);
        importDetailInfoDTO2.setId(2L);
        assertThat(importDetailInfoDTO1).isNotEqualTo(importDetailInfoDTO2);
        importDetailInfoDTO1.setId(null);
        assertThat(importDetailInfoDTO1).isNotEqualTo(importDetailInfoDTO2);
    }
}
