package kroryi.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/")
    public String home(Model model) {
        return "admin.index.page";
    }

    @GetMapping("/memberlist")
    public String memberlist(Model model) {
        model.addAttribute("test","testetstesetse");
        return "admin.memberlist.page";
    }

    @GetMapping("/memberregister")
    public String memberregister(Model model) {
        return "admin.memberregister.page";
    }

    @GetMapping("/memberupdate")
    public String memberupdate(Model model) {
        return "admin.memberupdate.page";
    }

    @GetMapping("/memberview")
    public String memberview(Model model) {
        return "admin.memberview.page";
    }



}
