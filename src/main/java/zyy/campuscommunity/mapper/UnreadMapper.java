package zyy.campuscommunity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zyy.campuscommunity.entity.Unread;
import zyy.campuscommunity.entity.UnreadExample;

public interface UnreadMapper {
    long countByExample(UnreadExample example);

    int deleteByExample(UnreadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Unread record);

    int insertSelective(Unread record);

    List<Unread> selectByExample(UnreadExample example);

    Unread selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Unread record, @Param("example") UnreadExample example);

    int updateByExample(@Param("record") Unread record, @Param("example") UnreadExample example);

    int updateByPrimaryKeySelective(Unread record);

    int updateByPrimaryKey(Unread record);
}