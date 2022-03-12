package shop.daqian.video.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;



/**
 * @Author daqian
 * @create 2021/12/31 11:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultUtil<T> {
    private Integer status;
    private String msg;
    private T data;

    public ResultUtil(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
