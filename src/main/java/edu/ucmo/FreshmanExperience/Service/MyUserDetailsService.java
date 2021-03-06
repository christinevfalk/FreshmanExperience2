package edu.ucmo.FreshmanExperience.Service;

import edu.ucmo.FreshmanExperience.Dao.UserDao;
import edu.ucmo.FreshmanExperience.Model.Role;
import edu.ucmo.FreshmanExperience.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String ucmoid) {
        User user = userDao.findByUcmoid(ucmoid);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("The UCMO ID %s doesn't exist", ucmoid));
        }
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUcmoid(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }

    public List < User > getAllUsers() {
        return this.userDao.findAll();
    }
    public User get(String ucmoid){return userDao.findByUcmoid(ucmoid); }

    public void save(User user){
        userDao.save(user);
    }




}