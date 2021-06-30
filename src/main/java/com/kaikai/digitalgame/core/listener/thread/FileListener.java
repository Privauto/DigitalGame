package com.kaikai.digitalgame.core.listener.thread;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * @author kaikai
 * @createTime 2021年06月30日 15:41
 * @Description : 监听文件的自定义线程
 */
public class FileListener implements Runnable {

    private WatchService watchService;
    private String rootPath;

    /**
     * FileListener构造器
     * @param watchService 监听服务
     * @param rootPath 根目录
     */
    public FileListener(WatchService watchService,String rootPath) {
        this.watchService = watchService;
        this.rootPath = rootPath;
    }
    /**
     * 重写Runnable的run方法
     */
    @Override
    public void run() {
        try {
            while(true){
                WatchKey watchKey = watchService.take();
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                for(WatchEvent<?> event : watchEvents){
                    //TODO 根据事件类型采取不同的操作。。。。。。。
                }
                watchKey.reset();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {
                watchService.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
