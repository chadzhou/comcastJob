package com.chadzhou.pinboardJob.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pinboard")
public class PinboardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String pinboardId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ArticleEntity> articleEntityList;

    public Integer getId() {
        return id;
    }

    public String getPinboardId() {
        return pinboardId;
    }

    public List<ArticleEntity> getArticleEntityList() {
        return articleEntityList;
    }

    public void setArticleEntityList(List<ArticleEntity> articleEntityList) {
        this.articleEntityList = articleEntityList;
    }

    public void setPinboardId(String pinboardId) {
        this.pinboardId = pinboardId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PinboardEntity() {
    }
    public PinboardEntity(String pinboardId) {
        this.pinboardId = pinboardId;
    }


    public void addArticleEntity(ArticleEntity articleEntity) {
        if(articleEntityList == null) {
            articleEntityList = new ArrayList<>();
        }
        articleEntityList.add(articleEntity);
    }

}
