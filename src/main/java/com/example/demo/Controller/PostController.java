package com.example.demo.Controller;

import com.example.demo.Repository.JobPostRepository;
import com.example.demo.Model.JobPost;
import com.example.demo.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    JobPostRepository repo;

    @Autowired
    SearchRepository searchRepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<JobPost> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> search(@PathVariable String text){
        return searchRepo.findByText(text);
    }

    @PostMapping("/post")
    public JobPost addPost(@RequestBody JobPost post){
        return repo.save(post);
    }
}
