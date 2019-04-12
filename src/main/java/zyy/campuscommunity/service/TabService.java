package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Tab;

import java.util.List;

public interface TabService {
    List<Tab> getTabsByParentId(int parentId);

    List<Tab> getAllTabs();

    Tab getTabById(int id);

    int getTabParentIdByTabId(int id);

}
