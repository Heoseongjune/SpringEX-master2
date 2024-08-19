package kroryi.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/")
    public String home() {

        return "/admin/home";
    }

    @GetMapping("/buttons")
    public String buttons() {
        return "/admin/buttons";
    }

    @GetMapping("/blank")
    public String blank() {
        return "/admin/blank";
    }

    @GetMapping("/cards")
    public String cards() {
        return "/admin/cards";
    }

    @GetMapping("/charts")
    public String charts() {
        return "/admin/charts";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "/admin/forgot-password";
    }

    @GetMapping("/login")
    public String login() {
        return "/admin/login";
    }

    @GetMapping("/register")
    public String register() {
        return "/admin/register";
    }

    @GetMapping("/tables")
    public String tables() {
        return "/admin/tables";
    }

    @GetMapping("/utilities-animation")
    public String utilitiesAnimation() {
        return "/admin/utilities-animation";
    }

    @GetMapping("/utilities-border")
    public String utilitiesBorder() {
        return "/admin/utilities-border";
    }

    @GetMapping("/utilities-color")
    public String utilitiesColor() {
        return "/admin/utilities-color";
    }

    @GetMapping("/utilities-other")
    public String utilitiesOther() {
        return "/admin/utilities-other";
    }

}
