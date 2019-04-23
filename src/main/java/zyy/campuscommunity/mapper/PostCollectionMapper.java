package zyy.campuscommunity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zyy.campuscommunity.entity.PostCollection;
import zyy.campuscommunity.entity.PostCollectionExample;

public interface PostCollectionMapper {
    long countByExample(PostCollectionExample example);

    int deleteByExample(PostCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostCollection record);

    int insertSelective(PostCollection record);

    List<PostCollection> selectByExample(PostCollectionExample example);

    PostCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostCollection record, @Param("example") PostCollectionExample example);

    int updateByExample(@Param("record") PostCollection record, @Param("example") PostCollectionExample example);

    int updateByPrimaryKeySelective(PostCollection record);

    int updateByPrimaryKey(PostCollection record);
}