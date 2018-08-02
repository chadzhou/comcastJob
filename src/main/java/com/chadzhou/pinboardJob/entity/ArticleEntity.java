package com.chadzhou.pinboardJob.entity;


import javax.persistence.*;

@Entity
@Table(name = "Article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private PinboardEntity pinboardEntity;

    public PinboardEntity getPinboardEntity() {
        return pinboardEntity;
    }

    public void setPinboardEntity(PinboardEntity pinboardEntity) {
        this.pinboardEntity = pinboardEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    private Integer boardId;
}
