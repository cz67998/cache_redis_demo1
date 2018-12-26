package com.wangzhou.highconcurrent.cache.repository;

import com.wangzhou.highconcurrent.cache.domain.RedisDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IDEA
 * author:wangzhou
 * Data:2018/12/26
 * Time:10:40
 **/
public interface RedisDomainRepository  extends JpaRepository<RedisDomain,Integer> {
    Optional<RedisDomain> findById(Integer id);
    RedisDomain findTopByName(String name);
}
