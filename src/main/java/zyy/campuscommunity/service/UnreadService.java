package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Unread;

import java.util.List;

public interface UnreadService {
     Unread getUnreadById(int id);
     int insertUnread(Unread unread);
     int deleteUnreadById(int id);
     int deleteUnreadByPid(int Pid);
     List<Unread> getUnreadsByUid(Integer uid);
     List<Unread> selectAllUnRead();
}