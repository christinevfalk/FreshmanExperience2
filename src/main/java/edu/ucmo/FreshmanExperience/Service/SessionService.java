package edu.ucmo.FreshmanExperience.Service;

import edu.ucmo.FreshmanExperience.Dao.SessionsDao;
import edu.ucmo.FreshmanExperience.Model.Sessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SessionService {

    @Autowired
    private SessionsDao sessionsDao;

    public List<Sessions> listAll(){
        return (List<Sessions>) sessionsDao.findAll();
    }

    public void save(Sessions sessions){
        sessionsDao.save(sessions);
    }

    public Sessions get(int id){
        return sessionsDao.findById(id);
    }

    public void delete(int id){
        sessionsDao.deleteById(id);
    }
}
