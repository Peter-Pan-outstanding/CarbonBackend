package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.dto.ArticleWithAttachment;
import wtc.carbon.carbonbackend.entity.Article;
import wtc.carbon.carbonbackend.entity.Attachment;
import wtc.carbon.carbonbackend.mapper.ArticleMapper;
import wtc.carbon.carbonbackend.service.ArticleService;
import wtc.carbon.carbonbackend.service.AttachmentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private AttachmentService attachmentService;

    private ArticleWithAttachment toArticleWithAttachment(Article article, List<Attachment> attachments) {
                return new ArticleWithAttachment(
                        article.getId(),
                        article.getTitle(),
                        article.getDocumentNumber(),
                        article.getIssuingDepartment(),
                        article.getPublishDate(),
                        article.getType(),
                        article.getContent(),
                        attachments,
                        article.getCreatedAt(),
                        article.getUpdatedAt()
                        );

    }

    @Override
    public List<ArticleWithAttachment> getAllArticles() {
        ArrayList<ArticleWithAttachment> articleWithAttachments = new ArrayList<>();

        List<Article> articles = articleMapper.getAllArticles();
        for (Article article : articles) {
            List<Attachment> attachments = attachmentService.getAttachmentsByArticleId(article.getId());
            articleWithAttachments.add(toArticleWithAttachment(article, attachments));
        }

        return articleWithAttachments;
    }

    @Override
    public List<ArticleWithAttachment> getAllArticlesByType(Integer type) {
        ArrayList<ArticleWithAttachment> articleWithAttachments = new ArrayList<>();
        String strType; // 因为就三个类型，直接写死了
        if (type == 0){
            strType = "政策发布";
        } else if (type == 1){
            strType = "工作通知";
        } else if (type == 2){
            strType = "新闻咨询";
        } else {
            return null;
        }

        List<Article> articles = articleMapper.getArticlesByType(strType);
        for (Article article : articles) {
            List<Attachment> attachments = attachmentService.getAttachmentsByArticleId(article.getId());
            articleWithAttachments.add(toArticleWithAttachment(article, attachments));
        }

        return articleWithAttachments;
    }
}
