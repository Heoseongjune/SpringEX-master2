package kroryi.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("select * from tbl_member where mid='user00'")
    String getTime();
}
