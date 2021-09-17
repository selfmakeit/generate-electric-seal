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
}



			
			