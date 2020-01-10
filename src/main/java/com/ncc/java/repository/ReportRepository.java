package com.ncc.java.repository;

import com.ncc.java.domain.Product;
import com.ncc.java.domain.Report;
import com.ncc.java.service.dto.OrderDetailInfoDTO;
import com.ncc.java.service.dto.ProductDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Report entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


}


