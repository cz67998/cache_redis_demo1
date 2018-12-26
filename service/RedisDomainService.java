package com.wangzhou.highconcurrent.cache.service;

import com.wangzhou.highconcurrent.cache.domain.RedisDomain;
import com.wangzhou.highconcurrent.cache.vo.RedisDo;

import java.util.List;
import java.util.Optional;

/**
 * Created by IDEA
 * author:wangzhou
 * Data:2018/12/26
 * Time:10:49
 **/
public interface RedisDomainService {
    RedisDomain update(RedisDomain redisDomain);

    List<RedisDo> findAll();

    Optional<RedisDomain> findById(Integer id);

    RedisDomain findByName(String name);
}
