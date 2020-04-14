package edu.ucmo.FreshmanExperience.Dao;

import edu.ucmo.FreshmanExperience.Model.Sessions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionsDao extends CrudRepository<Sessions, Integer> {
    Sessions findById(int id);
}
