package com.converter.currencyconverter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//@Data
//@AllArgsConstructor
@Entity
@Table(name ="user_table", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name"})})
public class User implements UserDetails
{
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="user_name")
    private String userName;
    private String password;
    private Boolean active;
    @Pattern(message = "Wrong format for email", regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role_ref", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<Role> roles = new HashSet<>();

    public User()
    {
    }

    public User(String userName, String password, Boolean active)
    {
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

    public User(String userName, String password, String email, Boolean active)
    {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.email = email;
    }

    public void addNewUser(Role role)
    {
        Set<Role> roles = Collections.singleton(role);

        this.setRoles(roles);
    }

//    public String getUserName() {
//        return userName;
//    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
