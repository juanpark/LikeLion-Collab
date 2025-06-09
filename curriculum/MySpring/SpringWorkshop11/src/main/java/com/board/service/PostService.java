package com.board.service;

import com.board.entity.Post;
import com.board.event.PostCreatedEvent;
import com.board.repository.PostRepository;
import com.board.event.PostDeletedEvent;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ApplicationEventPublisher publisher;
    
    public PostService(PostRepository postRepository, ApplicationEventPublisher publisher) {
        this.postRepository = postRepository;
        this.publisher = publisher;
    }

    public Post createPost(Post post) {
        Post saved = postRepository.save(post);

        System.out.println("서비스 내부 로직 실행 완료");

        publisher.publishEvent(new PostCreatedEvent(saved.getId(), saved.getTitle()));

        System.out.println("이벤트 발행 후 로직 계속 진행됨");

        return saved;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
        publisher.publishEvent(new PostDeletedEvent(id));
    }
}