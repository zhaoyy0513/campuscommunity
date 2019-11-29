package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Tab;

import java.util.List;

public interface TabService {

    int insertTab(Tab tab);

    int getTabParentIdByTabId(int id);

    int updateTab(Tab tab);

    int deleteTabById(int id);

    Tab getTabById(int id);

    List<Tab> getTabsByLike(String likeStr);

    List<Tab> getTabsByParentId(int parentId);

    List<Tab> getAllTabs();





}
