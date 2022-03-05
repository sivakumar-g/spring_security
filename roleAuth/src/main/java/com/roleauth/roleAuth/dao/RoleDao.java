package com.roleauth.roleAuth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roleauth.roleAuth.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role,String> {

}
