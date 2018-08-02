package com.chadzhou.pinboardJob.converter;

import com.chadzhou.pinboardJob.entity.ArticleEntity;
import com.chadzhou.pinboardJob.model.request.ArticleRequest;
import org.springframework.core.convert.converter.Converter;

import java.lang.annotation.Annotation;

public class ArticleRequestToArticleEntityConverter implements Converter<ArticleRequest, ArticleEntity> {

    @Override
    public ArticleEntity convert(ArticleRequest source) {
        ArticleEntity articleEntity = new ArticleEntity();
        if(source.getId() != null) {
            articleEntity.setId(source.getId());
        }
        return articleEntity;
    }
}
