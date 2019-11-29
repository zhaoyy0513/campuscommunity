package zyy.campuscommunity.util;

import java.util.List;

/**
 * @author Zled
 * @date 2019/5/28 15:47
 */
public class SpamBean {
    //服务内部计算返回标识
    private int errno;
    //数据集
    private Result result;
    //调用生成的唯一标识码，用于问题定位
    private long logid;

    @Override
    public String toString() {
        return "SpamBean{" +
                "errno=" + errno +
                ", result=" + result +
                ", logid=" + logid +
                '}';
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public long getLogid() {
        return logid;
    }

    public void setLogid(long logid) {
        this.logid = logid;
    }

    public static class Result {
        //请求中是否包含违禁，0表示非违禁，1表示违禁，2表示建议人工复审
        private int spam;
        //审核未通过的类别列表与详情
        private List reject;
        //命中的违禁词集合，可能为空
        private List review; //待人工复审的类别列表与详情

        public int getSpam() {
            return spam;
        }

        public List getReject() {
            return reject;
        }

        public List getReview() {
            return review;
        }

        public void setSpam(int spam) {
            this.spam = spam;
        }

        public void setReject(List reject) {
            this.reject = reject;
        }

        public void setReview(List review) {
            this.review = review;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "spam=" + spam +
                    ", reject=" + reject +
                    ", review=" + review +
                    '}';
        }
    }

    public static class Reject {
        double score;
        List hit;
        int label;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List getHit() {
            return hit;
        }

        public void setHit(List hit) {
            this.hit = hit;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Reject{" +
                    "score=" + score +
                    ", hit=" + hit +
                    ", label=" + label +
                    '}';
        }
    }


}