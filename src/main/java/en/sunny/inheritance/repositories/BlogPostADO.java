package en.sunny.inheritance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import en.sunny.inheritance.entities.BlogPost;

@RepositoryRestResource(path="blogposts")
public interface BlogPostADO extends JpaRepository<BlogPost, Long> {

}
