package edu.ucmo.FreshmanExperience.Controller;

import edu.ucmo.FreshmanExperience.Dao.RoleDao;
import edu.ucmo.FreshmanExperience.Dao.SessionsDao;
import edu.ucmo.FreshmanExperience.Dao.UserDao;
import edu.ucmo.FreshmanExperience.Model.Role;
import edu.ucmo.FreshmanExperience.Model.Sessions;
import edu.ucmo.FreshmanExperience.Model.User;
import edu.ucmo.FreshmanExperience.Service.MyUserDetailsService;
import edu.ucmo.FreshmanExperience.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private UserDao userD;
    @Autowired
    private MyUserDetailsService service1;
    @Autowired
    private SessionsDao sessionsD;
    @Autowired
    private SessionService service;
    @Autowired
    private RoleDao roleD;

    @RequestMapping(value = "/")
    public String viewHomePage(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userD.findByUcmoid(currentUserName);
            Set<Role> role = user.getRoles();
            List<Role> list = new ArrayList<Role>(role);
            Role obj = list.get(0);
            System.out.println(obj);

            if (obj.getId()==2){
                List<Sessions> listSessions = service.listAll();
                model.addAttribute("listSessions", listSessions);
                return "AdminSchedule";
            }
        }
        List<Sessions> listSessions = service.listAll();
        model.addAttribute("listSessions", listSessions);

        return "Schedule";
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
        String sessionTitle = sessions.getTitle();
        Set<User> users = sessions.getUsers();
        model.addAttribute("sessionTitle", sessionTitle);
        model.addAttribute("listStudents", users);
        return "ListStudents";
    }



    @RequestMapping("/add")
    public String showNewStudentPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "add_student";
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

    @RequestMapping("/info")
    public String viewInfoPage (@RequestParam(value = "id") Integer id, Model model) {
        System.out.println("id = " + id);
        Sessions sessions = service.get(id);
        if (id == 1) return "InfoYourSuccessNetwork";
        else if (id == 2) return "InfoSeminar";
        else if (id == 3) return "InfoBlackboard";
        else if (id == 4) return "InfoPublicSafety";
        else if (id == 5) return "InfoCampusDiversity";
        else return "index";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("sessions") Sessions sessions) {
        service.save(sessions);     return "redirect:/";
    }
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("session_attendance") User user) {
        service1.save(user);
        return "redirect:/";
    }
}