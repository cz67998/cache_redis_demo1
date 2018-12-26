package com.wangzhou.highconcurrent.cache.domain;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;


/**
 * Created by IDEA
 * author:wangzhou
 * Data:2018/12/26
 * Time:10:31
 **/
@Entity
@Data
public class RedisDomain implements Serializable{

    private static final long serialVersionUID = -5967159355341565133L;
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String age;
    private Date time;
}
