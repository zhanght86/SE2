package data.receiptdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Data;
import dataservice.receiptdataservice.ReceiptDataService;
import po.receiptpo.ReceiptPO;
import state.ResultMessage;

public class ReceiptData extends Data implements ReceiptDataService<ReceiptPO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReceiptData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage update(ReceiptPO PO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptPO> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
