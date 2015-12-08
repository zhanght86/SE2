package ui.image;

import javax.swing.ImageIcon;

public class InventoryImage {
	//库存查看
	private static ImageIcon[] BUTTON_CHAKAN = null;
	//库存盘点
	private static ImageIcon[] BUTTON_PANDIAN = null;
	//库存分区调整
	private static ImageIcon[] BUTTON_FENQUTIAOZHENG = null;
	//入库
	private static ImageIcon[] BUTTON_RUKU = null;
	//出库
	private static ImageIcon[] BUTTON_CHUKU = null;
	//刷新按钮
	private static ImageIcon[] BUTTON_REFRESH = null;
	//盘点按钮
	private static ImageIcon[] BUTTON_PD = null;
	//确认调整按钮
	private static ImageIcon[] BUTTON_TIAOZHENG = null;
	//升入入库单按钮
	private static ImageIcon[] BUTTON_RUKUDAN = null;
	//升入出库单按钮
	private static ImageIcon[] BUTTON_CHUKUDAN = null;
	
	public static ImageIcon[] getBUTTON_CHAKAN(){
		if(BUTTON_CHAKAN == null){
			BUTTON_CHAKAN = Images.createImageIcons("image/button/库存查看.png");
		}
		return BUTTON_CHAKAN;
	}
	
	public static ImageIcon[] getBUTTON_PANDIAN(){
		if(BUTTON_PANDIAN == null){
			BUTTON_PANDIAN = Images.createImageIcons("image/button/库存盘点.png");
		}
		return BUTTON_PANDIAN;
	}
	
	public static ImageIcon[] getBUTTON_FENQUTIAOZHENG(){
		if(BUTTON_FENQUTIAOZHENG == null){
			BUTTON_FENQUTIAOZHENG = Images.createImageIcons("image/button/库存分区调整.png");
		}
		return BUTTON_FENQUTIAOZHENG;
	}
	
	public static ImageIcon[] getBUTTON_RUKU(){
		if(BUTTON_RUKU == null){
			BUTTON_RUKU = Images.createImageIcons("image/button/入库.png");
		}
		return BUTTON_RUKU;
	}
	
	public static ImageIcon[] getBUTTON_CHUKU(){
		if(BUTTON_CHUKU == null){
			BUTTON_CHUKU = Images.createImageIcons("image/button/出库.png");
		}
		return BUTTON_CHUKU;
	}
	
	public static ImageIcon[] getBUTTON_REFRESH(){
		if(BUTTON_REFRESH == null){
			BUTTON_REFRESH = Images.createImageIcons("image/button/刷新.png");
		}
		return BUTTON_REFRESH;
	}
	
	public static ImageIcon[] getBUTTON_PD(){
		if(BUTTON_PD == null){
			BUTTON_PD = Images.createImageIcons("image/button/盘点.png");
		}
		return BUTTON_PD;
	}
	
	public static ImageIcon[] getBUTTON_TIAOZHENG(){
		if(BUTTON_TIAOZHENG == null){
			BUTTON_TIAOZHENG = Images.createImageIcons("image/button/确认调整.png");
		}
		return BUTTON_TIAOZHENG;
	}
	
	public static ImageIcon[] getBUTTON_RUKUDAN(){
		if(BUTTON_RUKUDAN == null){
			BUTTON_RUKUDAN = Images.createImageIcons("image/button/生成入库单.png");
		}
		return BUTTON_RUKUDAN;
	}
	
	public static ImageIcon[] getBUTTON_CHUKUDAN(){
		if(BUTTON_CHUKUDAN == null){
			BUTTON_CHUKUDAN = Images.createImageIcons("image/button/生成出库单.png");
		}
		return BUTTON_CHUKUDAN;
	}
}