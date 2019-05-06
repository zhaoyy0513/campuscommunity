package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Reply;

import java.util.List;

public interface ReplyService {
    int insertReply(Reply reply);
    List<Reply> getRepliesByPostId(int postId);
    int updateReply(Reply reply);
    List<Reply> selectAllReply();
}
