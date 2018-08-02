package com.chadzhou.pinboardJob.converter;

import com.chadzhou.pinboardJob.entity.ArticleEntity;
import com.chadzhou.pinboardJob.model.response.ArticleResponse;
import org.springframework.core.convert.converter.Converter;

public class ArticleEntityToArticleResponseConverter implements Converter<ArticleEntity, ArticleResponse> {


    @Override
    public ArticleResponse convert(ArticleEntity source) {
        ArticleResponse articleResponse = new ArticleResponse();
        if (source.getId() != null) {
            articleResponse.setId(source.getId());
        }
        return articleResponse;
    }
}
