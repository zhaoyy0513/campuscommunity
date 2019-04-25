package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Focus;

/**
 * @program: campuscommunity
 * @description: 关注这个功能的实体类对应接口
 * @author: zhaoyy
 * @create: 2019-04-23 15:31
 */
public interface FocusService {
    int addFocus(Focus focus);
    int deleteFocusByUid(int uid);
    String getFocusUserIdByUid(int user_id);
    Focus getFocusByUid(int user_id);
    int updateFocus(Focus focus);
}