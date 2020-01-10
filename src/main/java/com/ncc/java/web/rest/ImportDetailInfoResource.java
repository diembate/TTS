package com.ncc.java.web.rest;

import com.ncc.java.service.ImportDetailInfoService;
import com.ncc.java.web.rest.errors.BadRequestAlertException;
import com.ncc.java.service.dto.ImportDetailInfoDTO;

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
 * REST controller for managing {@link com.ncc.java.domain.ImportDetailInfo}.
 */
@RestController
@RequestMapping("/api")
public class ImportDetailInfoResource {

    private final Logger log = LoggerFactory.getLogger(ImportDetailInfoResource.class);

    private static final String ENTITY_NAME = "importDetailInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImportDetailInfoService importDetailInfoService;

    public ImportDetailInfoResource(ImportDetailInfoService importDetailInfoService) {
        this.importDetailInfoService = importDetailInfoService;
    }

    /**
     * {@code POST  /import-detail-infos} : Create a new importDetailInfo.
     *
     * @param importDetailInfoDTO the importDetailInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new importDetailInfoDTO, or with status {@code 400 (Bad Request)} if the importDetailInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/import-detail-infos")
    public ResponseEntity<ImportDetailInfoDTO> createImportDetailInfo(@RequestBody ImportDetailInfoDTO importDetailInfoDTO) throws URISyntaxException {
        log.debug("REST request to save ImportDetailInfo : {}", importDetailInfoDTO);
        if (importDetailInfoDTO.getId() != null) {
            throw new BadRequestAlertException("A new importDetailInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ImportDetailInfoDTO result = importDetailInfoService.save(importDetailInfoDTO);

        return ResponseEntity.created(new URI("/api/import-detail-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /import-detail-infos} : Updates an existing importDetailInfo.
     *
     * @param importDetailInfoDTO the importDetailInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importDetailInfoDTO,
     * or with status {@code 400 (Bad Request)} if the importDetailInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the importDetailInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/import-detail-infos")
    public ResponseEntity<ImportDetailInfoDTO> updateImportDetailInfo(@RequestBody ImportDetailInfoDTO importDetailInfoDTO) throws URISyntaxException {
        log.debug("REST request to update ImportDetailInfo : {}", importDetailInfoDTO);
        if (importDetailInfoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ImportDetailInfoDTO result = importDetailInfoService.save(importDetailInfoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importDetailInfoDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /import-detail-infos} : get all the importDetailInfos.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of importDetailInfos in body.
     */
    @GetMapping("/import-detail-infos")
    public List<ImportDetailInfoDTO> getAllImportDetailInfos() {
        log.debug("REST request to get all ImportDetailInfos");
        return importDetailInfoService.findAll();
    }

    /**
     * {@code GET  /import-detail-infos/:id} : get the "id" importDetailInfo.
     *
     * @param id the id of the importDetailInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the importDetailInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/import-detail-infos/{id}")
    public ResponseEntity<ImportDetailInfoDTO> getImportDetailInfo(@PathVariable Long id) {
        log.debug("REST request to get ImportDetailInfo : {}", id);
        Optional<ImportDetailInfoDTO> importDetailInfoDTO = importDetailInfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(importDetailInfoDTO);
    }

    /**
     * {@code DELETE  /import-detail-infos/:id} : delete the "id" importDetailInfo.
     *
     * @param id the id of the importDetailInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/import-detail-infos/{id}")
    public ResponseEntity<Void> deleteImportDetailInfo(@PathVariable Long id) {
        log.debug("REST request to delete ImportDetailInfo : {}", id);
        importDetailInfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
