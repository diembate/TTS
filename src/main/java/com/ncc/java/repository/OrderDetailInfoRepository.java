package com.ncc.java.repository;

import com.ncc.java.domain.OrderDetailInfo;
import com.ncc.java.service.dto.OrderDetailInfoDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the OrderDetailInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderDetailInfoRepository extends JpaRepository<OrderDetailInfo, Long> {

//    @Query(value=" SELECT SUM(quantityOrder)" +
//        "    FROM orderDetailInfo" +
//        "    GROUP BY productId ")

    List<OrderDetailInfo> findAllByProductId(long id);

}

