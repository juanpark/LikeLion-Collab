package com.workshop.dao;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Repository;
import com.workshop.vo.Post;

@Repository
public class PostRepository {
    public List<Post> findAll() {
        return Arrays.asList(new Post(), new Post());
    }
}
