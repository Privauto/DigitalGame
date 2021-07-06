package com.kaikai.digitalgame;

import com.kaikai.digitalgame.assembly.download.DownloadUtils;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class DigitalGameApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public  void testDownloadUtils() throws ExecutionException, InterruptedException, ZipException, IOException {
		String fileName = "temp.zip";
		String srcUrl = "http://idea.medeming.com/a/jihuoma1.zip";
		String s = DownloadUtils.downloadFile(fileName, srcUrl);
		Map<String, String> zip = DownloadUtils.previewFile(new File(s), "zip");
		System.out.println(zip);

	}
}
