package com.drinkshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @Column
    @CreatedDate
    private Timestamp createdDate;

    @JsonIgnore
    @Column
    @CreatedBy
    private String createdBy;

    @JsonIgnore
    @Column
    @LastModifiedDate
    private Timestamp modifiedDate;

    @JsonIgnore
    @Column
    @LastModifiedBy
    private String modifiedBy;
}
