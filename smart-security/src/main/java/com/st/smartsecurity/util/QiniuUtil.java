package com.st.smartsecurity.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author 创建人:< Chenmq>
 * @project 项目:<>
 * @date 创建时间:< 2017/8/30>
 * @comments: 说明:< //七牛云图片配置 >
 */
public class QiniuUtil {
    private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);



    //设置好账号的ACCESS_KEY和SECRET_KEY
    final String ACCESS_KEY = "6U0DOoNMCSCWX6ptpbgEcNm4TC7DGGbVod8ebZJt";
    final String SECRET_KEY = "qRvKNoVdFtB8ZtmJCjpf1bi6I2CQZKJJc-s5J4-6";
    //要上传的空间
    final String BUCKET_NAME = "ssjsj";

    /**
     * 七牛云上传图片
     * @param localFilePath
     * @return
     */
    public String uoloapQiniu (File localFilePath,String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg;
        cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = ACCESS_KEY;
        String secretKey = SECRET_KEY;
        String bucket = BUCKET_NAME;
        //如果是Windows情况下，格式是 D:\23912475_130759767000_2.jpg
//        String localFilePath = "D:\\23912475_130759767000_2.jpg";
        //        String localFilePath = "/home/qiniu/test.png";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "images/"+"tId="+System.currentTimeMillis()+fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        String result = null;

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            logger.info("{七牛图片上传key: "+ putRet.key+",七牛图片上传hash: "+ putRet.hash+"}");

            result = "qiniu.iwooke.com/"+putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            result = null;
        }
        return result;
    }
    public void copyFile(File s1){
        File file2 = new File("D:/test");
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(s1);
            out = new FileOutputStream(file2);
            byte[] data = new byte[1024];
            int length = -1;
            while ((length=in.read(data)) != -1) {
                out.write(data, 0, length);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
