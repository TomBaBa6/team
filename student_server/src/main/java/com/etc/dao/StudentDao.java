package com.etc.dao;

import com.etc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student>, Serializable {

    Student findBySid(Integer sid);

    void delete(Student student);
}
