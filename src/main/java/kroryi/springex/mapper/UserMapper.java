package kroryi.springex.mapper;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.domain.UserVO;
import kroryi.springex.dto.PageRequestDTO;

import java.util.List;

public interface UserMapper {
    String getTime();

    void insert(UserVO vo);

    List<UserVO> selectAll();

    UserVO selectOne(int tno);

    void delete(int tno);

    void update(UserVO vo);

    List<UserVO> selectList(PageRequestDTO pageRequest);

    int getCount(PageRequestDTO pageRequest);

    UserVO selectTwo(String mid);

}
