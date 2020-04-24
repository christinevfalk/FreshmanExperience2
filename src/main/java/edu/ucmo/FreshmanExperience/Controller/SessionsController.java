package edu.ucmo.FreshmanExperience.Controller;

import edu.ucmo.FreshmanExperience.Dao.SessionsDao;
import edu.ucmo.FreshmanExperience.Dao.UserDao;
import edu.ucmo.FreshmanExperience.Model.Sessions;
import edu.ucmo.FreshmanExperience.Model.User;
import edu.ucmo.FreshmanExperience.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
public class SessionsController {

    @Autowired
    private UserDao userD;
    @Autowired
    private SessionsDao sessionsD;
    @Autowired
    private SessionService service;

    @GetMapping("/session/{id}")



    public String session(@PathVariable int id, Model model) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println("Session " + currentUserName + "," + id);
            User user = userD.findByUcmoid(currentUserName);
            Sessions sessions = service.get(id);

            String sessionTitle = sessions.getTitle();
            model.addAttribute("sessionTitle", sessionTitle);

            Set<User> users = sessions.getUsers();
            users.add(user);
            sessions.setUsers(users);
            sessionsD.save(sessions);

            model.addAttribute("user", user);
        }
        else {
        System.out.println("Error - No One Logged In");
        return "login";
        }
        if (id >= 1 &&id <= 8)
        return "QRCheckIn";
        else return "index";
        }
        }