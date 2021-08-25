package com.kaikai.digitalgame.web.controller.taskapi;

import com.kaikai.digitalgame.assembly.download.DownloadUtils;
import net.lingala.zip4j.exception.ZipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author kaikai
 * @createTime 2021年07月01日 14:53
 * @Description : 为任务提供url从而获取任务的执行情况
 */
@Controller
@RequestMapping("taskapi")
public class ApiController {

    int cunt=0;

    @RequestMapping("{taskid}/result")
    @CrossOrigin
    @ResponseBody
    public String testapi(@PathVariable("taskid") String id){
        Logger logger = LoggerFactory.getLogger(ApiController.class);
        String key = null;
        if("ideakey".equalsIgnoreCase(id)){
            String fileName = "temp.zip";
            String srcUrl = "https://idea.medeming.com/a/jihuoma1.zip";
            String s;
            Map<String, String> zip = null;
            try {
                s=DownloadUtils.downloadFile(fileName, srcUrl);
                zip = DownloadUtils.previewFile(new File(s), "zip");
            } catch (ZipException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(Map.Entry<String,String> entry:zip.entrySet()){
                String str = entry.getKey();
                String[] strings = str.split("2");
                if(strings.length==3){
                    key=entry.getValue();
                }
            }
        }
        logger.info("0.0.3版本下该接口被调用了"+ ++cunt +"次");
        return key;
    }
}
