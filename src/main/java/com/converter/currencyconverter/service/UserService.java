package com.converter.currencyconverter.service;

import com.converter.currencyconverter.entity.Role;
import com.converter.currencyconverter.entity.User;
import com.converter.currencyconverter.repos.RoleRepos;
import com.converter.currencyconverter.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Service
public class UserService implements UserDetailsService
{
    @Value("${UserRoleDefault}")
    private String userRoleDefault;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private RoleRepos roleRepos;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userRepos.findByUserName(s);

        return user;
    }

    public void addNewUser(String userName, String password)
    {
        Role role = roleRepos.findByRoleName(userRoleDefault); //new Role(userRoleDefault, userRoleDefault);

        if (role == null)
        {
            role = new Role(userRoleDefault, userRoleDefault);
            roleRepos.save(role);
        }

        User user = new User(userName, passwordEncoder.encode(password), true);

        user.addNewUser(role);

        userRepos.save(user);
    }

    public User findUserByUserName(String userName)
    {
        User user = new User();

        try
        {
            user = userRepos.findByUserName(userName);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return user;
    }
}
