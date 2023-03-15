package com.kaikai.digitalgame.web;

import com.kaikai.digitalgame.assembly.download.DownloadUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;

/**
 * @author kaikai
 * @createTime 2022年05月12日 17:17
 * @Description :
 */
@Configuration
@EnableScheduling
public class Task {
    @Scheduled(cron = "0 0 12 * * ?")
    private void cleanZip(){
        String tempPathW = File.separator+"DG"+File.separator+"DigitalGame";
        String tempPathL = File.separator+"DG";
        String filePath = System.getProperty("user.dir").replace(tempPathW,"").replace(tempPathL,"")+File.separator+"storage"+File.separator+"temp"+File.separator;
        File file = new File(filePath+"temp.zip");
        if(file.exists()){
            file.delete();
        }
    }
}
