package com.converter.currencyconverter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = {"role_name"})})
public class Role implements GrantedAuthority
{
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "role_name")
    private String roleName;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "user_role_ref", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<User> users = new HashSet<>();

    public Role()
    {
    }
//
//    public Role(String roleName, String description) {
//        this.roleName = roleName;
//        this.description = description;
//    }
//
//    public Set<User> getUsers()
//    {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    @Override
    public String getAuthority()
    {
        return getRoleName();
    }
}
