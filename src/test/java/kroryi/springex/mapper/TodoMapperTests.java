package kroryi.springex.mapper;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/root-context.xml",
        "file:src/main/webapp/WEB-INF/servlet-context.xml"})
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper mapper;
    @Autowired
    private TodoMapper todoMapper;


    @Autowired
    private TodoService todoService;

    @Test
    public void testGetTime() {
        log.info(mapper.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO todoVo = TodoVO.builder()
                .title("스프링테스트")
                .dueDate(LocalDate.of(2024, 8, 29))
                .writer("후?")
                .finished(true)
                .build();
        todoMapper.insert(todoVo);
    }

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("테스트")
                .dueDate(LocalDate.now())
                .finished(true)
                .writer("김유신")
                .build();
        todoService.register(todoDTO);
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(TodoDTO todoDTO){
        log.info("POSTtodo -> register controller");
        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

}
