package kroryi.springex.service;

import kroryi.springex.dto.TodoDTO;

public interface TodoService {
    //todoMapper insert 와 연결.
    void register(TodoDTO dto);
}
