package edu.ucmo.FreshmanExperience.Controller;

import edu.ucmo.FreshmanExperience.Dao.UserDao;
import edu.ucmo.FreshmanExperience.Model.Sessions;
import edu.ucmo.FreshmanExperience.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.ucmo.FreshmanExperience.Service.MyUserDetailsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MyUserDetailsService service;

    @GetMapping
    public List<User> listUsers(){
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @RequestMapping(value = "/edit/{ucmoid}")
    public ModelAndView showEditUserPage(@PathVariable(name= "ucmoid") String ucmoid) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = service.get(ucmoid);
        mav.addObject("user", user);

        return mav;

    }





}
