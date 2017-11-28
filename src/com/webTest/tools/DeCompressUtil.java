package com.webTest.tools;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.rarfile.FileHeader;

public class DeCompressUtil {
	 private static void unzip(String sourceZip,String destDir) throws Exception{   
	       try{   
	           Project p = new Project();   
	           Expand e = new Expand();   
	           e.setProject(p);   
	           e.setSrc(new File(sourceZip));   
	           e.setOverwrite(false);   
	           e.setDest(new File(destDir));   
	           /*  
	           ant�µ�zip����Ĭ��ѹ������ΪUTF-8���룬  
	           ��winRAR���ѹ�����õ�windowsĬ�ϵ�GBK����GB2312����  
	           ���Խ�ѹ��ʱҪ�ƶ������ʽ  
	           */  
	           e.setEncoding("gbk");   
	           e.execute();   
	       }catch(Exception e){   
	           throw e;   
	       }   
	   }   
	   /**  
	    * ��ѹrar��ʽѹ������  
	    * ��Ӧ����java-unrar-0.3.jar������java-unrar-0.3.jar�ֻ��õ�commons-logging-1.1.1.jar  
	    */  
	   private static void unrar(String sourceRar,String destDir) throws Exception{   
	       Archive a = null;   
	       FileOutputStream fos = null;   
	       try{   
	           a = new Archive(new File(sourceRar));   
	           FileHeader fh = a.nextFileHeader();   
	           while(fh!=null){   
	               if(!fh.isDirectory()){   
	                   //1 ���ݲ�ͬ�Ĳ���ϵͳ�õ���Ӧ�� destDirName �� destFileName   
	                   String compressFileName = fh.getFileNameString().trim();   
	                   String destFileName = "";   
	                   String destDirName = "";   
	                   //��windowsϵͳ   
	                   if(File.separator.equals("/")){   
	                       destFileName = destDir + compressFileName.replaceAll("\\\\", "/");   
	                       destDirName = destFileName.substring(0, destFileName.lastIndexOf("/"));   
	                   //windowsϵͳ    
	                   }else{   
	                       destFileName = destDir + compressFileName.replaceAll("/", "\\\\");   
	                       destDirName = destFileName.substring(0, destFileName.lastIndexOf("\\"));   
	                   }   
	                   //2�����ļ���   
	                   File dir = new File(destDirName);   
	                   if(!dir.exists()||!dir.isDirectory()){   
	                       dir.mkdirs();   
	                   }   
	                   //3��ѹ���ļ�   
	                   fos = new FileOutputStream(new File(destFileName));   
	                   a.extractFile(fh, fos);   
	                   fos.close();   
	                   fos = null;   
	               }   
	               fh = a.nextFileHeader();   
	           }   
	           a.close();   
	           a = null;   
	       }catch(Exception e){   
	           throw e;   
	       }finally{   
	           if(fos!=null){   
	               try{fos.close();fos=null;}catch(Exception e){e.printStackTrace();}   
	           }   
	           if(a!=null){   
	               try{a.close();a=null;}catch(Exception e){e.printStackTrace();}   
	           }   
	       }   
	   }   
	   /**  
	    * ��ѹ��  
	    */  
	   public static void deCompress(String sourceFile,String destDir) throws Exception{   
	       //��֤�ļ���·�������"/"����"\"   
	       char lastChar = destDir.charAt(destDir.length()-1);   
	       if(lastChar!='/'&&lastChar!='\\'){   
	           destDir += File.separator;   
	       }   
	       //�������ͣ�������Ӧ�Ľ�ѹ��   
	       String type = sourceFile.substring(sourceFile.lastIndexOf(".")+1);  
	       System.err.println(type);
	       if(type.equals("zip")){   
	           DeCompressUtil.unzip(sourceFile, destDir);   
	        }else if(type.equals("rar")){   
	            DeCompressUtil.unrar(sourceFile, destDir);   
	        }else{   
	            throw new Exception("ֻ֧��zip��rar��ʽ��ѹ������");   
	        }   
	    }   
}
