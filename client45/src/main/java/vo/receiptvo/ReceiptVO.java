package vo.receiptvo;

import java.text.SimpleDateFormat;
import java.util.Date;

import state.ReceiptType;
import vo.ValueObject;
/**
 * 所有单据的父类，包括编号、创建时间
 * @author zsq
 */
public class ReceiptVO extends ValueObject{

	
	/**单据编号，不同的单据具有不同的编号格式**/
	protected String ID;
	/**创建时间，由系统自动生成*/
	protected String date;
	
	protected ReceiptType type;
	
	public ReceiptVO(String id, ReceiptType type){
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	    type=this.type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ReceiptType getType() {
		return type;
	}

	public void setType(ReceiptType type) {
		this.type = type;
	}
	

}
