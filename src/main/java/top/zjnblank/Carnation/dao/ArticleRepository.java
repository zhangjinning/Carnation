package top.zjnblank.Carnation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zjnblank.Carnation.entity.TbArticle;

public interface ArticleRepository extends JpaRepository<TbArticle, String> {
}
