package edu.ucmo.FreshmanExperience.Controller;

import edu.ucmo.FreshmanExperience.Model.Sessions;
import edu.ucmo.FreshmanExperience.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SessionService service;

    @RequestMapping(value = "/")
    public String viewHomePage(Model model) {
        List<Sessions> listSessions = service.listAll();
        model.addAttribute("listSessions", listSessions);
        return "index";
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
