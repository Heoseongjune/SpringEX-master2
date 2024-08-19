package kroryi.springex.service;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;


    @Override
    public void register(TodoDTO dto) {
        log.info("register todo: {} " , dto);
        TodoVO todoVo = modelMapper.map(dto, TodoVO.class);
        log.info("register todo: {}" , todoVo);

        todoMapper.insert(todoVo);
    }

}
