package less02;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		String path="C:/Windows";
		File file = new File(path);
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.getAbsolutePath());
		System.out.println(Arrays.toString(file.list()));
		Scanner in = new Scanner(System.in);
		String folder=null;
		
		do {
			if(folder!=null && (new File(path+"/"+folder).exists())){
				
				path+="/"+folder;
				file=new File(path);
			}
			System.out.println(file.getAbsolutePath());
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					System.out.println(f.getName());
				}
			}
			for (File f : files) {
				if (f.isFile()) {
					System.out.println(f.getName());
				}
			}
			folder=in.nextLine();
		} while (true);
	}

}
