package com.wangzhou.highconcurrent.cache.vo;

import com.wangzhou.highconcurrent.cache.domain.RedisDomain;
import lombok.Data;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by IDEA
 * author:wangzhou
 * Data:2018/12/26
 * Time:12:06
 **/
@Data
public class RedisDomainVO implements Serializable{

    private static final long serialVersionUID = 7334462148674296713L;
    private String code;
    private String discrible;
    private List<RedisDo> redisDomainList;
}
