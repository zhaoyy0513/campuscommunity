package zyy.campuscommunity.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.service.TabService;
import zyy.campuscommunity.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampuscommunityApplicationTests {
	@Autowired
    TabService tabService;
	@Autowired
    UserService userService;
	@Resource(name="redisTemplate")
    RedisTemplate<String,List> listRedisTemplate;
	@Autowired
    RedisTemplate<String,String> stringRedisTemplate;

	@Test
	public void testList(){
        List<Tab> tabList = (List<Tab>)listRedisTemplate.opsForList().rightPop("tabList");
        if (null==tabList) {
            //如果Redis没有找到这个对应的tabList这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            tabList = tabService.getTabsByParentId(0);
            listRedisTemplate.opsForList().rightPush("tabList",tabList);
            System.out.println("从数据库查询得到tabList");
        } else {
            System.out.println("从Redis查询得到tabList");
        }
        System.out.println(tabList.toString());
    }

    @Test
    public void testString(){
        String userStr = stringRedisTemplate.opsForValue().get("userStr");
        if (null==userStr) {
            //如果Redis没有找到这个对应的user这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            userStr = (userService.getUserById(1)).toString();
            stringRedisTemplate.opsForValue().set("userStr",userStr);
            System.out.println("从数据库查询得到userStr");
        } else {
            System.out.println("从Redis查询得到userStr");
        }
        System.out.println(userStr);
    }


}
