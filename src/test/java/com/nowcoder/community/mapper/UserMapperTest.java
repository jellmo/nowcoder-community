package com.nowcoder.community.mapper;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author: jellmo
 * @date: 2022/10/25 0:03
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
//        System.out.println(userMapper.selectById(1));
//        System.out.println(userMapper.selectByName("liubei"));
        System.out.println(userMapper.selectByEmail("nowcoder101@sina.com"));
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("test1");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/101t.png");
        user.setCreateTime(new Date());

        userMapper.insertUser(user);
    }

    @Test
    public void testUpdate(){
        User user = userMapper.selectById(151);
        System.out.println(user);
        System.out.println(userMapper.updateHeader(151, "http://images.nowcoder.com/head/150t.png"));
        System.out.println(userMapper.updateStatus(151, 1));
        System.out.println(userMapper.updatePassword(151, "hello"));
        user = userMapper.selectById(151);
        System.out.println(user);
    }
}