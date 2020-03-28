package edu.ucmo.FreshmanExperience.Controller;

import edu.ucmo.FreshmanExperience.Dao.SessionsDao;
import edu.ucmo.FreshmanExperience.Model.Sessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sessions")
public class SessionsController {

    @Autowired
    private SessionsDao sessionsDao;

    @GetMapping
    public List<Sessions> listSessions() {
        List<Sessions> list = new ArrayList<>();
        sessionsDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @PostMapping("/add")
    public Sessions saveSessions(@RequestBody Sessions sessions) {
        Sessions newSessions = new Sessions(sessions.getTitle(), sessions.getLocation(), sessions.getInstructor());
        return sessionsDao.save(newSessions);
    }

    @GetMapping("/{id}")
    public Sessions getOne(@PathVariable int id) {
        Optional<Sessions> optionalSessions = sessionsDao.findById(id);
        return optionalSessions.isPresent() ? optionalSessions.get() : null;
    }

    @GetMapping("/title/{title}")
    public List<Sessions> getTitle(@PathVariable String title) {
        return sessionsDao.findByTitle(title);
    }

    @PutMapping("/update")
    public Sessions update(@RequestBody Sessions sessionsUpdate){
        Optional<Sessions> optionalSessions = sessionsDao.findById(sessionsUpdate.getId());
        if(optionalSessions.isPresent()){
            sessionsDao.save(sessionsUpdate);
        }
        return sessionsUpdate;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        sessionsDao.deleteById(id);
    }
}
