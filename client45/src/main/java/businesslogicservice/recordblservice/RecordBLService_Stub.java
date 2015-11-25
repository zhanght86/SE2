package businesslogicservice.recordblservice;

import java.util.ArrayList;

import vo.BussinessConditionVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class RecordBLService_Stub implements RecordBLService{
	public ArrayList<DebitBillVO> incomeReceipt;
	public ArrayList<PaymentBillVO> expenReceipt;
	/** 起始时间 */
	public String begin;
	/** 结束时间 */
	public String end;
	/**收入**/
	public double totalIncome;
	/**支出**/
	public double totalExpen;
	/** 利润 */
	public double profit;
	public RecordBLService_Stub(ArrayList<DebitBillVO> incomeReceipt, ArrayList<PaymentBillVO> expenReceipt,
			String begin, String end, double totalIncome, double totalExpen, double profit) {
		super();
		this.incomeReceipt = incomeReceipt;
		this.expenReceipt = expenReceipt;
		this.begin = begin;
		this.end = end;
		this.totalIncome = totalIncome;
		this.totalExpen = totalExpen;
		this.profit = profit;
	}

	@Override
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BussinessConditionVO  bussinessCondition(String end) {
		// TODO Auto-generated method stub
		return new BussinessConditionVO( end, totalIncome, totalExpen,profit);
	}

	

}
