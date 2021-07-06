package com.kaikai.digitalgame.assembly.download;

import lombok.Data;

/**
 * @author kaikai
 * @createTime 2021年07月01日 22:08
 * @Description : 下载模块的实体类,具备任务id和下载url等属性
 */
@Data
public class DownloadModule{
    public String taskId;
    public String contentType;
    public String srcUrl;
}
