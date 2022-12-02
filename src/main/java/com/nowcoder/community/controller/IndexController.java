package com.nowcoder.community.controller;

import com.nowcoder.community.model.entity.DiscussPost;
import com.nowcoder.community.model.entity.User;
import com.nowcoder.community.model.vo.PageVo;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页视图层
 *
 * @author jellmo
 * @date 2022/12/2 23:14
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private DiscussPostService discussPostService;

    /**
     * 首页获取api
     * <p>
     * 注：函数调用之前，springMVC的DispatcherServlet前端控制器会自动实例化参数列表（model和page），并将
     * page注入到model中，因此函数中可以略去model注入page这一步，并且thymeleaf可以直接访问page对象中的数据。
     * (默认按照类名注入对象，thymeleaf调用需要用pageVo，所以我们这里还是注入一下，这样后续调用即可用page)
     *
     * @param model 视图渲染对象
     * @param page  分页对象
     * @return 首页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, PageVo page) {
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        // 默认渲染前10条帖文数据
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        // 将贴文信息与作者信息对应起来
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                User user = userService.findUserById(post.getUserId());
                HashMap<String, Object> map = new HashMap<>();
                map.put("post", post);
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        model.addAttribute("page", page);
        return "/index";
    }
}
