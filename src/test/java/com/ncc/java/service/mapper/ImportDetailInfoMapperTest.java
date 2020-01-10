package com.ncc.java.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ImportDetailInfoMapperTest {

    private ImportDetailInfoMapper importDetailInfoMapper;

    @BeforeEach
    public void setUp() {
        importDetailInfoMapper = new ImportDetailInfoMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(importDetailInfoMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(importDetailInfoMapper.fromId(null)).isNull();
    }
}
