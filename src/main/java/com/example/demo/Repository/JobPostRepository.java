package com.example.demo.Repository;

import com.example.demo.Model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String> {
}
