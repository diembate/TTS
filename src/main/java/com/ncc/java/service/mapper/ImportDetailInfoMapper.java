package com.ncc.java.service.mapper;

import com.ncc.java.domain.*;
import com.ncc.java.service.dto.ImportDetailInfoDTO;

import com.ncc.java.service.dto.ReportDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ImportDetailInfo} and its DTO {@link ImportDetailInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {ImportInfoMapper.class, ProductMapper.class})
public interface ImportDetailInfoMapper extends EntityMapper<ImportDetailInfoDTO, ImportDetailInfo> {

    @Mapping(source = "importInfo.id", target = "importInfoId")
    @Mapping(source = "product.id", target = "productId")
    ImportDetailInfoDTO toDto(ImportDetailInfo importDetailInfo);

    @Mapping(source = "importInfoId", target = "importInfo")
    @Mapping(source = "productId", target = "product")
    ImportDetailInfo toEntity(ImportDetailInfoDTO importDetailInfoDTO);



    default ImportDetailInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        ImportDetailInfo importDetailInfo = new ImportDetailInfo();
        importDetailInfo.setId(id);
        return importDetailInfo;
    }
}
