package kroryi.springex.mapper;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO vo);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO vo);

    List<TodoVO> selectList(PageRequestDTO pageRequest);

    int getCount(PageRequestDTO pageRequest);
}
