package com.wangzhou.highconcurrent.cache.service.impl;

import com.wangzhou.highconcurrent.cache.domain.RedisDomain;
import com.wangzhou.highconcurrent.cache.repository.RedisDomainRepository;
import com.wangzhou.highconcurrent.cache.service.RedisDomainService;
import com.wangzhou.highconcurrent.cache.vo.RedisDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IDEA
 * author:wangzhou
 * Data:2018/12/26
 * Time:10:52
 **/
@Service
//统一配置cacheNames
//@CacheConfig(cacheNames = "order")
public class RedisDomainServiceImpl  implements RedisDomainService{
    @Autowired
    private RedisDomainRepository redisDomainRepository;
    @Override
    //key不填默认为方法的形参
    @CachePut(cacheNames = "order",key = "123")
    public  RedisDomain update(RedisDomain redisDomain) {
       return redisDomainRepository.save(redisDomain);
    }


    @Cacheable(cacheNames = "order",key = "123")
    @Override
    public RedisDomain findByName(String name) {
        return redisDomainRepository.findTopByName(name);
    }
    @Override
    public List<RedisDo> findAll() {
        List<RedisDo>  redisDoList= redisDomainRepository.findAll().stream().map(redisDomain -> {
            RedisDo redisDo=new RedisDo();
            BeanUtils.copyProperties(redisDomain,redisDo );
            return redisDo;
        }).collect(Collectors.toList());
        return redisDoList;
    }

    @Override
    public Optional<RedisDomain> findById(Integer id) {
        return redisDomainRepository.findById(id);
    }




}
