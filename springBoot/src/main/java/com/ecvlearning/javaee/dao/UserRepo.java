package com.ecvlearning.javaee.dao;

import com.ecvlearning.javaee.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select u from User u where u.userName = ?1")
    User findByJPQL(String userName);

    @Query(value = "SELECT * FROM user WHERE birthday = ?1 ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(1) FROM user WHERE user_name = ?1",
            nativeQuery = true)
    Page<User> findByNativeSql(String birthday, Pageable pageable);

}
