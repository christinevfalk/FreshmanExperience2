package edu.ucmo.FreshmanExperience.Dao;

import edu.ucmo.FreshmanExperience.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
