package com.ncc.java.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ncc.java.web.rest.TestUtil;

public class ImportInfoDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImportInfoDTO.class);
        ImportInfoDTO importInfoDTO1 = new ImportInfoDTO();
        importInfoDTO1.setId(1L);
        ImportInfoDTO importInfoDTO2 = new ImportInfoDTO();
        assertThat(importInfoDTO1).isNotEqualTo(importInfoDTO2);
        importInfoDTO2.setId(importInfoDTO1.getId());
        assertThat(importInfoDTO1).isEqualTo(importInfoDTO2);
        importInfoDTO2.setId(2L);
        assertThat(importInfoDTO1).isNotEqualTo(importInfoDTO2);
        importInfoDTO1.setId(null);
        assertThat(importInfoDTO1).isNotEqualTo(importInfoDTO2);
    }
}
