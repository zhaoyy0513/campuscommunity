package zyy.campuscommunity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.PostExample;

public interface PostMapper {
    long countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExample(PostExample example);

    Post selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    int getLastPostNum();

    List<Post> selectAllPost();
}