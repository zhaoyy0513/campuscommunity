package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Problem;

import java.util.List;

public interface ProblemService {
    List<Problem> getAllProblem();
    Problem getProblemById(int Pid);
}
