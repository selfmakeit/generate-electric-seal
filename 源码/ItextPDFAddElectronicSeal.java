package com.hwadee.liferay.electronic.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import com.hwadee.liferay.electronic.common.StampConstant;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ItextPDFAddElectronicSeal {

	/**
	 * 
	* @Title: itextPDFAddPicture
	* @Description: 为pdf加图片(电子合同盖公章)
	* @param filePath 电子合同pdf文件路径
	* @param map {company:公司公章名称,purpose:公章用途，serialNumber:序号}
	* @param targetPath 保存路径
	* @throws Exception 异常参数
	 */
	public static void itextPDFAddPicture(String filePath, Map<String, String> map, String targetPath) throws Exception{
		// 1.1 读取模板文件
		FileInputStream fileInputStream = new FileInputStream(new File(filePath));
		InputStream inputStream = new BufferedInputStream(fileInputStream);
        PdfReader reader = new PdfReader(inputStream);
        // 1.2 创建文件输出流
        FileOutputStream out = new FileOutputStream(targetPath);
        // 2、创建PdfStamper对象
        PdfStamper stamper = new PdfStamper(reader, out);
        
        // 5、读公章图片
        Image  img = Image.getInstance(imageToBytes("E:/file/111.png"));
        // 获取pdf页面的高和宽
        Rectangle pageSize = reader.getPageSize(1);
        // 6、为pdf每页加印章
        img.scaleToFit(StampConstant.SEAL_SIZE_X, StampConstant.SEAL_SIZE_Y);// 公章大小
        img.setAbsolutePosition(StampConstant.SEAL_POS_X, StampConstant.SEAL_POS_Y);// 公章位置
        stamper.getOverContent(1).addImage(img);
    	
    	// 7、关闭相关流
        stamper.close();
        out.close();
        reader.close();
        inputStream.close();
	}
    
    private static byte [] imageToBytes(String path){
        BufferedImage bi;    
        try {    
        	FileInputStream fileInputStream = new FileInputStream(new File(path));
    		InputStream inputStream = new BufferedInputStream(fileInputStream);
            bi = ImageIO.read(inputStream);    
            ByteArrayOutputStream baos = new ByteArrayOutputStream();    
            ImageIO.write(bi, "png", baos);    
            byte[] bytes = baos.toByteArray();
            return bytes;
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        	return null;
        }
    }
}
