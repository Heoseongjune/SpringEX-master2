package kroryi.springex.controller;

import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.service.TodoService;
import kroryi.springex.service.TodoServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@Controller
@RequestMapping("/admin/todo")
public class AdminTodoController {

    @Autowired
    private TodoService service;
    @Autowired
    private TodoServiceImpl todoServiceImpl;

    @RequestMapping("/list")
    public String list(@Valid PageRequestDTO requestDTO,
                       BindingResult br,
                       Model model) {
        log.info("requestDTO -> list controller");
        if (br.hasErrors()) {
            requestDTO = PageRequestDTO.builder().build();
        }
//        log.info("pageRequestDTO -> {}", service.getList(requestDTO).getDtoList().toString());
        model.addAttribute("responeseDTO", service.getList(requestDTO));
        model.addAttribute("pageRequestDTO", requestDTO);
        //requesetDTO에는 아래의 데이터가 있다.
        //PageResponseDTO -> page,size, total, dtoList, start, end, prev, next, last
        return "admin.todolist.page";
    }

    @RequestMapping("/read")
    public String read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("todoRead -> read controller");
        TodoDTO todoDTO = service.getOne(tno);
        model.addAttribute("dto", todoDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        return "admin.todoview.page";
    }
    @RequestMapping( "/modify")
    public String modify(Long tno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("todoRead -> read controller");
        TodoDTO todoDTO = service.getOne(tno);
        model.addAttribute("dto", todoDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        return "admin.todoupdate.page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = LocalDate.now().format(formatter);
        model.addAttribute("today", today);
        log.info(today);
        return "admin.todoregister.page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid TodoDTO todoDTO,
                           BindingResult bindingResult,
                           RedirectAttributes ra) {
        log.info("POSTTodo -> register controller");
        if (bindingResult.hasErrors()) {
            log.info("binding error");
            ra.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin/todo/register";
        }
//        log.info(todoDTO);
        service.register(todoDTO);

        return "redirect:/admin/todo/list";
    }


    //    @RequestMapping("/list")
//    public String list(Model model){
//        log.info("todoList -> list controller");
//        model.addAttribute("dtoList",todoServiceImpl.getAll());//getAll
//
//                return "/todo/list";
//    }




    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes ra,
                         PageRequestDTO pageRequestDTO) {
        log.info("todoModify -> modify controller");
        if (bindingResult.hasErrors()) {
            log.info("binding error...............");
            ra.addFlashAttribute("errors", bindingResult.getAllErrors());
            ra.addAttribute("tno", todoDTO.getTno());
            ra.addAttribute("page", pageRequestDTO.getPage());
            ra.addAttribute("size", pageRequestDTO.getSize());
            return "redirect:/admin/todo/modify?"+pageRequestDTO.getLink();
        }
        log.info(todoDTO);
        service.modify(todoDTO);
        ra.addAttribute("tno", todoDTO.getTno());
        return "redirect:/admin/todo/read";

    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(Long tno, RedirectAttributes ra, PageRequestDTO pageRequestDTO) {
        log.info("POST Todo -> remove controller");
        log.info("tno -> {}", tno);
        service.remove(tno);
        ra.addAttribute("page", pageRequestDTO.getPage());
        ra.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/admin/todo/list?"+pageRequestDTO.getLink();
//        return "redirect:/todo/list?${pageRequestDTO.link}";
    }

//    @RequestMapping({"/read","modify"})
//    public String readOrModify(Long tno, Model model, HttpServletRequest req){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//        String reqURI = req.getRequestURI();
//        if(reqURI.contains("/modify")){
//            return "/todo/modify";
//        }else{
//            return "/todo/read";
//        }
//    }
//

//    @RequestMapping("/read")
//    public void read(Long tno, Model model){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//    }
//
//    @RequestMapping("/modify")
//    public void modify(Long tno, Model model){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//    }


}
