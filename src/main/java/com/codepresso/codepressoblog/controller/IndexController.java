package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.service.PostService;
import org.springframework.ui.Model;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private PostService postService; //객체 선언
    public IndexController(PostService postService) { this.postService = postService; } //생성

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Post> posts = new ArrayList<Post>();
        posts = postService.getPostList(); //생성한 어레이에 get으로 리스트 내용을 가져와서 넣어주기
        model.addAttribute("posts", posts);
        return "index";
    }
}
