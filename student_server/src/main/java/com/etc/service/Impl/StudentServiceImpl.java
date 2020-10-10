package com.etc.service.Impl;

import com.etc.dao.StudentDao;
import com.etc.entity.Student;
import com.etc.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;


    @Override
    public Student getBySid(Integer id) {
        return studentDao.findBySid(id);
    }
}
