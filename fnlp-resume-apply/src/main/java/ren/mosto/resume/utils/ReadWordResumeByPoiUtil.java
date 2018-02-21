package ren.mosto.resume.utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * 读取word文档简历工具类
 * @author liuwei63
 *
 */
public class ReadWordResumeByPoiUtil {

    public static String getTextByPoi( InputStream in ) {
        String returnText="";
        try{
            if (!in.markSupported()) {
                in = new PushbackInputStream(in, 8);
            }
            if(POIFSFileSystem.hasPOIFSHeader(in)) {
                returnText=readWord2003(in);
            }
            if(POIXMLDocument.hasOOXMLHeader(in)) {
                returnText=readWord2007(in);
            }
        }catch(Exception e){
            // e.printStackTrace();
        }finally{
            try {
                in.close();
            }catch (IOException e) {
                // e.printStackTrace();
            }
        }
        return returnText;
    }

    /**
     * 读取word文档
     * @param FilePath
     * @return
     */
    public static String getTextByPoi(File FilePath){
        String returnText="";
        InputStream in =null;
        try{
            in =new FileInputStream(FilePath);
            returnText = getTextByPoi( in );
        }catch(Exception e){
            // e.printStackTrace();
        }
        return returnText;
    }


    /**
     * 读取word文档2003
     * @param file
     * @return
     */
    @SuppressWarnings("resource")
    public static String readWord2003(File file){
        String content="";
        InputStream is =null;
        try {
            is = new FileInputStream(file);
            return readWord2003( is );
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
        }
        return content;
    }

    public static String readWord2003( InputStream in ) {
        String content="";
        try{
            WordExtractor ex = new WordExtractor(in);
            content = ex.getText();
        }catch(Exception e){
            // e.printStackTrace();
        }finally{
            try {
                in.close();
            }catch (IOException e) {
                // e.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 读取word文档2007
     * @param file
     * @return
     */
    @SuppressWarnings("resource")
    public static String readWord2007(File file){
        String content="";
        try {
            FileInputStream fis = new FileInputStream(file);
            readWord2007( fis );
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
        }
        return content;
    }

    public static String readWord2007( InputStream in ) {
        String content="";
        try{
            XWPFDocument xdoc = new XWPFDocument(in);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            content = extractor.getText();
        }catch(Exception e){
            // e.printStackTrace();
        }finally{
            try {
                in.close();
            }catch (IOException e) {
                // e.printStackTrace();
            }
        }
        return content;
    }

}
