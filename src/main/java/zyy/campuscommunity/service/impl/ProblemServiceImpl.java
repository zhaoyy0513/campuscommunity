package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.Problem;
import zyy.campuscommunity.entity.ProblemExample;
import zyy.campuscommunity.mapper.ProblemMapper;
import zyy.campuscommunity.service.ProblemService;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    ProblemMapper problemMapper;

    @Override
    /**
     * @Description: 获取所有的问题
     * @Param:
     * @return: List<Problem>
     * @Author: zhaoyy
     * @Date: 2019/5/13 09:59
     */
    public List<Problem> getAllProblem() {
        return problemMapper.getAllProblem();
    }

    @Override
    /**
     * @Description: 通过索引Id获取问题
     * @Param:
     * @return: Problem
     * @Author: zhaoyy
     * @Date: 2019/5/14 19:09
     */
    public Problem getProblemById(int Pid) {
        ProblemExample problemExample = new ProblemExample();
        ProblemExample.Criteria criteria = problemExample.createCriteria();
        criteria.andIdEqualTo(Pid);
        return problemMapper.selectByExample(problemExample).get(0);
    }
}
