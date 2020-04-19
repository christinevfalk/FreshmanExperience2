package edu.ucmo.FreshmanExperience.Controller;

import edu.ucmo.FreshmanExperience.Dao.SessionsDao;
import edu.ucmo.FreshmanExperience.Dao.UserDao;
import edu.ucmo.FreshmanExperience.Model.Sessions;
import edu.ucmo.FreshmanExperience.Model.User;
import edu.ucmo.FreshmanExperience.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private UserDao userD;
    @Autowired
    private SessionsDao sessionsD;
    @Autowired
    private SessionService service;

    @RequestMapping(value = "/")
    public String viewHomePage() {
//        List<Sessions> listSessions = service.listAll();
//        model.addAttribute("listSessions", listSessions);
        return "index";
    }

    @RequestMapping(value = "/AdminSchedule")
    public String viewHomeAdminPage(Model model){
        List<Sessions> listSessions = service.listAll();
        model.addAttribute("listSessions", listSessions);
        return "AdminSchedule";
    }

    @RequestMapping("/list")
    public String listStudents(
        @RequestParam(value = "id") Integer id, Model model)
    {
        System.out.println("id = " + id);
        Sessions sessions = service.get(id);
        Set<User> users = sessions.getUsers();
        model.addAttribute("listStudents", users);
        return "ListStudents";
    }

    @RequestMapping(value = "/Schedule")
    public String viewHomePage2(Model model) {
        List<Sessions> listSessions = service.listAll();
        model.addAttribute("listSessions", listSessions);
        return "Schedule";
    }

    @RequestMapping("/new")
    public String showNewSessionPage(Model model){
        Sessions sessions = new Sessions();
        model.addAttribute("sessions", sessions);
        return "new_session";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("sessions") Sessions sessions) {
        service.save(sessions);
        return "redirect:/";
    }
}

