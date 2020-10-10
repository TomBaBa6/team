package com.etc.dao;

import com.etc.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ClassDao extends JpaRepository<Class, Integer>, JpaSpecificationExecutor<Class>, Serializable {

    public Class findByCid(Integer cid);

    public Class findByCla(Integer cla);

}
