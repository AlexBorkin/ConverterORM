package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepos extends CrudRepository<User, Long>
{
    User findByUserName(String userName);
}
