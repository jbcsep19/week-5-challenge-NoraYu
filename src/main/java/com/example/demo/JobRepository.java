package com.example.demo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface JobRepository extends CrudRepository<Job, Long>
{
        ArrayList<Job> findByContentContainingIgnoreCaseOrTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String s1, String s2, String s3);

}