package shop.daqian.video;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import shop.daqian.video.entity.Video;
import shop.daqian.video.mapper.VideoMapper;
import shop.daqian.video.utils.JjwtUtil;

import java.util.List;

//@SpringBootTest
public class VideoApplicationTests {
//private static final JjwtUtil jjwtUtil = new JjwtUtil();
//    private static String token ;
//    @Test
// public void contextLoads() {
//        token = jjwtUtil.createToken(123L);
//        System.out.println(token);
////        System.out.println(jjwtUtil.checkToken(token));
//    }
//    @Test
//    public void test() {
//        System.out.println(jjwtUtil.checkToken("eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NDIwODIxMjQsInVzZXJJZCI6MTIzfQ.CDCe_0GKl7VzGcQRP3nAM73fyM_dYWg76ma7JlWOGtccnaE2T6NcvAwBi_fw4dWkRgdxRvkbZnXR5e4vFGlM0g"));
//    }

//多对多查询
//    SELECT v.video_id, vc.category_name
//    FROM video v
//    INNER JOIN video_transform_category vtc ON v.video_id = vtc.video_id
//    INNER JOIN video_category vc ON vtc.category_id=vc.category_id




}
