package com.etc.service.Impl;

import com.etc.dao.ClassDao;
import com.etc.entity.Class;
import com.etc.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassDao classDao;


    @Override
    public Class getByCid(Integer cid) {
        return classDao.findByCid(cid);
    }

    @Override
    public Class getByCla(Integer cla) {
        return classDao.findByCla(cla);
    }
}
