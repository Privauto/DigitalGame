package com.kaikai.digitalgame.assembly.download;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author kaikai
 * @createTime 2021年07月01日 15:49
 * @Description : 下载工具类
 */
public class DownloadUtils {
    /**
     * 使用HttpClient下载远程服务器中的文件
     * @param fileName 存至本地的文件名
     * @param srcUrl 需要下载的文件的url
     * @return 已下载文件的路径
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static String downloadFile(String fileName, String srcUrl) throws ExecutionException, InterruptedException {
        String tempPathW = File.separator+"DG"+File.separator+"DigitalGame";
        String tempPathL = File.separator+"DG";
        String filePath = System.getProperty("user.dir").replace(tempPathW,"").replace(tempPathL,"")+File.separator+"storage"+File.separator+"temp"+File.separator;
        File file = new File(filePath+fileName);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(srcUrl)).build();
        HttpResponse.BodyHandler<Path> bodyHandler = HttpResponse.BodyHandlers.ofFile(file.toPath());
        CompletableFuture<HttpResponse<Path>> sendAsync = httpClient.sendAsync(request, bodyHandler);
        String path = sendAsync.get().body().toString();
        return path;
    }

    /**
     * 预览文件的内容
     * @param file
     * @param fileType
     * @return
     * @throws ZipException
     * @throws IOException
     */
    public static Map<String, String> previewFile(File file, String fileType) throws ZipException, IOException {
        HashMap<String, String> messageMap = new HashMap<>();
        switch (fileType){
            case DownloadConstant.FILE_TYPE_ZIP:
                previewZip(file,messageMap);
                break;
            default:
                break;
        }
        return messageMap;
    }

    /**
     * 预览zip
     * @param file
     * @param messageMap
     * @throws ZipException
     * @throws IOException
     */
    private static void previewZip(File file, HashMap<String, String> messageMap) throws ZipException, IOException {
        ZipFile zFile = new ZipFile(file);
        // 设置字符集
        zFile.setFileNameCharset("GBK");
        if (!zFile.isValidZipFile()) {
            throw new ZipException("压缩文件不合法,可能被损坏.");
        }
        // 获取ZIP中所有文件的FileHeader,以便后面对zip中文件进行遍历
        List<FileHeader> list = zFile.getFileHeaders();
        for (FileHeader fileHeader : list) {
            String fileName = fileHeader.getFileName();
            // fileName会将目录单独读出来，而且带有路径分割符
            if (fileName.endsWith("/") || fileName.endsWith("\\\\") || fileName.endsWith("\\")) {
                continue;
            }else {
                ZipInputStream is = zFile.getInputStream(fileHeader);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                StringBuffer message =new StringBuffer();
                while ((line = br.readLine()) != null) {
                    message.append(line);
                }
                messageMap.put(fileName,message.toString());
                //Java11用try关闭流
                try(br){ }
            }
        }
    }
}
