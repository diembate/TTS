package com.ncc.java.web.rest;

import com.ncc.java.service.ImportInfoService;
import com.ncc.java.web.rest.errors.BadRequestAlertException;
import com.ncc.java.service.dto.ImportInfoDTO;

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
 * REST controller for managing {@link com.ncc.java.domain.ImportInfo}.
 */
@RestController
@RequestMapping("/api")
public class ImportInfoResource {

    private final Logger log = LoggerFactory.getLogger(ImportInfoResource.class);

    private static final String ENTITY_NAME = "importInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImportInfoService importInfoService;

    public ImportInfoResource(ImportInfoService importInfoService) {
        this.importInfoService = importInfoService;
    }

    /**
     * {@code POST  /import-infos} : Create a new importInfo.
     *
     * @param importInfoDTO the importInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new importInfoDTO, or with status {@code 400 (Bad Request)} if the importInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/import-infos")
    public ResponseEntity<ImportInfoDTO> createImportInfo(@RequestBody ImportInfoDTO importInfoDTO) throws URISyntaxException {
        log.debug("REST request to save ImportInfo : {}", importInfoDTO);
        if (importInfoDTO.getId() != null) {
            throw new BadRequestAlertException("A new importInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ImportInfoDTO result = importInfoService.save(importInfoDTO);
        return ResponseEntity.created(new URI("/api/import-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /import-infos} : Updates an existing importInfo.
     *
     * @param importInfoDTO the importInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importInfoDTO,
     * or with status {@code 400 (Bad Request)} if the importInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the importInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/import-infos")
    public ResponseEntity<ImportInfoDTO> updateImportInfo(@RequestBody ImportInfoDTO importInfoDTO) throws URISyntaxException {
        log.debug("REST request to update ImportInfo : {}", importInfoDTO);
        if (importInfoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ImportInfoDTO result = importInfoService.save(importInfoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importInfoDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /import-infos} : get all the importInfos.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of importInfos in body.
     */
    @GetMapping("/import-infos")
    public List<ImportInfoDTO> getAllImportInfos() {
        log.debug("REST request to get all ImportInfos");
        return importInfoService.findAll();
    }

    /**
     * {@code GET  /import-infos/:id} : get the "id" importInfo.
     *
     * @param id the id of the importInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the importInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/import-infos/{id}")
    public ResponseEntity<ImportInfoDTO> getImportInfo(@PathVariable Long id) {
        log.debug("REST request to get ImportInfo : {}", id);
        Optional<ImportInfoDTO> importInfoDTO = importInfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(importInfoDTO);
    }

    /**
     * {@code DELETE  /import-infos/:id} : delete the "id" importInfo.
     *
     * @param id the id of the importInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/import-infos/{id}")
    public ResponseEntity<Void> deleteImportInfo(@PathVariable Long id) {
        log.debug("REST request to delete ImportInfo : {}", id);
        importInfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
