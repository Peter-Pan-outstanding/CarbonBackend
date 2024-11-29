package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.dto.ArticleWithAttachment;
import wtc.carbon.carbonbackend.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/getAllArticles")
    public Result<?> getAllArticles(){
        List<ArticleWithAttachment> allArticles = articleService.getAllArticles();
        if(!allArticles.isEmpty()){
            return Result.success(allArticles);
        } else {
            return Result.error(400,"获取文章失败，请联系管理员");
        }
    }

    @GetMapping("/getArticlesByType/{type}")
    public Result<?> getArticlesByType(@PathVariable Integer type){
        List<ArticleWithAttachment> allArticles = articleService.getAllArticlesByType(type);
        if(!allArticles.isEmpty()){
            return Result.success(allArticles);
        } else {
            return Result.error(404,"获取文章失败，类型错误");
        }
    }
}
