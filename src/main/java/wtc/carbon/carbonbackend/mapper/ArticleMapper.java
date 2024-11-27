package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> getAllArticles();

    List<Article> getArticlesByType(String type);
}
