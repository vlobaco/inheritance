package en.sunny.inheritance.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import en.sunny.inheritance.entidades.BlogPost;

@RepositoryRestResource(path="blog-posts")
public interface BlogPostDAO extends JpaRepository<BlogPost, Long> {

}
