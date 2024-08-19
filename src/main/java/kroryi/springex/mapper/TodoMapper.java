package kroryi.springex.mapper;

import kroryi.springex.domain.TodoVO;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO vo);
}
