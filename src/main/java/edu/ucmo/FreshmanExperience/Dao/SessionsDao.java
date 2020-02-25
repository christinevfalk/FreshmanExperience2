package edu.ucmo.FreshmanExperience.Dao;

import edu.ucmo.FreshmanExperience.Model.Sessions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionsDao extends CrudRepository<Sessions, Integer> {
    List<Sessions> findByTitle (String title);
}
