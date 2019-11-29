package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.entity.TabExample;
import zyy.campuscommunity.mapper.TabMapper;
import zyy.campuscommunity.service.TabService;
import java.util.List;

@Service
public class TabServiceImpl implements TabService {
    @Autowired
    TabMapper tabMapper;
    @Override
    public List<Tab> getTabsByParentId(int parentId) {
        TabExample tabExample = new TabExample();
        TabExample.Criteria criteria = tabExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<Tab> list = tabMapper.selectByExample(tabExample);
        return list;
    }

    @Override
    public List<Tab> getAllTabs() {
        List<Tab> list =  tabMapper.selectAllTabs();
        return list;
    }

    @Override
    public Tab getTabById(int id) {
        Tab tab = tabMapper.selectByPrimaryKey(id);
        return tab;
    }

    @Override
    public List<Tab> getTabsByLike(String likeStr) {
        TabExample example = new TabExample();
        TabExample.Criteria criteria = example.createCriteria();
        likeStr = "%"+likeStr+"%";
        criteria.andTabNameLike(likeStr);
        return tabMapper.selectByExample(example);
    }

    @Override
    public int insertTab(Tab tab) {
         int result = tabMapper.insert(tab);
         if(result<0){
             return -1;
         }else{
             return 0;
         }
    }

    @Override
    public int getTabParentIdByTabId(int id) {
        Tab tab = tabMapper.selectByPrimaryKey(id);
        int parentId = tab.getParentId();
        System.out.println("TabServiceImpl-parentId:"+parentId);
        return parentId ;
    }

    @Override
    public int updateTab(Tab tab) {
        int result = tabMapper.updateByPrimaryKey(tab);
        if(result<0){
            return -1;
        }else{
            return 0;
        }

    }

    @Override
    public int deleteTabById(int id) {
        int result = tabMapper.deleteByPrimaryKey(id);
        if(result<0){
            return -1;
        }else{
            return 0;
        }
    }
}
