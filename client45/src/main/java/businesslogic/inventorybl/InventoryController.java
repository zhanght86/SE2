package businesslogic.inventorybl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;

import businesslogicservice.inventoryblservice.InventoryBLService;
import state.ExpressType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class InventoryController implements InventoryBLService {
    Inventory InventoryBL = new Inventory();
	@Override
	public InventoryViewVO viewInventory(String transferID,String beginDate, String endDate)  {
		try {
			return InventoryBL.viewInventory(transferID,beginDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryCheckVO checkRecord(String date){
		try {
			return InventoryBL.checkRecord(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getImportID()  {
		try {
			return InventoryBL.getImportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryImportReceiptVO addCommodities(String transferID,CommodityVO commodity, int area ,int row,int frame,int position)  {
		try {
			return InventoryBL.addCommodities(transferID, commodity, area, row, frame, position);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResultMessage saveImport(InventoryImportReceiptVO importReceipt) {
		 try {
			InventoryBL.saveImport(importReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		try {
			return InventoryBL.submitImport(importReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getExportID() {
		try {
			return InventoryBL.getExportID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InventoryExportReceiptVO minusCommodities(String ID ,String ImportID, ExpressType Transfer) {
		try {
			return InventoryBL.minusCommodities( ID ,ImportID, Transfer);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage saveExport(InventoryExportReceiptVO exportReceipt) {
		 try {
			InventoryBL.saveExport(exportReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		try {
			return InventoryBL.submitExport(exportReceipt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAdjustID()  {
		try {
			return InventoryBL.getAdjustID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage adjust(String ID ,InventoryVO before, InventoryVO now) {
		try {
			return InventoryBL.adjust(ID ,before, now);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
