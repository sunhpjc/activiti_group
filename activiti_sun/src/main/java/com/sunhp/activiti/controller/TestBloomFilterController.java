package com.sunhp.activiti.controller;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date 2022/2/10 14:41
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestBloomFilterController {
    private static BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),
            5, 0.01);

    /**
     * 初始化bloom过滤器
     */
    @PostMapping("/bloomScheduled")
    public void bloomScheduled(){
        List<String> stringList = new ArrayList<>();
        stringList.add("tom");
        stringList.add("bob");
        stringList.add("ttu");
        stringList.add("html");
        stringList.add("url");

        stringList.stream().forEach(name ->{
            bloomFilter.put(name);
        });
        log.info("初始化布隆过滤器成功");
    }

    /**
     * 新增用户
     * @param name
     */
    @PostMapping("/add")
    public void bloomAdd(@RequestBody String name){
        log.info("先添加用户进数据库，再添加一次布隆过滤器");
        bloomFilter.put(name);
        log.info("新增用户添加布隆过滤器成功");
    }

    /**
     * 检验结果
     * @param name
     */
    @PostMapping("/check")
    public boolean bloomCheck(@RequestBody String name){
        boolean b = bloomFilter.mightContain(name);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>name:{}, result:{}", name, b);
        return b;
    }

    public static void main(String[] args) {
        String str = "abcd";
        String str1 = "abcd";
        System.out.println(str == str1);








        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("ucn"+i);
        }

        Map map = new HashMap<>();
        map.put("ucn1","ucn1");
        map.put("ucn3", "ucn3");
        map.put("ucn5", "ucn5");
        map.put("ucn999", "ucn999");
        map.put("ucn888", "ucn888");
        map.put("ucn777", "ucn777");
        map.put("ucn666", "ucn666");
        map.put("ucn555", "ucn555");
        map.put("ucn444", "ucn444");

        List<String> strF = new ArrayList<>();
        List<String> strI = new ArrayList<>();

        list.forEach(send -> {
//            if(StringUtils.isNotEmpty(map.get(send)))

        });
    }
}
