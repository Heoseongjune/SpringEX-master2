package kroryi.springex.service;

import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.dto.UserDTO;

import java.util.List;

public interface UserService {
    //todoMapper insert 와 연결.
    void register(UserDTO dto);

//    List<UserDTO> getAll();
    PageResponseDTO<UserDTO> getList(PageRequestDTO pageRequestDTO);


    UserDTO getOne(int tno);

    void remove(int tno);

    void modify(UserDTO dto);

    UserDTO getTwo(String mid);
}
