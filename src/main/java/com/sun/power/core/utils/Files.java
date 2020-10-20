package com.sun.power.core.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Files {

	// 读取文件
	public static List<String> readFileByLines(String fileName) {

		List<String> result = new ArrayList<String>();
		File file = new File(fileName);
		BufferedReader reader = null;
		try {			
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				result.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return result;
	}

	public static void wirteInfoToLine(String fileName, String content, int line) {

		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 将写文件指针移到文件尾。
			randomFile.seek(line);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		wirteInfoToLine("test.txt", "aaa124324324bbb", 0);
		List<String> text = readFileByLines("test.txt");
		System.out.println(text.get(0));
	}
}
