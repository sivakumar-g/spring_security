package com.roleauth.roleAuth.dao;
import org.springframework.stereotype.Repository;
import com.roleauth.roleAuth.entity.User;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
