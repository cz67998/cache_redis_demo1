package com.wangzhou.highconcurrent.cache.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by IDEA
 * author:wangzhou
 * Data:2018/12/26
 * Time:12:18
 **/
@Data
public class RedisDo implements Serializable{

    private static final long serialVersionUID = 1780731002220192639L;
    private int id;
    private String name;
    private String age;
    private Date time;
}
