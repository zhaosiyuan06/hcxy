package com.webTest.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.webTest.Action.FilecAction;

public class UnZipper {
    /** 
     * ��ѹ�ļ�����ǰĿ¼ �����൱���Ҽ� ѡ���ѹ 
     * @param zipFile 
     * @param 
     * @author gabriel 
     */ 
	public static String outPath;
	public static ZipEntry entry;
    @SuppressWarnings("rawtypes") 
    public static void unZipFiles(File zipFile)throws IOException{ 
        //�õ�ѹ���ļ�����Ŀ¼ 
        String path=zipFile.getAbsolutePath(); 
        path=path.substring(0,path.lastIndexOf("\\")); 
       // System.out.println("path "+path); 
        ZipFile zip = new ZipFile(zipFile); 
        for(Enumeration entries =zip.entries(); 
                entries.hasMoreElements();){ 
            entry = (ZipEntry)entries.nextElement(); 
            String zipEntryName = entry.getName(); 
            InputStream in = zip.getInputStream(entry); 
            //outPath���Ŀ¼ 
            outPath = (path+"\\"+zipEntryName).replaceAll("\\\\", "/");; 
            //System.out.println("outPath "+outPath); 
            //�ж�·���Ƿ����,�������򴴽��ļ�·�� 
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/'))); 
            if(!file.exists()){ 
                file.mkdirs(); 
            } 
            //�ж��ļ�ȫ·���Ƿ�Ϊ�ļ���,����������Ѿ��ϴ�,����Ҫ��ѹ 
            if(new File(outPath).isDirectory()){ 
                continue; 
            } 
            //����ļ�·����Ϣ 
            System.out.println(outPath); 

            OutputStream out = new FileOutputStream(outPath); 
            byte[] buf1 = new byte[1024]; 
            int len; 
            while((len=in.read(buf1))>0){ 
                out.write(buf1,0,len); 
                
            } 
            in.close(); 
            out.close(); 
            } 
        System.out.println("******************��ѹ���********************"); 
    }
    
//    public static void main(String[] args) { 
//        try { 
//            unZipFiles(new File("C:\\Users\\hp\\Desktop\\testsping.zip")); 
//        } catch (IOException e) { 
//            // TODO Auto-generated catch block 
//            e.printStackTrace(); 
//        } 
//    } 
}
