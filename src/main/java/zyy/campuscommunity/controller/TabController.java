package zyy.campuscommunity.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zyy.campuscommunity.entity.BaseResult;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.TabService;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/tab")
@CrossOrigin()
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
        User user = (User)request.getSession().getAttribute("user");
        List<Tab> tabs = tabService.getAllTabs();
        List<Tab> collegetabs = tabService.getTabsByParentId(8); //获取所有学院事务选项，当用户是教师的时候使用
       if(user.getUserRole()!=2){
           //如果用户不是老师就不让其能发布学院事务贴
           for(int i=0;i<collegetabs.size();i++){
               Tab tab = collegetabs.get(i);
               if(tabs.contains(tab)){  //Tab实体类已经重写了equals方法，可以直接判断是否包含
                   int index = tabs.indexOf(tab);
                   tabs.remove(index);
               }
           }
       }
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
        return map;
    }


    //root后台管理根据分页查询标签
    @RequestMapping(value = "/getTabsByPage")
    @ResponseBody
    public BaseResult getTabsByPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "15") Integer rows){
        PageHelper.startPage(page,rows);
        List<Tab> list = tabService.getAllTabs();
        PageInfo<Tab> info = new PageInfo<>(list);
        BaseResult baseResult = new BaseResult();
        baseResult.setTotal(info.getTotal());
        baseResult.setData(info.getList());
        return baseResult;
    }

    //root后台管理用来根据Tid获取单个Tab用于查看和修改
    @RequestMapping(value = "/getTabByIdRoot/{Tid}")
    @ResponseBody
    public Tab getTabByIdRoot(@PathVariable("Tid") int Tid){
        Tab tab = null;
        try{
            tab = tabService.getTabById(Tid);
            return tab;
        }catch (Exception e){
            System.out.println("getTabByIdRoot"+e.getCause().getMessage());
            return tab;
        }
    }

    //root后台管理通过id修改标签信息
    @RequestMapping(value = "/updateTabByIdRoot/{Tid}")
    @ResponseBody
    public String updateTabByIdRoot(@PathVariable("Tid") int Tid, HttpServletRequest request){
        Tab tab = JSON.parseObject(request.getParameter("tab"),Tab.class);
        System.out.println(tab.toString());
        tab.setId(Tid);
        //这里填修改的属性
       int result =  tabService.updateTab(tab);
       if(result<0){
           return "修改失败";
       }else{
           return  "修改成功";
       }
    }

    //root管理界面模糊查询标签
    @RequestMapping(value = "/getTabsByLike/{likeStr}")
    @ResponseBody
    public List<Tab> getTabsByLike(@PathVariable("likeStr") String likeStr){
        List<Tab> tab = new ArrayList<>();
        try{
            return tabService.getTabsByLike(likeStr);
        }catch (Exception e){
            System.out.println("getTabsByLike"+e.getCause().getMessage());
            return tab;
        }
    }

    //通过标签Id进行标签的删除
    @RequestMapping(value = "/deleteTabByIdRoot/{Tid}")
    @ResponseBody
    public String deleteTabByIdRoot(@PathVariable("Tid") int Tid){
        int result = tabService.deleteTabById(Tid);
        if(result<0){
            return "删除失败";
        }else{
            return "删除成功";
        }
    }

    //root添加标签
    @RequestMapping(value = "/insertTabByRoot")
    @ResponseBody
    public String insertTabByRoot(HttpServletRequest request){
        Tab tab = JSON.parseObject(request.getParameter("tab"),Tab.class);
        int result = tabService.insertTab(tab);;
        if(result<0){
            return "添加失败";
        }else{
            return "添加成功";
        }
    }







}
