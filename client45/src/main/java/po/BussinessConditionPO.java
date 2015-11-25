package po;

import java.util.ArrayList;

import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;

public class BussinessConditionPO extends PersistentObject{
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**
	 * 经营情况表
	 * 统计显示一段时间内的经营收支状况和利润。
	 * 显示信息：	
	 * 1. 收入类
	 * 2. 支出类
	 * 3. 利润
	
	 */
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
		public BussinessConditionPO(String id,String begin, String end, double totalIncome, double totalExpen, double profit) {
			super(id);
			this.begin = begin;
			this.end = end;
			this.totalIncome = totalIncome;
			this.totalExpen = totalExpen;
			this.profit = profit;
		}
		
		
		
}
