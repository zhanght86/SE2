package po;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;

/**
 * 收款单和付款单的持久化对象
 * @author zsq
 * @version Oct 22,2015
 */
public class DebitAndPayBillPO extends ReceiptPO{
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**收款或付款金额*/
	private double money;
	/**收款快递员的用户ID*/
	private String courierID;
	/**收款或者收款日期，系统自动生成*/
	private String date;
	/**对应快递订单条形码号*/
	//TODO
	private ArrayList orderNumbers;
	/**付款人*/
	private String payerName;
	/**付款账户*/
	private ArrayList<BankAccountPO> bankAccouts; 
	/**条目*/
	private PayBillItem items;
	/**备注*/
	private String rentYear;
	private String salaryMonth;
	//TODO
	private ArrayList transListNumber;
	/**区分收款单和付款单*/
	private ReceiptType type;
	/**单据状态*/
	private ReceiptState state;
/**
 * 建立收款单构造器
 * @param ID 收款单ID
 * @param money 收款金额
 * @param courierID 收款快递员
 * @param state 单据状态
 * @param type 单据类型
 * @param orderNumbers 此收款单包含的所有订单条形码号
 * @author zsq
 * @version Oct 22,2015
 */
	public DebitAndPayBillPO(String ID,double money,String courierID,ReceiptType type,ArrayList orderNumbers) {
		super(ID);
		this.money = money;
		this.courierID = courierID;
		this.state = ReceiptState.APPROVALING;
		this.type = type;
		this.orderNumbers = orderNumbers;
		// TODO Auto-generated constructor stub
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
	/**
	 * 建立付款单构造器
	 * @param ID 付款单ID
	 * @param money 付款金额
	 * @param payerName 付款人姓名
	 * @param bankAccouts 付款账号
	 * @param type 单据类型
	 * @param rentYear 租金备注，当不是此条目下为NULL
	 * @param salaryMonth 薪水备注，当不是此条目下为NULL
	 * @param items 付款条目
	 * @param transListNumber 运单号备注，当不是此条目下为NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public DebitAndPayBillPO(String ID,double money,String payerName,ArrayList<BankAccountPO>bankAccouts,ReceiptType type,
			String rentYear,String salaryMonth,PayBillItem items,ArrayList transListNumber){
		super(ID);
		this.money = money;
		this.payerName = payerName;
		this.bankAccouts = bankAccouts;
		this.rentYear  = rentYear;
		this.salaryMonth = salaryMonth;
		this.items = items;
		this.type = type;
		this.state = ReceiptState.APPROVALING;
		this.transListNumber = transListNumber;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
	
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getCourierID() {
		return courierID;
	}

	public void setCourierID(String courierID) {
		this.courierID = courierID;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public ArrayList<BankAccountPO> getBankAccouts() {
		return bankAccouts;
	}

	public void setBankAccouts(ArrayList<BankAccountPO> bankAccouts) {
		this.bankAccouts = bankAccouts;
	}

	public PayBillItem getItems() {
		return items;
	}

	public void setItems(PayBillItem items) {
		this.items = items;
	}

	public ReceiptType getType() {
		return type;
	}

	public void setType(ReceiptType type) {
		this.type = type;
	}

	public ReceiptState getState() {
		return state;
	}

	public void setState(ReceiptState state) {
		this.state = state;
	}

	public String getRentYear() {
		return rentYear;
	}

	public void setRentYear(String rentYear) {
		this.rentYear = rentYear;
	}

	public String getSalaryMonth() {
		return salaryMonth;
	}

	public void setSalaryMonth(String salaryMonth) {
		this.salaryMonth = salaryMonth;
	}


}
