package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.TimeLine;
import zyy.campuscommunity.entity.TimeLineExample;
import zyy.campuscommunity.mapper.TimeLineMapper;
import zyy.campuscommunity.service.TimeLineService;

import java.util.List;

@Service
public class TimeLineServiceImpl implements TimeLineService {
    @Autowired
    TimeLineMapper timeLineMapper;

    @Override
    /*
     * 功能描述: <br>
     * 〈添加时间轴〉
     * @Param: [timeLine]
     * @Return: int
     * @Author: zhaoyy
     * @Date: 2019/5/17 0017 9:17
     */
    public int insertTimeLine(TimeLine timeLine) {
        int result = timeLineMapper.insert(timeLine);
        if(result<0){
            return -1;
        }
        return 0;
    }

    @Override
    /*
     * 功能描述: <br>
     * 〈根据指定的时间轴索引Id进行删除〉
     * @Param: [Tid]
     * @Return: int
     * @Author: zhaoyy
     * @Date: 2019/5/17 0017 9:18
     */
    public int deleteTimeLineByTid(int Tid) {
        int result = timeLineMapper.deleteByPrimaryKey(Tid);;
        if(result<0){
            return -1;
        }
        return 0;
    }

    @Override
    /*
     * 功能描述: <br>
     * 〈通过用户的索引Id获取该用户对应的所有时间轴〉
     * @Param: [Uid]
     * @Return: int
     * @Author: zhaoyy
     * @Date: 2019/5/17 0017 9:19
     */
    public List<TimeLine> getAllTimeLineByUid(int Uid) {
        TimeLineExample example = new TimeLineExample();
        TimeLineExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(Uid);
        return timeLineMapper.selectByExample(example);
    }
}
