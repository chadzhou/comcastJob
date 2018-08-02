package com.chadzhou.pinboardJob.repository;

import com.chadzhou.pinboardJob.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Integer> {
}
