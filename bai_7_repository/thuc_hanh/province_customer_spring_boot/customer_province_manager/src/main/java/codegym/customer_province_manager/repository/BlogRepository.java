package codegym.customer_province_manager.repository;

import codegym.customer_province_manager.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findBlogByCategoryId(Long id ,Pageable pageable);

    Page<Blog> findBlogByNameContaining(String name, Pageable pageable);
}
