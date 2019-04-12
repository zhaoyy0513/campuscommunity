package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.Reply;
import zyy.campuscommunity.entity.ReplyExample;
import zyy.campuscommunity.mapper.ReplyMapper;
import zyy.campuscommunity.service.ReplyService;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int insertReply(Reply reply) {
       int result = replyMapper.insert(reply);
        return result;
    }

    @Override
    public List<Reply> getRepliesByPostId(int postId) {
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andPostIdEqualTo(postId);
        List<Reply> replies =  replyMapper.selectByExample(example);
        return replies;
    }

    @Override
    /**
    * @Description: 更新回复时间等
    * @Param: [reply]
    * @return: int
    * @Author: zhaoyy
    * @Date: 2019/4/9 10:39
    */
    public int updateReply(Reply reply) {
        int i = replyMapper.updateByPrimaryKey(reply);
        if(i<0){
            return -1;
        }else{
            return 0;
        }
    }
}
