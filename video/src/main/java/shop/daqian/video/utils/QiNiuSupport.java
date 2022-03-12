package shop.daqian.video.utils;

import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shop.daqian.video.config.QiNiuConfigBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @Author daqian
 * @create 2022/1/20 16:45
 */
@Service
@Slf4j
public class QiNiuSupport {
    @Autowired
    private UploadManager uploadManager;

//    @Autowired
//    private BucketManager bucketManager;

    @Autowired
    private Auth auth;
    /**
     * 最大尝试次数
     */
    public static final Integer maxReTry = 3;
    /**
     * 七牛云操作成功状态码
     */
    public static final Integer successCode = 200;

    public String uploadImage(MultipartFile multipartFile) throws Exception {
        final File file = multipartFileToFile(multipartFile);
        String lastName = file.getName().substring(file.getName().lastIndexOf("."));
        String ImgName = UUID.randomUUID().toString().replaceAll("-", "")+lastName;
        Response response = this.uploadManager.put(file, ImgName, getUploadToken());

//        imgUrl = qiniuInfo.getDomain() + putRet.hash;
        //        int retry = 0;
//        while (response.needRetry() && retry < maxReTry) {
//            log.info("当前操作需要进行重试，目前重试第{}次", retry + 1);
//            response = this.uploadManager.put(file, randomImgName, getUploadToken());
//            retry++;
//        }
        if (file.exists()){
            file.delete();
        }
        if (response.statusCode == successCode) {
            return new StringBuffer().append(QiNiuConfigBean.getProtocol())
                    .append(QiNiuConfigBean.getImgDomain()).append("/").append(ImgName).toString();
        }
        return "上传失败!";
    }

    public String uploadVideo(MultipartFile multipartFile) throws Exception {

        String ImgName = UUID.randomUUID().toString().replaceAll("-", "");
        InputStream byteInputStream = multipartFile.getInputStream();
        Response response = this.uploadManager.put(byteInputStream,ImgName, getUploadToken(),null,null);
//........................这里是文件上传文件显示上传进度

//        if (file.exists()){
//            file.delete();
//        }
        if (response.statusCode == successCode) {
            return new StringBuffer().append(QiNiuConfigBean.getProtocol())
                    .append(QiNiuConfigBean.getImgDomain()).append("/").append(ImgName).toString();
        }
        return "上传失败!";
    }
    /**
     * 获取ImgBucket上传凭证
     *
     * @return
     */
    private String getUploadToken() {
        return this.auth.uploadToken(QiNiuConfigBean.getImgBucket());
    }
    /**
     * MultipartFile 转file
     *
     * @param file
     * @return
     * @throws Exception
     */
    public File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }
    //获取流文件
    private void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
