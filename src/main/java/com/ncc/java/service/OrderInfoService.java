package com.ncc.java.service;

import com.ncc.java.service.dto.OrderInfoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ncc.java.domain.OrderInfo}.
 */
public interface OrderInfoService {

    /**
     * Save a orderInfo.
     *
     * @param orderInfoDTO the entity to save.
     * @return the persisted entity.
     */
    OrderInfoDTO save(OrderInfoDTO orderInfoDTO);

    /**
     * Get all the orderInfos.
     *
     * @return the list of entities.
     */
    List<OrderInfoDTO> findAll();


    /**
     * Get the "id" orderInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OrderInfoDTO> findOne(Long id);

    /**
     * Delete the "id" orderInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
