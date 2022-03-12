package shop.daqian.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.daqian.video.utils.QiNiuSupport;
import shop.daqian.video.utils.QiNiuUtil;

import java.io.FileInputStream;
import java.util.UUID;

/**
 * @Author daqian
 * @create 2022/1/18 11:37
 */
@RestController
@RequestMapping("qiniu")
public class QiNiuController {

    @Autowired
    private QiNiuSupport qiNiuSupport;
    /***
     *
     * @param file
     * 图片上传接口
     * @return
     */
    @PostMapping("/img/upload")
    public String uploadImage(@RequestParam("image")MultipartFile file) throws Exception {
         return qiNiuSupport.uploadImage(file);
    }

    /**
     * 视频上传接口
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/video/upload")
    public String uploadVideo(@RequestParam("video")MultipartFile file) throws Exception {
        return qiNiuSupport.uploadVideo(file);
    }
}
