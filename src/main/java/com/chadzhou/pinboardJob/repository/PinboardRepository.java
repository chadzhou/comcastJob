package com.chadzhou.pinboardJob.repository;

import com.chadzhou.pinboardJob.entity.PinboardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PinboardRepository extends CrudRepository <PinboardEntity, Integer>{
    PinboardEntity findById(Integer id);

}
