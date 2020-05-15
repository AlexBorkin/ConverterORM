package com.converter.currencyconverter.service;

import com.converter.currencyconverter.entity.Role;
import com.converter.currencyconverter.repos.RoleRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService
{
    @Autowired
    private RoleRepos roleRepos;

    public void saveRole(Role role)
    {
        roleRepos.save(role);
    }
}
