package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.model.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jellmo
 * @date: 2022/12/2 22:58
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper postMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return postMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return postMapper.selectDiscussPostRows(userId);
    }


}
