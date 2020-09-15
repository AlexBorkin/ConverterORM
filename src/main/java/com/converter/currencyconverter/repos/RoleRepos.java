package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepos extends JpaRepository<Role, Long>
{
    Role findByRoleName(String roleName);
}
