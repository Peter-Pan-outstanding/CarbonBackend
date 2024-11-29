package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.AnnouncementTitle;
import wtc.carbon.carbonbackend.service.AnnouncementTitleService;

import java.util.List;

@RestController
@RequestMapping("/announcementTitle")
public class AnnouncementTitleController {

    @Resource
    private AnnouncementTitleService announcementTitleService;

    @GetMapping("/getAnnouncementTitlesByCategoryWithPagination")
    public Result<?> getAnnouncementTitlesByCategory(
            Integer category,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize
    ) {


        List<AnnouncementTitle> titles = announcementTitleService.getAnnouncementTitlesByCategoryWithPagination(category, pageNumber, pageSize);
        if (titles.isEmpty()) {
            return Result.error(400,"没有这样的分类，请重试");
        } else {
            return Result.success(titles);
        }
    }


}
