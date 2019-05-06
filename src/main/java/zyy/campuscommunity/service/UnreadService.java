package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Unread;

import java.util.List;

public interface UnreadService {
     int insertUnread(Unread unread);
     List<Unread> getUnreadsByUid(Integer uid);
     List<Unread> selectAllUnRead();
}