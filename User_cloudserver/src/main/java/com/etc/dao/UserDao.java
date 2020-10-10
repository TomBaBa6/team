package com.etc.dao;

import com.etc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, Serializable {

    public User findUserByUid(Integer id);

}