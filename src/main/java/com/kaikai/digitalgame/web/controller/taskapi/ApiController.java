package com.kaikai.digitalgame.web.controller.taskapi;

import com.kaikai.digitalgame.assembly.download.DownloadUtils;
import net.lingala.zip4j.exception.ZipException;
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

    @RequestMapping("{taskid}/result")
    @CrossOrigin
    @ResponseBody
    public String testapi(@PathVariable("taskid") String id){
         String key = null;
        if("ideakey".equalsIgnoreCase(id)){
            String fileName = "temp.zip";
            String srcUrl = "http://idea.medeming.com/a/jihuoma1.zip";
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
            if(zip.containsKey("2018.2之后的版本用这个.txt")){
                key = zip.get("2018.2之后的版本用这个.txt");
            }
        }
        return key;
    }
}
