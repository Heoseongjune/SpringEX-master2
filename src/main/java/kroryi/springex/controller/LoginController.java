package kroryi.springex.controller;

import kroryi.springex.dto.UserDTO;
import kroryi.springex.service.UserService;
import kroryi.springex.service.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService service;
    @Autowired
    private UserServiceImpl userServiceImpl;


    @GetMapping("/")
    public String home(Model model) {
        return "login.page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserDTO userDTO) {

        log.info("1111111-. {}, {}", userDTO.getMid(), userDTO.getMpw());
        UserDTO getOneDto = service.getTwo(userDTO.getMid());
        if (getOneDto == null) {
            log.info("2222222-. {}, {}", userDTO.getMid(), userDTO.getMpw());
            return "login.page";
        } else {
            if (getOneDto.getMpw().equals(userDTO.getMpw())) {
                return "redirect:/admin/";
            } else {
                log.info("3333333-. {}, {}", userDTO.getMid(), userDTO.getMpw());
                return "login.page";
            }
        }
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {


        return "register.page";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           RedirectAttributes ra) {
        log.info("POSTTodo -> register controller");
        if (bindingResult.hasErrors()) {
            log.info("binding error");
            ra.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "";
        }
//        log.info(todoDTO);
        service.register(userDTO);

        return "login.page";
    }
}
