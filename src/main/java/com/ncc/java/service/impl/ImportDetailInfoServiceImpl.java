package com.ncc.java.service.impl;

import com.ncc.java.domain.Product;
import com.ncc.java.repository.ProductRepository;
import com.ncc.java.service.ImportDetailInfoService;
import com.ncc.java.domain.ImportDetailInfo;
import com.ncc.java.repository.ImportDetailInfoRepository;
import com.ncc.java.service.ProductService;
import com.ncc.java.service.dto.ImportDetailInfoDTO;
import com.ncc.java.service.mapper.ImportDetailInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ImportDetailInfo}.
 */
@Service
@Transactional
public class ImportDetailInfoServiceImpl implements ImportDetailInfoService {

    private final Logger log = LoggerFactory.getLogger(ImportDetailInfoServiceImpl.class);

    private final ImportDetailInfoRepository importDetailInfoRepository;

    private final ImportDetailInfoMapper importDetailInfoMapper;

    public ImportDetailInfoServiceImpl(ImportDetailInfoRepository importDetailInfoRepository, ImportDetailInfoMapper importDetailInfoMapper) {
        this.importDetailInfoRepository = importDetailInfoRepository;
        this.importDetailInfoMapper = importDetailInfoMapper;


    }
@Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    /**
     * Save a importDetailInfo.
     *
     * @param importDetailInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ImportDetailInfoDTO save(ImportDetailInfoDTO importDetailInfoDTO) {
        log.debug("Request to save ImportDetailInfo : {}", importDetailInfoDTO);
        ImportDetailInfo importDetailInfo = importDetailInfoMapper.toEntity(importDetailInfoDTO);
        Product productOrder =productRepository.findOneById(importDetailInfoDTO.getProductId());
        importDetailInfo.setProduct(productOrder);

        Product product = importDetailInfo.getProduct();

        importDetailInfo.setProductName(product.getProductName());

        Date now = Calendar.getInstance().getTime();
        Instant instant = Instant.ofEpochMilli(now.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        importDetailInfo.setImportDate(localDate);

        importDetailInfo = importDetailInfoRepository.save(importDetailInfo);
        productService.importDetailBill(importDetailInfo);

        return importDetailInfoMapper.toDto(importDetailInfo);
    }

    /**
     * Get all the importDetailInfos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ImportDetailInfoDTO> findAll() {
        log.debug("Request to get all ImportDetailInfos");
        return importDetailInfoRepository.findAll().stream()
            .map(importDetailInfoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one importDetailInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ImportDetailInfoDTO> findOne(Long id) {
        log.debug("Request to get ImportDetailInfo : {}", id);
        return importDetailInfoRepository.findById(id)
            .map(importDetailInfoMapper::toDto);
    }

    /**
     * Delete the importDetailInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ImportDetailInfo : {}", id);
        importDetailInfoRepository.deleteById(id);
    }


}
