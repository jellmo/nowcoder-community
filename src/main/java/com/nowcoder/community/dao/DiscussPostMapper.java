package com.nowcoder.community.dao;

import com.nowcoder.community.model.entity.DiscussPost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jellmo
 * @date: 2022/10/31 22:16
 */
@Repository
public interface DiscussPostMapper {

    /**
     * 查询讨论帖文集合，userId若为0则代表显示所有帖文。
     *
     * @param userId 帖文作者
     * @param offset 当前页码数应显示的帖文在数据库中的起始行
     * @param limit  每一页帖文数量
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 查询帖文总数
     *
     * @param userId 帖文作者id
     * @return 帖文总数
     */
    int selectDiscussPostRows(int userId);
}
