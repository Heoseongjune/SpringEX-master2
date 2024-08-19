package kroryi.springex.controller;

import jakarta.validation.Valid;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @RequestMapping("/list")
    public void list(){
        log.info("todo -> list controller");
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public void register(){
        log.info("todo -> register controller");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid TodoDTO todoDTO,
                           BindingResult bindingResult,
                           RedirectAttributes ra){
        log.info("POSTTodo -> register controller");
        if(bindingResult.hasErrors()){
            log.info("binding error");
            ra.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info(todoDTO);
        service.register(todoDTO);

        return "redirect:/todo/list";
    }
}
