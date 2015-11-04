package po;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.receiptpo.ReceiptPO;
import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;

/**
 * @author zsq
 * @version Oct 22,2015
 */
public class DebitAndPayBillPO extends ReceiptPO{
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**id*/
	private String ID;
	private double money;
	private String courierID;
	private String date;
	//TODO
	private ArrayList orderNumbers;
	private String payerName;
	private ArrayList<BankPO> bankAccouts; 
	private PayBillItem items;
	private String rentYear;
	private String salaryMonth;
	//TODO
	private ArrayList transListNumber;
	private ReceiptType type;
	private ReceiptState state;
/**
 * @author zsq
 * @version Oct 22,2015
 */
	public DebitAndPayBillPO(String ID,double money,String courierID,ReceiptType type,ArrayList orderNumbers) {
		super(ID);
		this.ID = ID;
		this.money = money;
		this.courierID = courierID;
		this.state = ReceiptState.APPROVALING;
		this.type = type;
		this.orderNumbers = orderNumbers;
		// TODO Auto-generated constructor stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
	/**
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public DebitAndPayBillPO(String ID,double money,String payerName,ArrayList<BankPO>bankAccouts,ReceiptType type,
			String rentYear,String salaryMonth,PayBillItem items,ArrayList transListNumber){
		super(ID);
		
		this.ID = ID;
		this.money = money;
		this.payerName = payerName;
		this.bankAccouts = bankAccouts;
		this.rentYear  = rentYear;
		this.salaryMonth = salaryMonth;
		this.items = items;
		this.type = type;
		this.state = ReceiptState.APPROVALING;
		this.transListNumber = transListNumber;
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

	public ArrayList<BankPO> getBankAccouts() {
		return bankAccouts;
	}

	public void setBankAccouts(ArrayList<BankPO> bankAccouts) {
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}


}