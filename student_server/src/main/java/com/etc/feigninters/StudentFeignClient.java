package com.etc.feigninters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "ClassServer",fallback = StudentFeignClientImpl.class)
public interface StudentFeignClient {

    @RequestMapping(value = "/class/getcla/{cla}",method = RequestMethod.GET)
    public Map<String,Object> getClassBycla(@PathVariable("cla")Integer cla );
}
