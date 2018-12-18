package file;

import java.io.File;

/**
 * 笔试题：
 * 1、完成1+2+3+4+.。。+100，在整段代码中不得出现for,while关键字
 * 2、买汽水，1块钱1瓶汽水，2个空瓶换1瓶汽水，3个瓶盖换1瓶汽水，问20块钱可以喝到多少瓶？
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 完成方法，实现将给定的File对象表示的文件或目录删除
 * @author OldFarHigh
 *
 */
public class Demo_08Test {
	public static void main(String[] args) {
		File dir = new File("a");
		delete(dir);
	}
	public static void delete(File f) {
		System.out.println("已删除！");
		if(f.isDirectory()) {
			//先将目录清空
			File[] subs = f.listFiles();//将目录文件装载
			for (int i = 0; i < subs.length; i++) {
				File sub = subs[i];
				/*
				 * 递归调用
				 * 一个方法内部调用自己方法的现象称为递归调用
				 * 使用递归时要注意：
				 * 1、递归调用一定时在一个分支语句中控制的
				 * 如果方法内部必定调用当前方法则是死循环
				 * 2、递归调用的层数不宜过多，因为会大量的消耗内存
				 * 并且执行速度慢。（能不用递归解决问题尽量避免使用）
				 */
				delete(sub);//删除当前子项	
			}
		}
		f.delete();//删除文件或空目录
	}
}
