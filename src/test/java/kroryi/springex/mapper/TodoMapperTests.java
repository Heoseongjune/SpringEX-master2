package kroryi.springex.mapper;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
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
import java.util.List;

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

    @Test
    public void testSelectAll(){
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVo=todoMapper.selectOne(11L);
        log.info(todoVo);
    }

    @Test
    public void testPageing(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        log.info(responseDTO);
        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }

    @Test
    public void testSelectList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectSearch(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"})
                .keyword("스프링")
//                .finished(true)
                .from(LocalDate.of(2024,8,1))
                .to(LocalDate.of(2024,8,30))
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }
}
