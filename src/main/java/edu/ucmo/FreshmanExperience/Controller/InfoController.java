package edu.ucmo.FreshmanExperience.Controller;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

    @RequestMapping(value = "/InfoPageTest")
    public String InformationalSessions() { return "InfoPageTest"; }

    @RequestMapping(value = "/BlackboardSession")
    public String BlackboardSession() {return "BlackboardSession";}

    @RequestMapping(value = "/InfoCombatingHomesickness")
    public String InfoCombatingHomesickness() {return "InfoCombatingHomesickness";}

    @RequestMapping(value = "/InfoCommunityService")
    public String InfoCommunityService() {return "InfoCommunityService";}

    @RequestMapping(value = "/InfoStudentEmployment")
    public String InfoStudentEmployment() {return "InfoStudentEmployment";}

    @RequestMapping(value = "/InfoGoogleIt")
    public String InfoGoogleIt() {return "InfoGoogleIt";}

    @RequestMapping(value = "/InfoPublicSafety")
    public String InfoPublicSafety() {return "InfoPublicSafety";}

    @RequestMapping(value = "/InfoFinancialAssistanceSession")
    public String InfoFinancialAssistanceSession() {return "InfoFinancialAssistanceSession";}

    @RequestMapping(value = "/InfoStudentOrganizations")
    public String InfoStudentOrganizations() {return "InfoStudentOrganizations";}

    @RequestMapping(value = "/InfoTedTalkGrowthMindset")
    public String InfoTedTalkGrowthMindset() {return "InfoTedTalkGrowthMindset";}

    @RequestMapping(value = "/InfoYourSuccessNetwork")
    public String InfoYourSuccessNetwork() {return "InfoYourSuccessNetwork";}

    @RequestMapping(value = "/Schedule")
    public String Schedule() {return "Schedule";}
}
