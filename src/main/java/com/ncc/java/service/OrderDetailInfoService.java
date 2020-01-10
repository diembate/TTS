package com.ncc.java.service;

import com.ncc.java.service.dto.OrderDetailInfoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ncc.java.domain.OrderDetailInfo}.
 */
public interface OrderDetailInfoService {

    /**
     * Save a orderDetailInfo.
     *
     * @param orderDetailInfoDTO the entity to save.
     * @return the persisted entity.
     */
    OrderDetailInfoDTO save(OrderDetailInfoDTO orderDetailInfoDTO);

    /**
     * Get all the orderDetailInfos.
     *
     * @return the list of entities.
     */
    List<OrderDetailInfoDTO> findAll();


    /**
     * Get the "id" orderDetailInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OrderDetailInfoDTO> findOne(Long id);

    /**
     * Delete the "id" orderDetailInfo.
     *
     * @param id the id of the entity.
     */


    void delete(Long id);
}
