package com.ncc.java.service;

import com.ncc.java.service.dto.ImportDetailInfoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ncc.java.domain.ImportDetailInfo}.
 */
public interface ImportDetailInfoService {

    /**
     * Save a importDetailInfo.
     *
     * @param importDetailInfoDTO the entity to save.
     * @return the persisted entity.
     */
    ImportDetailInfoDTO save(ImportDetailInfoDTO importDetailInfoDTO);

    /**
     * Get all the importDetailInfos.
     *
     * @return the list of entities.
     */
    List<ImportDetailInfoDTO> findAll();


    /**
     * Get the "id" importDetailInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImportDetailInfoDTO> findOne(Long id);

    /**
     * Delete the "id" importDetailInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
