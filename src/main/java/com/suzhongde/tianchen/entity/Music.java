package com.suzhongde.tianchen.entity;

import com.suzhongde.tianchen.enums.MusicStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@Data
public class Music extends AbstractEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    private String description;

    @OneToOne
    private File file;
}