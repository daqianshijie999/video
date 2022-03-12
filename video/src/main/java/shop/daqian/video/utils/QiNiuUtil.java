package shop.daqian.video.utils;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;


import java.io.*;
import java.util.Map;
import java.util.UUID;


/**
 * @Author daqian
 * @create 2022/1/18 10:48
 */
public class QiNiuUtil {

    //AccessKey
    public static String ACCESS_KEY = "hIRXrHaR-dHFrylIjllFVTRp9AplX-E9c9u_eAaR";

    //SecretKey
    public static String SECRET_KEY = "dYdGMbSYpVjTuPgAkrjU9XNbaLapU8N4IhGsFO7I";

    public static String qiniu_img_url_pre = "http://img.daqian.shop/";
    //存储空间名称
    public static String bucketname_img = "img-daqian";


//    public static String qiniu_video_url_pre = "http://video.daqian.shop";
//    //存储空间名称
//    public static String bucketname = "Video-daqian";

    /**
     * 上传文件
     */
    public static String upload2Qiniu(FileInputStream file, String uploadFileName) {
        //构造一个带指定Zone对象的配置类,Zone.zone0()代表华东地区
        //zone2() 华南
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = uploadFileName;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucketname_img);
        try {
            Response response = uploadManager.put(file, key, upToken, null, null);
            //解析上传成功的结果
            String bodyString = response.bodyString();
            Map map = JSON.parseObject(bodyString, Map.class);
            String hash = (String) map.get("key");
            if (hash!=null) {
                return qiniu_img_url_pre + uploadFileName;
            }
            System.out.println(response.bodyString());
            // 访问路径
            System.out.println(qiniu_img_url_pre + uploadFileName);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
                return null;
            } catch (QiniuException ex2) {
                ex.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * 下载文件
     * @param url 文件在七牛云服务器上的地址
     * @return
     */
    public static byte[] downloadFromQNY(String url) {
//        url ="http://q8w1mid5i.bkt.clouddn.com/893ab9c335cb472cb0a956840f75d46c.pdf";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            okhttp3.Response resp = client.newCall(request).execute();
            if (resp.isSuccessful()) {
                ResponseBody body = resp.body();
                InputStream inputStream = body.byteStream();
                ByteArrayOutputStream writer = new ByteArrayOutputStream();
                byte[] buff = new byte[1024 * 2];
                int len = 0;
                try {
                    while ((len = inputStream.read(buff)) != -1) {
                        writer.write(buff, 0, len);
                    }
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return writer.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\shinelon\\Desktop\\Video\\image\\bg.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        if (!file.isDirectory()){
            file.mkdirs();
        }
        String randomName = UUID.randomUUID().toString();
        upload2Qiniu(fileInputStream,randomName+".jpg");
//        downloadFromQNY(qiniu_img_url_pre + "001pvu2Mzy7gpBAJqQIa4.jpg");
    }

}


