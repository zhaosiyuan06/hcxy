package com.webTest.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadFile {
	 public ReadFile() {
     }
     /**
      * ��ȡĳ���ļ����µ������ļ�
     * @return 
      */
     public static ArrayList<File>  readfile(String filepath) throws FileNotFoundException, IOException {
    	 	ArrayList<File> list = new ArrayList<File>();
             try {

                     File file = new File(filepath);
                     if (!file.isDirectory()) {
                    	 	 list.add(file);
//                             System.out.println("�ļ�");
//                             System.out.println("path=" + file.getPath());
//                             System.out.println("absolutepath=" + file.getAbsolutePath());
//                             System.out.println("name=" + file.getName());
//                    	 	 return list;
                    	 	 return list;
                     } else {
                             System.out.println("��⵽�ļ���");
                             String[] filelist = file.list();
                             for (int i = 0; i < filelist.length; i++) {
                                     File readfile = new File(filepath + "\\" + filelist[i]);
                                     if (!readfile.isDirectory()) {
                                    	 	 list.add(readfile);
                                    	 	 //System.err.println(list);
//                                             System.out.println("path=" + readfile.getPath());
//                                             System.out.println("absolutepath="
//                                                             + readfile.getAbsolutePath());
//                                             System.out.println("name=" + readfile.getName());
                                    	 	
                                     } else if (readfile.isDirectory()) {
                                          readfile(filepath + "\\" + filelist[i]);
                                          //System.err.println("���ļ���");
                                     }
                                    
                             }
                             System.out.println(list);
                             return list;
                     }
                     
             } catch (FileNotFoundException e) {
                     System.out.println("readfile()   Exception:" + e.getMessage());
                     return null ;
             }
             
     }
     public static void main(String[] args) {
    	 int fileNum = 0;
         int folderNum = 0;
         File file = new File("E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OfficialWebsite-master\\biananes-master");
         if (file.exists()) {
             LinkedList<File> filelist = new LinkedList<File>();
             File[] files  = file.listFiles();
             //��������ļ�
             for (File file2 : files) {
             	//�������ļ����ļ���
                 if (file2.isDirectory()) {
                     System.out.println("�ļ���:" + file2.getAbsolutePath());
                     //�ļ���list �������ļ���
                     filelist.add(file2);
                     fileNum++;
                 } else {  
                     //������ļ���ִ�н����ļ�����
                 	
                 	folderNum++;
                 	System.out.println(file2.getAbsolutePath());
                 	
                 }
             }
             File temp_file;
             //����list
             while (!filelist.isEmpty()) {
                 temp_file = filelist.removeFirst();
                 files = temp_file.listFiles();
                 for (File file2 : files) {
                     if (file2.isDirectory()) {
                        
                         filelist.add(file2);
                         fileNum++;
                     } else {
                
                     	folderNum++;
                    	System.out.println(file2.getAbsolutePath());//��Ϊ��Ҫ����Щ�洢�����ݿ�

                     }
                 }
             
             }
             
              
         } else {
             System.out.println("�ļ�������!");
         }
      
         System.out.println("�ļ��й���:" + fileNum + ",�ļ�����:" + folderNum);
 			
 	}
     public List<String> readFile(String path){
    	 int fileNum = 0;
         int folderNum = 0;
        List<String> fileList = new ArrayList<String>();
        File file = new File(path);
//         File file = new File("E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OfficialWebsite-master\\biananes-master");
         if (file.exists()) {
             LinkedList<File> filelist = new LinkedList<File>();
             File[] files  = file.listFiles();
             //��������ļ�
             for (File file2 : files) {
             	//�������ļ����ļ���
                 if (file2.isDirectory()) {
                     System.out.println("�ļ���:" + file2.getAbsolutePath());
                     //�ļ���list �������ļ���
                     filelist.add(file2);
                     fileNum++;
                 } else {  
                     //������ļ���ִ�н����ļ�����
                	 fileList.add(file2.getAbsolutePath());
                 	folderNum++;
                 	System.out.println(file2.getAbsolutePath());
                 	
                 }
             }
             File temp_file;
             //����list
             while (!filelist.isEmpty()) {
                 temp_file = filelist.removeFirst();
                 files = temp_file.listFiles();
                 for (File file2 : files) {
                     if (file2.isDirectory()) {
                        
                         filelist.add(file2);
                         fileNum++;
                     } else {
                    	 fileList.add(file2.getAbsolutePath());
                     	folderNum++;
                     	
                    	System.out.println(file2.getAbsolutePath());//��Ϊ��Ҫ����Щ�洢�����ݿ�

                     }
                 }
             
             }
             
              
         } else {
             System.out.println("�ļ�������!");
         }
      
         System.out.println("�ļ��й���:" + fileNum + ",�ļ�����:" + folderNum);
    	 
    	 
    	 return fileList;
    	 
     }
	
}
