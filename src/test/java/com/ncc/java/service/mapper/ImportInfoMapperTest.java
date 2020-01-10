package com.ncc.java.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ImportInfoMapperTest {

    private ImportInfoMapper importInfoMapper;

    @BeforeEach
    public void setUp() {
        importInfoMapper = new ImportInfoMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(importInfoMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(importInfoMapper.fromId(null)).isNull();
    }
}
