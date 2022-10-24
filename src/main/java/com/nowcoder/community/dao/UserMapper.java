package com.nowcoder.community.dao;

import com.nowcoder.community.model.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author: jellmo
 * @date: 2022/10/24 23:23
 */
@Repository
public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户详细信息
     */
    User selectById(Integer id);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户详细信息
     */
    User selectByName(String username);

    /**
     * 根据用户邮箱查询用户
     *
     * @param email 用户邮箱
     * @return 用户详细信息
     */
    User selectByEmail(String email);

    /**
     * 新增用户
     *
     * @param user 用户详细信息
     * @return 修改记录数
     */
    int insertUser(User user);

    /**
     * 根据id修改用户状态
     *
     * @param id     用户id
     * @param status 用户新状态
     * @return 修改记录数
     */
    int updateStatus(int id, int status);

    /**
     * 根据id修改用户头像
     *
     * @param id        用户id
     * @param headerUrl 用户头像地址
     * @return 修改记录数
     */
    int updateHeader(int id, String headerUrl);

    /**
     * 根据id修改用户头像
     *
     * @param id       用户id
     * @param password 用户密码
     * @return 修改记录数
     */
    int updatePassword(int id, String password);
}
