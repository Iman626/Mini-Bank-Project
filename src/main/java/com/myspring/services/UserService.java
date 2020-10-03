package com.myspring.services;

import com.myspring.beans.UserBean;
import com.myspring.entities.Users;
import com.myspring.entities.Roles;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService implements UserDetailsService {

    private UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users myUser = userBean.getUser(s);
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(myUser.getRole_id().getName()));
        User securityUser = new User(myUser.getLogin(), myUser.getPassword(), authorities);
        return securityUser;
    }
}