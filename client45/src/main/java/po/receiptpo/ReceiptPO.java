package po.receiptpo;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.PersistentObject;
import state.ReceiptCondition;
import state.ReceiptState;
import state.ReceiptType;
/**
 * 所有单据的父类，包括编号、创建时间
 * @author zsq
 */
public class ReceiptPO extends PersistentObject{

	/**serializableUID*/
	private static final long serialVersionUID = 1L;
	
	/**单据编号，不同的单据具有不同的编号格式**/
	protected String ID;
	/**创建时间，由系统自动生成*/
	protected String date;
	/**单据状态*/
	protected ReceiptState receiptState;
	
	protected ReceiptCondition receiptCondition;
	
	protected ReceiptType receiptType;
	
	public ReceiptPO(String ID,ReceiptType type){
		super(ID,type);
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
		this.receiptState=ReceiptState.DRAFT;
		this.receiptCondition=ReceiptCondition.DRAFT;
		this.receiptType=receiptType;
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

	public ReceiptState getReceiptState() {
		return receiptState;
	}

	public void setReceiptState(ReceiptState receiptState) {
		this.receiptState = receiptState;
	}

	public ReceiptCondition getReceiptCondition() {
		return receiptCondition;
	}

	public void setReceiptCondition(ReceiptCondition receiptCondition) {
		this.receiptCondition = receiptCondition;
	}

	public ReceiptType getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(ReceiptType receiptType) {
		this.receiptType = receiptType;
	}
	
   
	


}
