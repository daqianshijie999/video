package shop.daqian.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.Banner;
import shop.daqian.video.mapper.BannerMapper;
import shop.daqian.video.utils.ResultUtil;

import java.util.List;

/**
 * @Author daqian
 * @create 2022/3/10 10:07
 */
//@Slf4j
@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerMapper bannerMapper;

    /**
     * 获取banner轮播图
     * @return
     */
    @GetMapping
    public List<Banner> getBannerList(){
        return bannerMapper.getBannerList();
    }

    @PostMapping
    public ResultUtil save( @RequestBody   List<Banner> list) {
        try {
            bannerMapper.save(list);
    } catch (Exception e) {
        return new ResultUtil(500, "视频banner已存在或异常");
    }
        return new ResultUtil(200, "添加成功");
    }

    @DeleteMapping("{ids}")
    public ResultUtil deleteTypeById(@PathVariable("ids") String ids){
        try {
            bannerMapper.deleteBannerById(ids);
        } catch (Exception e) {
            return new ResultUtil(500,"删除失败");
        }
        return new ResultUtil(200,"删除成功");
    }


}
