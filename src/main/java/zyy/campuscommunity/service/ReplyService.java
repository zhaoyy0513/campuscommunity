package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Reply;

import java.util.List;

public interface ReplyService {
    int insertReply(Reply reply);
    int getLastReplyId();  //select max(id) from reply
    int updateReply(Reply reply);
    int deleteReplyById(int Rid);
    int deleteReplyByPid(int pid);
    List<Reply> getRepliesByPostId(int postId);
    List<Reply> selectAllReply();

}
