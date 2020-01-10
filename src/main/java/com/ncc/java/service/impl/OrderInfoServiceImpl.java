package com.ncc.java.service.impl;

import com.ncc.java.service.OrderInfoService;
import com.ncc.java.domain.OrderInfo;
import com.ncc.java.repository.OrderInfoRepository;
import com.ncc.java.service.dto.OrderInfoDTO;
import com.ncc.java.service.mapper.OrderInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link OrderInfo}.
 */
@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService {

    private final Logger log = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    private final OrderInfoRepository orderInfoRepository;

    private final OrderInfoMapper orderInfoMapper;

    public OrderInfoServiceImpl(OrderInfoRepository orderInfoRepository, OrderInfoMapper orderInfoMapper) {
        this.orderInfoRepository = orderInfoRepository;
        this.orderInfoMapper = orderInfoMapper;
    }

    /**
     * Save a orderInfo.
     *
     * @param orderInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OrderInfoDTO save(OrderInfoDTO orderInfoDTO) {
        log.debug("Request to save OrderInfo : {}", orderInfoDTO);
        OrderInfo orderInfo = orderInfoMapper.toEntity(orderInfoDTO);
        orderInfo = orderInfoRepository.save(orderInfo);
        return orderInfoMapper.toDto(orderInfo);
    }

    /**
     * Get all the orderInfos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrderInfoDTO> findAll() {
        log.debug("Request to get all OrderInfos");
        return orderInfoRepository.findAll().stream()
            .map(orderInfoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one orderInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OrderInfoDTO> findOne(Long id) {
        log.debug("Request to get OrderInfo : {}", id);
        return orderInfoRepository.findById(id)
            .map(orderInfoMapper::toDto);
    }

    /**
     * Delete the orderInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OrderInfo : {}", id);
        orderInfoRepository.deleteById(id);
    }
}
