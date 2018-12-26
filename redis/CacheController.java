package com.wangzhou.highconcurrent.cache.redis;

import com.wangzhou.highconcurrent.cache.domain.RedisDomain;
import com.wangzhou.highconcurrent.cache.service.RedisDomainService;
import com.wangzhou.highconcurrent.cache.vo.RedisDo;
import com.wangzhou.highconcurrent.cache.vo.RedisDomainVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by IDEA
 * author:wangzhou
 * Data:2018/12/24
 * Time:15:15
 **/
@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private RedisDomainService redisDomainService;

    @GetMapping("/set")
    //更新缓存，每次都会执行 但是必须返回的是经过序列化的对象，所以会报错
    //    @CachePut(cacheNames = "product",key = "123")
    //当触发该请求，则删除cacheNames = "product",key = "123"下的缓存被清除，那么下次get就会重新生成缓存
    @CacheEvict(cacheNames = "product",key = "123")
    public RedisDomain set(@RequestParam(value="age") String age) {

        RedisDomain redisDomain1 = redisDomainService.findByName("tom");
        redisDomain1.setAge(age);
        redisDomainService.update(redisDomain1);
        return redisDomain1;
    }

    @GetMapping("/get")
    @Cacheable(cacheNames = "product",key = "123")
    public RedisDomainVO get() {
        RedisDomainVO redisDomainVO=new RedisDomainVO();
        redisDomainVO.setCode("200");
        redisDomainVO.setDiscrible("成功");
        redisDomainVO.setRedisDomainList( redisDomainService.findAll());
        return redisDomainVO;
    }
    @GetMapping("/set1")
    //更新缓存，每次都会执行 但是必须返回的是经过序列化的对象，所以会报错
    //    @CachePut(cacheNames = "product",key = "123")
    //当触发该请求，则删除cacheNames = "product",key = "123"下的缓存被清除，那么下次get就会重新生成缓存
    @CacheEvict(cacheNames = "product1")
    public RedisDomain set1(@RequestParam(value="age") String age) {

        RedisDomain redisDomain1 = redisDomainService.findByName("tom");
        redisDomain1.setAge(age);
        redisDomainService.update(redisDomain1);
        return redisDomain1;
    }

    @GetMapping("/get1")
    //条件成立才会对结果进行缓存
    //unless判定条件
    @Cacheable(cacheNames = "product1",key = "#id",condition ="#id.length()>3" ,unless = "#result.getCode()==200")
    public RedisDomainVO get1(@RequestParam(value = "id") String id) {
        RedisDomainVO redisDomainVO=new RedisDomainVO();
        redisDomainVO.setCode("200");
        redisDomainVO.setDiscrible("成功");
        redisDomainVO.setRedisDomainList( redisDomainService.findAll());
        return redisDomainVO;
    }
    @GetMapping("/find")
    public RedisDomain find() {

        return redisDomainService.findByName("tom");
    }

}
