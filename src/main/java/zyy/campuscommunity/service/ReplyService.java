package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Reply;

import java.util.List;

public interface ReplyService {
    int insertReply(Reply reply);
    int getLastReplyId();
    int updateReply(Reply reply);
    int deleteReplyById(int id);
    List<Reply> getRepliesByPostId(int postId);
    List<Reply> selectAllReply();

}
