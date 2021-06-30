package com.kaikai.digitalgame.core.listener;

import com.kaikai.digitalgame.core.listener.thread.FileListener;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kaikai
 * @createTime 2021年06月30日 15:27
 * @Description : 监听器
 */
public class Listener {
    private static ExecutorService fixedThreadPool = Executors.newCachedThreadPool();
    private WatchService watchService;
    private String rootPath;

    /**
     * Listener构造器:初始化监听器并启动监听线程
     * @param rootPath
     */
    private Listener(String rootPath) {
        try {
            watchService = FileSystems.getDefault().newWatchService();
            this.rootPath = rootPath;
            startFileListener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动监听线程
     */
    private void startFileListener() {
        fixedThreadPool.execute(new FileListener(watchService,this.rootPath));
    }

    /**
     * 为目录设置监听器:ENTRY_MODIFY,ENTRY_DELETE,ENTRY_CREATE
     * @param rootPath 需要监听的目录
     * @throws IOException
     */
    public static void setFileListener(String rootPath) throws IOException {
        Listener Listener = new Listener(rootPath);
        Path p = Paths.get(rootPath);
        p.register(Listener.watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_CREATE);
    }
}
