package com.etc.controller;

import com.etc.entity.Class;
import com.etc.service.ClassService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Resource
    private ClassService classService;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/getbyid/{cid}")
    public Class getClass(@PathVariable Integer cid){
        return classService.getByCid(cid);
    }

    @RequestMapping("/getcla/{cla}")
    public Class getCla(@PathVariable Integer cla){
        return classService.getByCla(cla);
    }



}
