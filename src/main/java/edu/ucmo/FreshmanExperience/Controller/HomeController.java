package edu.ucmo.FreshmanExperience.Controller;

import edu.ucmo.FreshmanExperience.Model.Sessions;
import edu.ucmo.FreshmanExperience.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import edu.ucmo.FreshmanExperience.Dao.RoleDao;
import edu.ucmo.FreshmanExperience.Dao.SessionsDao;
import edu.ucmo.FreshmanExperience.Dao.UserDao;
import edu.ucmo.FreshmanExperience.Model.Role;
import edu.ucmo.FreshmanExperience.Model.User;
import edu.ucmo.FreshmanExperience.Service.MyUserDetailsService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import java.util.ArrayList;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private SessionService service;
    @Autowired
    private UserDao userD;
    @Autowired
    private MyUserDetailsService service1;
    @Autowired
    private SessionsDao sessionsD;
    @Autowired
    private RoleDao roleD;

    //Determines if logged in user is a user or admin and sends them to correct home page
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
    //Admin home after login
    @RequestMapping(value = "/AdminSchedule")
    public String viewHomeAdminPage(Model model){
        List<Sessions> listSessions = service.listAll();
        model.addAttribute("listSessions", listSessions);
        return "AdminSchedule";
    }
    //Lists students attending selected session
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
    //User home after login
    @RequestMapping(value = "/Schedule")
    public String viewHomePage2(Model model) {
        List<Sessions> listSessions = service.listAll();
        model.addAttribute("listSessions", listSessions);
        return "Schedule";
    }
    //Admin can add new session
    @RequestMapping("/new")
    public String showNewSessionPage(Model model){
        Sessions sessions = new Sessions();
        model.addAttribute("sessions", sessions);
        return "new_session";
    }
    //Displays info on selected session for a student
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
    //Admin can edit student info
    @RequestMapping(value = "/editUser/{ucmoid}")
    public ModelAndView showEditUserPage(@PathVariable(name= "ucmoid") String ucmoid) {
        ModelAndView mav2 = new ModelAndView("edit_user");
        User user = service1.get(ucmoid);
        mav2.addObject("user", user);
        return mav2;
    }
    //Saves 'Add session'
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("sessions") Sessions sessions) {
        service.save(sessions);     return "redirect:/";
    }
    //Saves 'Add new student'
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        service1.save(user);
        return "redirect:/";
    }
    //Saves student information after editing
    @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
    public String saveEditedUser(@ModelAttribute("user") User user) {
        service1.save(user);
        return "redirect:/";
    }

    //Admin can view a list of students that have attended more than 3 sessions
    @RequestMapping("/tshirts")
    public String saveTshirts(Model model){
        ArrayList<User> arr = new ArrayList<>();
        Sessions listSessions1 = service.get(1);
        Sessions listSessions2 = service.get(2);
        Sessions listSessions3 = service.get(3);
        Sessions listSessions4 = service.get(4);
        Sessions listSessions5 = service.get(5);
        Set<User> list1 = listSessions1.getUsers();
        for (User user : list1)
            arr.add(user);
        Set<User> list2 = listSessions2.getUsers();
        for (User user : list2)
            arr.add(user);
        Set<User> list3 = listSessions3.getUsers();
        for (User user : list3)
            arr.add(user);
        Set<User> list4 = listSessions4.getUsers();
        for (User user : list4)
            arr.add(user);
        Set<User> list5 = listSessions5.getUsers();
        for (User user : list5)
            arr.add(user);
        Set<User> set = new HashSet<>();
        for (User element: arr) {
           int freq;
           freq = Collections.frequency(arr, element);
           if (freq > 3) {
               set.add(element);
           }
        }
        model.addAttribute("set", set);
        return "TshirtList";
    }

}
