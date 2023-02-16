package io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;

public class TestFile {

	public static void main(String[] args) {

		File dir = new File("C:\\eclipse");
		File[] files = dir.listFiles();
		// files[0] ->? File
		long size = 0;
		int count = 0;
		List<File> list = new ArrayList<>();
		for (File file : files) {
			long lastModified = file.lastModified();
			Date date = new Date(lastModified);
			SimpleDateFormat f = new SimpleDateFormat("yyyy/M/d a hh:mm:ss");
			System.out.printf("檔名:%s%s,%s%n", file.getName(), file.isDirectory() ? "(目錄)" : "", f.format(date));
			// lab
			if (!file.isDirectory()) {
				count++;
				size += file.length();
				list.add(file);
			}

		}
		System.out.printf("檔案總數:%d,大小總和:%d bytes%n", count, size);
		// java 8: lambda and stream api
		list.sort(( f1,  f2) -> {
				// return (int)(f.length()-f.length());
				// 如果相減的值大於int(2.1B),轉型成int??

				if (f1.length() < f2.length()) {
					return -1;
				} else if (f1.length() > f2.length()) {
					return 1;
				}
				return 0;
			
		});

		for (File file : list) {
			System.out.printf("name:%s,size=%d%n", file.getName(), file.length());
		}

	}

}
