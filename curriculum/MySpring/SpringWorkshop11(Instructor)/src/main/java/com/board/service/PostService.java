package com.board.service;

import com.board.entity.Post;
import com.board.event.PostCreatedEvent;
import com.board.event.PostDeletedEvent;
import com.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ApplicationEventPublisher publisher;

    public Post create(Post post) {
        Post saved = postRepository.save(post);
        publisher.publishEvent(new PostCreatedEvent(saved.getTitle()));
        return saved;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
        publisher.publishEvent(new PostDeletedEvent(id));
    }
}
