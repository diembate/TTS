package com.ncc.java.service.mapper;

import com.ncc.java.domain.*;
import com.ncc.java.service.dto.ImportInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ImportInfo} and its DTO {@link ImportInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ImportInfoMapper extends EntityMapper<ImportInfoDTO, ImportInfo> {


    @Mapping(target = "importDetailInfos", ignore = true)
    @Mapping(target = "removeImportDetailInfo", ignore = true)
    ImportInfo toEntity(ImportInfoDTO importInfoDTO);

    default ImportInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        ImportInfo importInfo = new ImportInfo();
        importInfo.setId(id);
        return importInfo;
    }
}
