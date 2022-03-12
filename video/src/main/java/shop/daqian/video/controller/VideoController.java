package shop.daqian.video.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.User;
import shop.daqian.video.entity.Video;
import shop.daqian.video.mapper.VideoMapper;
import shop.daqian.video.utils.ResultUtil;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/2/8 16:27
 */
@CrossOrigin
@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    VideoMapper videoMapper;

    /**
     * 获取全部视频信息
     * @return
     */
    @GetMapping
    public List<Video> getUserAll(@Param("kw") String kw){
        return videoMapper.getVideoAll(kw);
    }

    /**
     * 获取banner视频信息
     * @return
     */
    @GetMapping("banner")
    public List<Video> getVideoByBanner(){
        return videoMapper.getVideoByBanner();
    }
    /**
     * 添加视频
     * @param video
     * @return
     */
    @PostMapping
    public ResultUtil save(@RequestBody Video video){
//        System.out.println(video);
        videoMapper.save(video);
        return new ResultUtil(200,"视频添加成功");
    }

}
