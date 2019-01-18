package com.linxiaomi.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldQuickApplicationTests {

	@Test
	public void contextLoads() {
	}

	/**
	 * @Description:    批量修改某文件夹下的文件名称
	 * @Author:         linxiaomi
	 * @CreateDate:     2019/1/18 18:05
	 * @UpdateUser:     linxiaomi
	 * @UpdateDate:     2019/1/18 18:05
	 * @UpdateRemark:   
	 * @Version:        1.0
	 * @return:         
	 */
	@Test
	public void test() {
		try {
			// 要天剑的文件所在目录
			String path = "";
			// 要替换的文件名称
			String replaceStr = "";
			File file = new File(path);
			if (file.exists()) {
				File[] files = file.listFiles();
				for (int i=0; i<files.length; i++) {
					if (files[i].getName().contains(replaceStr)) {
						File oldfile=new File(path+"\\"+files[i].getName());
						System.out.println(oldfile);
						File newfile=new File(path+"\\"+files[i].getName().replace(replaceStr, ""));
						oldfile.renameTo(newfile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
