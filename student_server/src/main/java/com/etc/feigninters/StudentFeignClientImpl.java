package com.etc.feigninters;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentFeignClientImpl implements StudentFeignClient {
    @Override
    public Map<String, Object> getClassBycla(Integer cla) {
       Map<String,Object> map=new HashMap<>();
       map.put("name","Tom");
       map.put("word","就不告诉你");
       return map;
    }
}
