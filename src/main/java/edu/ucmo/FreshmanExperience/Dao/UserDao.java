package edu.ucmo.FreshmanExperience.Dao;

import edu.ucmo.FreshmanExperience.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    User findByEmail(String email);
    User findByUcmoid(String ucmoid);
}
