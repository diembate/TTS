package com.ncc.java.service;

import com.ncc.java.service.dto.ImportInfoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ncc.java.domain.ImportInfo}.
 */
public interface ImportInfoService {

    /**
     * Save a importInfo.
     *
     * @param importInfoDTO the entity to save.
     * @return the persisted entity.
     */
    ImportInfoDTO save(ImportInfoDTO importInfoDTO);

    /**
     * Get all the importInfos.
     *
     * @return the list of entities.
     */
    List<ImportInfoDTO> findAll();


    /**
     * Get the "id" importInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImportInfoDTO> findOne(Long id);

    /**
     * Delete the "id" importInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
