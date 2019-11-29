package zyy.campuscommunity.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import zyy.campuscommunity.entity.*;
import zyy.campuscommunity.service.*;
import zyy.campuscommunity.util.AuthService;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampuscommunityApplicationTests {
    @Autowired
    PostService postService;

    @Test
    public void getCollegeDistribute(){
        System.out.println(AuthService.getAuth());
    }



}
