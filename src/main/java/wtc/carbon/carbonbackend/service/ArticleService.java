package wtc.carbon.carbonbackend.service;


import wtc.carbon.carbonbackend.dto.ArticleWithAttachment;

import java.util.List;

public interface ArticleService {

    // 获取所有的文章
    List<ArticleWithAttachment> getAllArticles();

    // 根据类型获取文章
    List<ArticleWithAttachment> getAllArticlesByType(Integer type);


}
