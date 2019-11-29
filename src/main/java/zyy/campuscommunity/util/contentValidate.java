package zyy.campuscommunity.util;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Zled
 * @date 2019/5/28 14:57
 */
public class contentValidate {
    public static String SPAM_URL = "https://aip.baidubce.com/rest/2.0/antispam/v2/spam";
    public static void main(String args[]) throws UnsupportedEncodingException {
        contentValidate.check("我打算炸掉人民大会堂");
        //System.out.println(CheckTextApi.check("苟利国家生死以").getResult().getSpam());
    }
    public static SpamBean check(String content) throws UnsupportedEncodingException {
        SpamBean spamBean = new SpamBean();
        String access_token = AuthService.getAuth();
        String passStr = content;  //用于如果不违禁，直接输出
        content = "content=" + content;
        StringBuilder sb = new StringBuilder();
        try {
            String result = HttpUtil.post(SPAM_URL, access_token, content);
            spamBean = JSON.parseObject(result, SpamBean.class);
            int spam = spamBean.getResult().getSpam();
            System.out.println("是否违禁标识(0表示非违禁，1表示违禁，2表示建议人工复审):"+spam);
            if(spam==0){
                System.out.println("审核通过:具体内容为"+passStr);
            }
            if(spam==1){
                System.out.println("内容违禁");
                List rejectList = spamBean.getResult().getReject();
                for (Object o : rejectList) {
                    SpamBean.Reject reject = JSON.parseObject(String.valueOf(o), SpamBean.Reject.class);
                    sb = sb.append(String.valueOf(reject.getLabel())+";");
                }
                System.out.println("违禁类型："+sb.toString());
            }
            if(spam==2){
                System.out.println("建议人工复审");
                Object adviseStr = spamBean.getResult().getReview().get(0);
                SpamBean.Reject advise = JSON.parseObject(String.valueOf(adviseStr), SpamBean.Reject.class);
                System.out.println("复审类型："+advise.getLabel());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spamBean;
    }
}
