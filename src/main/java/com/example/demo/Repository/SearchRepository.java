package com.example.demo.Repository;

import com.example.demo.Model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {
    List<JobPost> findByText(String text);
}
