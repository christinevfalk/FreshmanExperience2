package edu.ucmo.FreshmanExperience.Controller;

<<<<<<< HEAD
import edu.ucmo.FreshmanExperience.Model.Sessions;
import edu.ucmo.FreshmanExperience.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> Christine
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> Christine

@Controller
public class HomeController {

    @Autowired
<<<<<<< HEAD
    private SessionService service;

    @RequestMapping(value = "/")
    public String viewHomePage(Model model) {
//        List<Sessions> listSessions = service.listAll();
//        model.addAttribute("listSessions", listSessions);
        return "index";
    }

=======

>>>>>>> Christine
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

<<<<<<< HEAD
=======
>>>>>>> Christine
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("sessions") Sessions sessions) {
        service.save(sessions);
        return "redirect:/";
    }
<<<<<<< HEAD

    }

=======
}
>>>>>>> Christine
