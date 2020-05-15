package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepos extends CrudRepository<Role, Long>
{
    Role findByRoleName(String roleName);
}
