package state;
/**
 * 需要进行审批的单据的类型
 * @author zsq
 * @version Oct 22,2015
 */
/**
 * 增为所有单据类型
 * 
 * @author LIUXUANLIN
 *
 */
public enum ReceiptType {
	CONFIRM("收件确认单", "SJQRD"),
	ORDER("寄件订单", "JJDD"),
	BRANCH_TRUCK("装车单", "ZCD"),
	BRANCH_ARRIVAL("营业厅到达单", "YYTDDD"),
	BRANCH_DELIVER("营业厅派件单", "YYTPJD"),
	EXPENSE("收款单", "SKD"),
	PAY("付款单","FKD"),
	TRANS_ARRIVAL("中转中心到达单", "ZZZXDDD"),
	TRANS_PLANE("飞机转运单", "FJZYD"),
	TRANS_TRAIN("火车转运单", "HCZYD"),
	TRANS_TRUCK("卡车转运单", "KCZYD"),
	INSTOCK("入库单","RKD"),
	OUTSTOCK("出库单","CCD"),
	TAKINGSTOCK("库存调整单","KCTZD"),
	
	ACCOUNT("",""),
	BASE("",""),
	BRANCH("",""),
	FACILITY("",""),
	DRIVER("",""),
	BANKACCOUNT("",""),
	INVENTORY("",""),
	OPENINGSTOCK("",""),
     TRANSFER("",""),
	  USER("","");
	
	public final String value;
	public final String prefix;
	
	ReceiptType(String value,String prefix){
		this.value = value;
		this.prefix = prefix;
	}
}
