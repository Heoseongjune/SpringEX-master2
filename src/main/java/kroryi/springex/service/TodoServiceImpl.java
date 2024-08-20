package kroryi.springex.service;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;


    @Override
    public void register(TodoDTO dto) {
        log.info("register todo: {} ", dto);
        TodoVO todoVo = modelMapper.map(dto, TodoVO.class);
        log.info("register todo: {}", todoVo);

        todoMapper.insert(todoVo);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        // pageRequestDTO skip, size, page 값만 있음.
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

//    @Override
//    public List<TodoDTO> getAll() {
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                .map(vo -> modelMapper.map(vo, TodoDTO.class))
//                .collect(Collectors.toList());
//        return dtoList;
//    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO dto) {
        TodoVO todoVo = modelMapper.map(dto, TodoVO.class);
        todoMapper.update(todoVo);
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVo = todoMapper.selectOne(tno);
        if(todoVo == null) {
            log.info("Not found todo: {}", tno);
            return null;
        }
        TodoDTO dto = modelMapper.map(todoVo, TodoDTO.class);
        return dto;
    }


}
