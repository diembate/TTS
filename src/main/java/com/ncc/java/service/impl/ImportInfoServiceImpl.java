package com.ncc.java.service.impl;

import com.ncc.java.service.ImportInfoService;
import com.ncc.java.domain.ImportInfo;
import com.ncc.java.repository.ImportInfoRepository;
import com.ncc.java.service.dto.ImportInfoDTO;
import com.ncc.java.service.mapper.ImportInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ImportInfo}.
 */
@Service
@Transactional
public class ImportInfoServiceImpl implements ImportInfoService {

    private final Logger log = LoggerFactory.getLogger(ImportInfoServiceImpl.class);

    private final ImportInfoRepository importInfoRepository;

    private final ImportInfoMapper importInfoMapper;

    public ImportInfoServiceImpl(ImportInfoRepository importInfoRepository, ImportInfoMapper importInfoMapper) {
        this.importInfoRepository = importInfoRepository;
        this.importInfoMapper = importInfoMapper;
    }

    /**
     * Save a importInfo.
     *
     * @param importInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ImportInfoDTO save(ImportInfoDTO importInfoDTO) {
        log.debug("Request to save ImportInfo : {}", importInfoDTO);
        ImportInfo importInfo = importInfoMapper.toEntity(importInfoDTO);
        importInfo = importInfoRepository.save(importInfo);
        return importInfoMapper.toDto(importInfo);
    }

    /**
     * Get all the importInfos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ImportInfoDTO> findAll() {
        log.debug("Request to get all ImportInfos");
        return importInfoRepository.findAll().stream()
            .map(importInfoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one importInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ImportInfoDTO> findOne(Long id) {
        log.debug("Request to get ImportInfo : {}", id);
        return importInfoRepository.findById(id)
            .map(importInfoMapper::toDto);
    }

    /**
     * Delete the importInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ImportInfo : {}", id);
        importInfoRepository.deleteById(id);
    }
}
