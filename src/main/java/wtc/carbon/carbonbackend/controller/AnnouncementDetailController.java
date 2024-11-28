package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.dto.AnnouncementDetailWithAttachment;
import wtc.carbon.carbonbackend.entity.AnnouncementDetail;
import wtc.carbon.carbonbackend.service.AnnouncementDetailService;

@RestController
@RequestMapping("/announcementDetail")
public class AnnouncementDetailController {

    @Resource
    private AnnouncementDetailService announcementDetailService;


    @GetMapping("/getAnnouncementDetailById/{id}")
    public Result<?> getAnnouncementDetailById(@PathVariable int id) {
        AnnouncementDetailWithAttachment detail = announcementDetailService.getAnnouncementDetailById(id);
        if (detail == null) {
            return Result.error(400,"文章id有误，请重试");
        }

        return Result.success(announcementDetailService.getAnnouncementDetailById(id));
    }


}
