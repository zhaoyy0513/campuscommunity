package zyy.campuscommunity.service;


import zyy.campuscommunity.entity.TimeLine;

import java.util.List;

public interface TimeLineService {
    int insertTimeLine(TimeLine timeLine);
    int deleteTimeLineByTid(int Tid);
    List<TimeLine> getAllTimeLineByUid(int Uid);
}
