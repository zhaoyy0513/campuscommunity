package zyy.campuscommunity.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zyy.campuscommunity.entity.TimeLine;
import zyy.campuscommunity.service.TimeLineService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/timeline")
public class TimeLineController {
    @Autowired
    TimeLineService timeLineService;

    @RequestMapping(value = "/insertTimeLine")
    @ResponseBody
    /*
     * 功能描述: <br>
     * 〈添加时间轴，参数都由前台传递而来〉
     * @Param: [content, Uid]
     * @Return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/17 0017 9:28
     */
    public String insertTimeLine(int Uid,String content){
        System.out.println("进入成功!"+Uid);
        System.out.println("timeLineContent:"+content);
        TimeLine timeLine = new TimeLine();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
        String releaseTime = sdf.format(date);
        timeLine.setContent(content);
        timeLine.setUserId(Uid);
        timeLine.setReleaseTime(releaseTime);
        int resultI = timeLineService.insertTimeLine(timeLine);
        if(resultI<0){
            System.out.println("时间轴插入失败");
            return JSONObject.toJSONString("error");
        }
        return JSONObject.toJSONString("success");
    }

    @RequestMapping("/deleteTimeLine/{tid}")
    @ResponseBody
    /*
     * 功能描述: <br>
     * 〈根据时间轴的索引Id进行删除〉
     * @Param: [Tid]
     * @Return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/17 0017 9:39
     */
    public String deleteTimeLineByTid(@PathVariable("tid") int Tid){
        int resultD = timeLineService.deleteTimeLineByTid(Tid);
        if(resultD<0){
            System.out.println("删除时间轴失败");
            return JSONObject.toJSONString("error");
        }
        return JSONObject.toJSONString("success");
    }
}
