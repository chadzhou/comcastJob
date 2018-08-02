package com.chadzhou.pinboardJob.repository;

import com.chadzhou.pinboardJob.entity.PinboardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PageablePinboardRepository extends PagingAndSortingRepository<PinboardEntity, Integer> {
    Page<PinboardEntity> findById(Integer id, Pageable page);
}
