package com.webTest.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileType {
    
    public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();     
    
    private FileType(){}     
    static{     
        getAllFileType(); //��ʼ���ļ�������Ϣ     
    }     
         
    /**   
     * Discription:[getAllFileType,�����ļ�ͷ��Ϣ] 
     */     
    private static void getAllFileType()     
    {     
        FILE_TYPE_MAP.put("1", "jpg"); //JPEG (jpg)     
        FILE_TYPE_MAP.put("2", "png"); //PNG (png)     
        FILE_TYPE_MAP.put("3", "gif"); //GIF (gif)     
        FILE_TYPE_MAP.put("4", "tif"); //TIFF (tif)     
        FILE_TYPE_MAP.put("5", "bmp"); //16ɫλͼ(bmp)     
        FILE_TYPE_MAP.put("6", "bmp"); //24λλͼ(bmp)     
        FILE_TYPE_MAP.put("7", "bmp"); //256ɫλͼ(bmp)     
        FILE_TYPE_MAP.put("8", "dwg"); //CAD (dwg)     
        FILE_TYPE_MAP.put("9", "html"); //HTML (html)
        FILE_TYPE_MAP.put("10", "htm"); //HTM (htm)
        FILE_TYPE_MAP.put("11", "css"); //css
        FILE_TYPE_MAP.put("12", "js"); //js
        FILE_TYPE_MAP.put("13", "rtf"); //Rich Text Format (rtf)     
        FILE_TYPE_MAP.put("14", "psd"); //Photoshop (psd)     
        FILE_TYPE_MAP.put("15", "eml"); //Email [Outlook Express 6] (eml)       
        FILE_TYPE_MAP.put("16", "doc"); //MS Excel ע�⣺word��msi �� excel���ļ�ͷһ��     
        FILE_TYPE_MAP.put("17", "vsd"); //Visio ��ͼ     
        FILE_TYPE_MAP.put("18", "mdb"); //MS Access (mdb)      
        FILE_TYPE_MAP.put("19", "ps");     
        FILE_TYPE_MAP.put("20", "pdf"); //Adobe Acrobat (pdf)   
        FILE_TYPE_MAP.put("21", "rmvb"); //rmvb/rm��ͬ  
        FILE_TYPE_MAP.put("22", "flv"); //flv��f4v��ͬ  
        FILE_TYPE_MAP.put("23", "mp4"); 
        FILE_TYPE_MAP.put("24", "mp3"); 
        FILE_TYPE_MAP.put("25", "mpg"); //     
        FILE_TYPE_MAP.put("26", "wmv"); //wmv��asf��ͬ    
        FILE_TYPE_MAP.put("27", "wav"); //Wave (wav)  
        FILE_TYPE_MAP.put("28", "avi");  
        FILE_TYPE_MAP.put("29", "mid"); //MIDI (mid)   
        FILE_TYPE_MAP.put("30", "zip");    
        FILE_TYPE_MAP.put("31", "rar");   
        FILE_TYPE_MAP.put("32", "ini");   
        FILE_TYPE_MAP.put("33", "jar"); 
        FILE_TYPE_MAP.put("34", "exe");//��ִ���ļ�
        FILE_TYPE_MAP.put("35", "jsp");//jsp�ļ�
        FILE_TYPE_MAP.put("36", "mf");//MF�ļ�
        FILE_TYPE_MAP.put("37", "xml");//xml�ļ�
        FILE_TYPE_MAP.put("38", "sql");//xml�ļ�
        FILE_TYPE_MAP.put("39", "java");//java�ļ�
        FILE_TYPE_MAP.put("40", "bat");//bat�ļ�
        FILE_TYPE_MAP.put("41", "gz");//gz�ļ�
        FILE_TYPE_MAP.put("42", "properties");//bat�ļ�
        FILE_TYPE_MAP.put("43", "class");//bat�ļ�
        FILE_TYPE_MAP.put("44", "chm");//bat�ļ�
        FILE_TYPE_MAP.put("45", "mxp");//bat�ļ�
        FILE_TYPE_MAP.put("46", "docx");//docx�ļ�
        FILE_TYPE_MAP.put("47", "wps");//WPS����wps�����et����ʾdps����һ����
        FILE_TYPE_MAP.put("48", "torrent");
        FILE_TYPE_MAP.put("49", "mov"); //Quicktime (mov)  
        FILE_TYPE_MAP.put("50", "wpd"); //WordPerfect (wpd)   
        FILE_TYPE_MAP.put("51", "dbx"); //Outlook Express (dbx)     
        FILE_TYPE_MAP.put("52", "pst"); //Outlook (pst)      
        FILE_TYPE_MAP.put("53", "qdf"); //Quicken (qdf)     
        FILE_TYPE_MAP.put("54", "pwl"); //Windows Password (pwl)         
        FILE_TYPE_MAP.put("55", "ram"); //Real Audio (ram)     
        FILE_TYPE_MAP.put("56", "jpeg");
    }                       
    
    /**
     * �õ��ϴ��ļ����ļ�ͷ
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    
    /**
     * �����ƶ��ļ����ļ�ͷ�ж����ļ�����
     * @param filePaht
     * @return
     */
    public static String getFileType(String filePaht){
        String res = null;
        try {
            FileInputStream is = new FileInputStream(filePaht);
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            String fileCode = bytesToHexString(b);    
            
            System.out.println(fileCode);
            
            
            //���ַ������ֵ��ͷ���벻��λ����ʱ������õ����ٶ������һ��
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while(keyIter.hasNext()){
                String key = keyIter.next();
                if(key.toLowerCase().startsWith(fileCode.toLowerCase()) || fileCode.toLowerCase().startsWith(key.toLowerCase())){
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static boolean isLegal(String fileContentType){
    	//String head = bytesToHexString(fileContentType.getBytes());
    	Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
    	while(keyIter.hasNext()) {
    		String key = keyIter.next();
			if (fileContentType.equals(FILE_TYPE_MAP.get(key))) {
				
				return true;
			}
				System.err.println(FILE_TYPE_MAP.get(key));
		}
		return false;
    	
    }
}