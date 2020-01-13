package com.ncc.java.service.impl;


import com.ncc.java.domain.OrderDetailInfo;
import com.ncc.java.domain.Product;
import com.ncc.java.repository.OrderDetailInfoRepository;
import com.ncc.java.repository.ProductRepository;
import com.ncc.java.service.ReportService;
import com.ncc.java.domain.Report;
import com.ncc.java.repository.ReportRepository;

import com.ncc.java.service.dto.ReportDTO;
import com.ncc.java.service.mapper.OrderDetailInfoMapper;
import com.ncc.java.service.mapper.ProductMapper;
import com.ncc.java.service.mapper.ReportMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Service Implementation for managing {@link Report}.
 */
@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    private final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

    private final ReportRepository reportRepository;

    private final ReportMapper reportMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    OrderDetailInfoRepository orderDetailInfoRepository;

    @Autowired
    OrderDetailInfoMapper orderDetailInfoMapper;

    public ReportServiceImpl(ReportRepository reportRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
    }


    /**
     * Get one report by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReportDTO> findOne(Long id) {
        log.debug("Request to get Report : {}", id);
        return reportRepository.findById(id)
            .map(reportMapper::toDto);
    }

    @Override
    public List<ReportDTO> getListReport() {
        List<ReportDTO> reportDTOS = new ArrayList<>();
        //list product
        List<Product> products = productRepository.findAll();
        //duyet mang produt
        for (Product product : products) {
            // lay sp co id trung nhau dde tinh total quantity order
            List<OrderDetailInfo> orderDetailInfos = orderDetailInfoRepository.findAllByProductId(product.getId());
            Integer total = 0;
            for (OrderDetailInfo orderDetailInfo : orderDetailInfos) {
                total += orderDetailInfo.getQuantityOrder();
            }
            //tao 1 report
            ReportDTO reportDTO = new ReportDTO();
            //set gt
            reportDTO.setId(product.getId());
            reportDTO.setOrderQuantityOfProduct(total);
            reportDTO.setProductName(product.getProductName());
            reportDTO.setQuantityRemaining(product.getQuantityProduct());
            //add vao list report
            reportDTOS.add(reportDTO);
        }

        return reportDTOS;
    }









    @Override
    public List<ReportDTO> findAll() {
return  null;
    }
}

