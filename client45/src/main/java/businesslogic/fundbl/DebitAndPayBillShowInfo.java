package businesslogic.fundbl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.accountbl.AccountInfo;
import businesslogic.recordbl.DebitAndPayBillShowInfo_Record;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import state.ReceiptType;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:48
 */
public class DebitAndPayBillShowInfo implements DebitAndPayBillShowInfo_Record {
	DebitAndPayBill debitAndPayBill;
	DebitAndPayBillDataService debitAndPayBillData;
	public DebitAndPayBillShowInfo() {
		debitAndPayBill = new DebitAndPayBill();
		debitAndPayBillData = debitAndPayBill.getData();
	}
	@Override
	public ArrayList<DebitAndPayBillVO> getBusinessProcess(String startDate, String endDate) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		ArrayList<DebitAndPayBillVO> VOs = new ArrayList<>();
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			if(inDate(debitAndPayBillPO, startDate, endDate)){
				DebitAndPayBillVO vo = FundTrans.convertPOtoVO(debitAndPayBillPO);
				VOs.add(vo);
			}
		}
		return VOs;
	}
	@Override
	public BussinessConditionVO getBussinessCondition(String endDate) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		BigDecimal income = new BigDecimal(0);
		BigDecimal expense = new BigDecimal(0);
		BigDecimal profit =new BigDecimal(0);
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			ReceiptType type =debitAndPayBillPO.getReceiptType();
			if(type==ReceiptType.DEBIT)	expense=expense.add(debitAndPayBillPO.getMoney());
			else if(type==ReceiptType.PAY)	profit=profit.add(debitAndPayBillPO.getMoney());
		}
		profit = income.subtract(expense);
		BussinessConditionVO vo = new BussinessConditionVO(endDate, income, expense, profit);
		return vo;
	}
	@Override
	public BussinessOneDayVO getBussinessOneDayIncome(String branch, String date) throws RemoteException {
		AccountInfo_DebitAndPayBillVOShow accountInfo = new AccountInfo();
		ArrayList<DebitBillVO> debits = new ArrayList<>();
		BigDecimal income = new BigDecimal(0);
		ArrayList<DebitAndPayBillPO> POs = debitAndPayBillData.find();
		for (DebitAndPayBillPO debitAndPayBillPO : POs) {
			if(debitAndPayBillPO.getDate().equals(date)&&debitAndPayBillPO.getReceiptType()==ReceiptType.DEBIT){
				DebitBillPO po = (DebitBillPO)debitAndPayBillPO;
				if(accountInfo.isAccountAMemberOfBranch(po.getCourierID(), branch)){
					income =income.add(debitAndPayBillPO.getMoney());
					DebitBillVO vo = FundTrans.convertDebitPOtoDebitVO(po);
					debits.add(vo);
				}
			}
		}
		return new BussinessOneDayVO(debits, income);
	}
	private boolean inDate(DebitAndPayBillPO po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}
	

}
