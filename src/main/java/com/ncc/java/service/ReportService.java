package com.ncc.java.service;

import com.ncc.java.domain.Product;
import com.ncc.java.service.dto.ProductDTO;
import com.ncc.java.service.dto.ReportDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ncc.java.domain.Report}.
 */
public interface ReportService {


    /**
     * Get all the reports.
     *
     * @return the list of entities.
     */
//    List<ReportDTO> findAll();


    /**
     * Get the "id" report.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReportDTO> findOne(Long id);

    List<ReportDTO> getListReport();
}

