package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User, Long>
{
    User findByUserName(String userName);
}
