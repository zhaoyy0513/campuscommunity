package zyy.campuscommunity.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.service.ReplyService;
import zyy.campuscommunity.service.TabService;
import zyy.campuscommunity.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampuscommunityApplicationTests {
    @Autowired
    ReplyService replyService;

    @Test
    public void testCount(){
        int result = replyService.getLastReplyId();
        System.out.println(result);
    }


}
