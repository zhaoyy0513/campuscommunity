package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.Unread;
import zyy.campuscommunity.mapper.UnreadMapper;
import zyy.campuscommunity.service.UnreadService;

@Service
public class UnreadServiceImpl implements UnreadService {

    @Autowired
    UnreadMapper unreadMapper;
    @Override
    public int insertUnread(Unread unread) {
       int result = unreadMapper.insert(unread);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}