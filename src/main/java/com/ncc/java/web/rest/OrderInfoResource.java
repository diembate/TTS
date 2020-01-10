package com.ncc.java.web.rest;

import com.ncc.java.service.OrderInfoService;
import com.ncc.java.web.rest.errors.BadRequestAlertException;
import com.ncc.java.service.dto.OrderInfoDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.ncc.java.domain.OrderInfo}.
 */
@RestController
@RequestMapping("/api")
public class OrderInfoResource {

    private final Logger log = LoggerFactory.getLogger(OrderInfoResource.class);

    private static final String ENTITY_NAME = "orderInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OrderInfoService orderInfoService;

    public OrderInfoResource(OrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

    /**
     * {@code POST  /order-infos} : Create a new orderInfo.
     *
     * @param orderInfoDTO the orderInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new orderInfoDTO, or with status {@code 400 (Bad Request)} if the orderInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/order-infos")
    public ResponseEntity<OrderInfoDTO> createOrderInfo(@RequestBody OrderInfoDTO orderInfoDTO) throws URISyntaxException {
        log.debug("REST request to save OrderInfo : {}", orderInfoDTO);
        if (orderInfoDTO.getId() != null) {
            throw new BadRequestAlertException("A new orderInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OrderInfoDTO result = orderInfoService.save(orderInfoDTO);
        return ResponseEntity.created(new URI("/api/order-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /order-infos} : Updates an existing orderInfo.
     *
     * @param orderInfoDTO the orderInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated orderInfoDTO,
     * or with status {@code 400 (Bad Request)} if the orderInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the orderInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/order-infos")
    public ResponseEntity<OrderInfoDTO> updateOrderInfo(@RequestBody OrderInfoDTO orderInfoDTO) throws URISyntaxException {
        log.debug("REST request to update OrderInfo : {}", orderInfoDTO);
        if (orderInfoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OrderInfoDTO result = orderInfoService.save(orderInfoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, orderInfoDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /order-infos} : get all the orderInfos.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of orderInfos in body.
     */
    @GetMapping("/order-infos")
    public List<OrderInfoDTO> getAllOrderInfos() {
        log.debug("REST request to get all OrderInfos");
        return orderInfoService.findAll();
    }

    /**
     * {@code GET  /order-infos/:id} : get the "id" orderInfo.
     *
     * @param id the id of the orderInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the orderInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/order-infos/{id}")
    public ResponseEntity<OrderInfoDTO> getOrderInfo(@PathVariable Long id) {
        log.debug("REST request to get OrderInfo : {}", id);
        Optional<OrderInfoDTO> orderInfoDTO = orderInfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(orderInfoDTO);
    }

    /**
     * {@code DELETE  /order-infos/:id} : delete the "id" orderInfo.
     *
     * @param id the id of the orderInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/order-infos/{id}")
    public ResponseEntity<Void> deleteOrderInfo(@PathVariable Long id) {
        log.debug("REST request to delete OrderInfo : {}", id);
        orderInfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
