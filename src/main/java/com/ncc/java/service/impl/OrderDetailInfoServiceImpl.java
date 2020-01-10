package com.ncc.java.service.impl;

import com.ncc.java.domain.Product;
import com.ncc.java.repository.ProductRepository;
import com.ncc.java.service.OrderDetailInfoService;
import com.ncc.java.domain.OrderDetailInfo;
import com.ncc.java.repository.OrderDetailInfoRepository;
import com.ncc.java.service.ProductService;
import com.ncc.java.service.dto.OrderDetailInfoDTO;
import com.ncc.java.service.mapper.OrderDetailInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link OrderDetailInfo}.
 */
@Service
@Transactional
public class OrderDetailInfoServiceImpl implements OrderDetailInfoService {

    private final Logger log = LoggerFactory.getLogger(OrderDetailInfoServiceImpl.class);

    private final OrderDetailInfoRepository orderDetailInfoRepository;

    private final OrderDetailInfoMapper orderDetailInfoMapper;

    public OrderDetailInfoServiceImpl(OrderDetailInfoRepository orderDetailInfoRepository, OrderDetailInfoMapper orderDetailInfoMapper) {
        this.orderDetailInfoRepository = orderDetailInfoRepository;
        this.orderDetailInfoMapper = orderDetailInfoMapper;
    }
@Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    /**
     * Save a orderDetailInfo.
     *
     * @param orderDetailInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OrderDetailInfoDTO save(OrderDetailInfoDTO orderDetailInfoDTO) {
        log.debug("Request to save OrderDetailInfo : {}", orderDetailInfoDTO);
        OrderDetailInfo orderDetailInfo = orderDetailInfoMapper.toEntity(orderDetailInfoDTO);
        Product productOrder = productRepository.findOneById(orderDetailInfoDTO.getProductId());
        orderDetailInfo.setProduct(productOrder);

        Product product = orderDetailInfo.getProduct();

        BigDecimal itemCost  = BigDecimal.ZERO;
        itemCost  = product.getPriceProduct().multiply(new BigDecimal(orderDetailInfo.getQuantityOrder()));
        orderDetailInfo.setPriceProduct(product.getPriceProduct());
        orderDetailInfo.setAmount(itemCost);

        orderDetailInfo.setProductName(product.getProductName());

        Date now = Calendar.getInstance().getTime();
        Instant instant = Instant.ofEpochMilli(now.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        orderDetailInfo.setOrderDate(localDate);

        orderDetailInfo = orderDetailInfoRepository.save(orderDetailInfo);

        productService.orderDetailBill(orderDetailInfo);

        return orderDetailInfoMapper.toDto(orderDetailInfo);

    }

    /**
     * Get all the orderDetailInfos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrderDetailInfoDTO> findAll() {
        log.debug("Request to get all OrderDetailInfos");
        return orderDetailInfoRepository.findAll().stream()
            .map(orderDetailInfoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }




    /**
     * Get one orderDetailInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDetailInfoDTO> findOne(Long id) {
        log.debug("Request to get OrderDetailInfo : {}", id);
        return orderDetailInfoRepository.findById(id)
            .map(orderDetailInfoMapper::toDto);
    }



    /**
     * Delete the orderDetailInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OrderDetailInfo : {}", id);
        orderDetailInfoRepository.deleteById(id);
    }
}
