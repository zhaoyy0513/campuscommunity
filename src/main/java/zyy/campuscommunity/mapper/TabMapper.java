package zyy.campuscommunity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.entity.TabExample;

public interface TabMapper {
    long countByExample(TabExample example);

    int deleteByExample(TabExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tab record);

    int insertSelective(Tab record);

    List<Tab> selectByExample(TabExample example);

    Tab selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tab record, @Param("example") TabExample example);

    int updateByExample(@Param("record") Tab record, @Param("example") TabExample example);

    int updateByPrimaryKeySelective(Tab record);

    int updateByPrimaryKey(Tab record);

    List<Tab> selectAllTabs();
}