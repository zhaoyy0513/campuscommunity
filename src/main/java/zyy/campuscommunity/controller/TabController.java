package zyy.campuscommunity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.TabService;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/tab")
public class TabController {
    @Autowired
    TabService tabService;
    @Autowired
    PostService postService;

    @ResponseBody
    @RequestMapping(value = "/parentTabId/{id}", method = RequestMethod.POST)
    public Map getTabsById(@PathVariable Integer id,HttpServletRequest request){
        //Map<String,List<SecondTitleToPosts>>
        List<Tab> tabs = tabService.getTabsByParentId(id);
        Map<String,Object> map = new HashMap<>();
        map.put("tabs",tabs);
        Collections.sort(tabs, new Comparator<Tab>() {
            public int compare(Tab o1, Tab o2) {
                return o1.getTabName().length()-o2.getTabName().length();
            }
        });
//        java8引入的Lambda表达式进行根据字符长度把list排序
//        tabs.sort(Comparator.comparing(Tab::getTabName));
        List<Post> list = postService.getPostByParentId(id);
        Iterator<Post> iterator = list.iterator();
        //设置回复时间差值(当前时间减去帖子最后一次回复时间的差值)
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (iterator.hasNext()){
            Post post = iterator.next();
            String now = df.format(date);
            //计算回复的时间差
            Date d1 = null;
            try {
                d1 = df.parse(now);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                Date d2 = df.parse(post.getPostLastReplyTime());
                if(d2!=null){
                    long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
                    long days = diff / (1000 * 60 * 60 * 24);
                    long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                    long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
                    long seconds = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*(1000*60))/1000;
                    if(((int)days)<1){
                        if(((int)hours)<1){
                            if(minutes<1){
                                if(((int)seconds)<=60){
                                    post.setPostLastReplyTimeSimple(""+seconds+"秒之前");
                                }
                            }else{
                                post.setPostLastReplyTimeSimple(""+minutes+"分钟之前");
                            }
                        }else{
                            post.setPostLastReplyTimeSimple(""+hours+"小时"+minutes+"分钟之前"); //设置最后回复时间
                        }
                    }
                    else{
                        post.setPostLastReplyTimeSimple(""+days+"天"+hours+"小时"+minutes+"分钟之前"); //设置最后回复时
                    }
                }
                postService.updatePost(post);  //更新帖子
            }catch (Exception e){
                break;
            }

        }
        if(list.size()!=0){
            System.out.println(list.get(0).toString());
             map.put("posts",list);
        }else{
            map.put("posts","");
        }
        return map;
    }

    
    @ResponseBody
    @RequestMapping(value = "/getAllTabs")
    public Map getAllTabs(HttpServletRequest request,Model model) {
        List<Tab> tabs = tabService.getAllTabs();
        Collections.sort(tabs, new Comparator<Tab>() {
            public int compare(Tab o1, Tab o2) {
                //对tab进行排序，使字数长的放在后面显示
                return o1.getTabName().length()-o2.getTabName().length();
            }
        });
//        tabs.sort(Comparator.comparing(Tab::getTabName));
        Iterator<Tab> iterator = tabs.iterator();
        Map<Integer, String> map = new HashMap<>();
        while (iterator.hasNext()) {
            Tab tab = iterator.next();
            String new_union_name = tab.getTabName();
            //通过id获取父类节点名 tab.getParentId();
            if (tab.getParentId() != 0) {
                Tab parent = tabService.getTabById((int) tab.getParentId());
                new_union_name = parent.getTabName() + "/" + new_union_name;
                //获取孩子的id
                int child_id = tab.getId();
                map.put(child_id, new_union_name);
            }
        }
//        for(Map.Entry entry:map.entrySet()){
//            System.out.println(entry.getKey()+"||"+entry.getValue());
//        }
        return map;
    }

}
