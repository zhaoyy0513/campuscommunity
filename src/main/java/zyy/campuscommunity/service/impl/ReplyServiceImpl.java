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
        int i = replyMapper.insert(reply);
        if(i<0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public List<Reply> getRepliesByPostId(int postId) {
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andPostIdEqualTo(postId);
        return replyMapper.selectByExample(example);
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

    @Override
    /** 
    * @Description: 根据回复的索引id删除回复
    * @Param: [id] 
    * @return: int 
    * @Author: zhaoyy
    * @Date: 2019/5/7 17:09
    */ 
    public int deleteReplyById(int Rid) {
        int i = replyMapper.deleteByPrimaryKey(Rid);
        if(i<0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteReplyByPid(int pid) {
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andPostIdEqualTo(pid);
        int i =replyMapper.deleteByExample(example);
        if(i<0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    /** 
    * @Description: 获取所有回复
    * @Param: [] 
    * @return: java.util.List<zyy.campuscommunity.entity.Reply> 
    * @Author: zhaoyy
    * @Date: 2019/5/6 13:35
    */ 
    public List<Reply> selectAllReply() {
        return replyMapper.selectAllReply();
    }

    @Override
    /** 
    * @Description: 获取最后一个回复的索引id，用来设置下一个回复的索引id，以便删除评论时好删除
    * @Param: [] 
    * @return: int 
    * @Author: zhaoyy
    * @Date: 2019/5/7 15:07
    */ 
    public int getLastReplyId() {
        //select max(id) from reply
        return replyMapper.getLastReplyId();
    }
}
