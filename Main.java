public class Main {

	public static void main(String[] args) throws Exception {
		
		//......
		
		File sealFile = null;
		switch (shape) {
				case CqlcbStatus.SEAL_SHAPE_CYCLE://圆形
					sealFile = SealUtils.drawCycleSeal(firLevelName, serialNumber, secLevelName, outPath);
					break;
				case CqlcbStatus.SEAL_SHAPE_OVAL://椭圆
					
					break;
				case CqlcbStatus.SEAL_SHAPE_SQUARE://正方形
					
					break;
				case CqlcbStatus.SEAL_SHAPE_RECTANGLE://长方形
					
					break;
		
				default:
					break;
			}
	}
	
	/**
	 * 盖章接口
	 * @param sealProjectName，盖章项目名称
	 * @param sealPaperName，盖章文件名称
	 * @param oriFile，需要盖章的文件
	 * @param sealId，印章id
	 * @param desc，盖章说明
	 * @return DLFileInfo 盖章后文件存储信息
	 */
	public Boolean sealToFile(String sealProjectName,String sealPaperName,File oriFile,Long sealId,String desc){
		ElectronicSeal es;
		try {
			// 1.1 读取模板文件
//			FileInputStream fileInputStream = new FileInputStream(new File(fileUrl));
			String oriFilePath = oriFile.getAbsolutePath();
			FileInputStream fileInputStream = new FileInputStream(oriFile);
			InputStream inputStream = new BufferedInputStream(fileInputStream);
	        PdfReader reader = new PdfReader(inputStream);
	        // 1.2 创建文件输出流
	        String fileName=Optional.ofNullable(sealPaperName).orElse(sealProjectName+(new Date()).toString());
	        String suffix=oriFilePath.substring(oriFilePath.lastIndexOf('.'));
	        String outPath = PropsUtil.get(PropsKeys.DL_STORE_FILE_SYSTEM_ROOT_DIR)+File.separator+"STAMP_RECORD"+fileName+suffix;
	        FileOutputStream out = new FileOutputStream(outPath);
	        // 2、创建PdfStamper对象
	        PdfStamper stamper = new PdfStamper(reader, out);
	        // 5、读公章图片
	        DLFileEntry file=DLFileEntryLocalServiceUtil.getDLFileEntry(es.getAttachmenEntryId());
			String filePath =PropsUtil.get(PropsKeys.DL_STORE_FILE_SYSTEM_ROOT_DIR)+"/"+file.getCompanyId()+file.getTreePath()+file.getName()+"/"+file.getVersion();
	        Image  img = Image.getInstance(imageToBytes(filePath));
	        // 获取pdf页面的高和宽
	        Rectangle pageSize = reader.getPageSize(1);
	        // 6、为pdf每页加印章
	        img.scaleToFit(StampConstant.SEAL_SIZE_X, StampConstant.SEAL_SIZE_Y);// 公章大小
	        img.setAbsolutePosition(StampConstant.SEAL_POS_X, StampConstant.SEAL_POS_Y);// 公章位置
	        //假如每页都要盖的话就for循环
	        stamper.getOverContent(1).addImage(img);
	    	// 7、关闭相关流
	        stamper.close();
	        out.close();
	        reader.close();
	        inputStream.close();
			return true;
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
}



			
			