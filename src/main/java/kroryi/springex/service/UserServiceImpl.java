package kroryi.springex.service;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.domain.UserVO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.dto.UserDTO;
import kroryi.springex.mapper.TodoMapper;
import kroryi.springex.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;


    @Override
    public void register(UserDTO dto) {
        log.info("register todo: {} ", dto);
        UserVO userVo = modelMapper.map(dto, UserVO.class);
        log.info("register todo: {}", userVo);

        userMapper.insert(userVo);
    }



    @Override
    public PageResponseDTO<UserDTO> getList(PageRequestDTO pageRequestDTO) {
        // pageRequestDTO skip, size, page 값만 있음.
        List<UserVO> voList = userMapper.selectList(pageRequestDTO);
        List<UserDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo,UserDTO.class))
                .collect(Collectors.toList());

        int total = userMapper.getCount(pageRequestDTO);

        PageResponseDTO<UserDTO> pageResponseDTO = PageResponseDTO.<UserDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        log.info(pageResponseDTO.toString());
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
    public void remove(int no) {
        userMapper.delete(no);
    }

    @Override
    public void modify(UserDTO dto) {
        UserVO userVo = modelMapper.map(dto, UserVO.class);
        userMapper.update(userVo);
    }

    @Override
    public UserDTO getOne(int no) {
        UserVO userVo = userMapper.selectOne(no);
        if(userVo == null) {
            log.info("Not found todo: {}", no);
            return null;
        }
        UserDTO dto = modelMapper.map(userVo, UserDTO.class);
        return dto;
    }

    @Override
    public UserDTO getTwo(String mid) {

        UserVO vo = userMapper.selectTwo(mid);
        if (vo == null) {
            log.info("Not found Member: {}", mid);
            return null;
        }
        UserDTO dto = modelMapper.map(vo, UserDTO.class);

        return dto;
    }
}
