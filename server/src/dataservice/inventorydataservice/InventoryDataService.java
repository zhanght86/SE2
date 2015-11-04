package dataservice.inventorydataservice;

import java.util.ArrayList;

import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface InventoryDataService {
	
	/**��ʼ���־�����**/
	public void init();
	/**�õ���ⵥID**/
	public String getImportID ();
	/**�õ����ⵥID**/
	public String getExportID ();
	/**�õ�������ID**/
	public String getAlarmID ();
	/**�õ�����**/
	public String getA();
	/**�õ��ź�**/
	public String getB();
	/**�õ��ܺ�**/
	public String getC();
	/**�õ�λ��**/
	public String getD();
	
	/**�õ�������**/
	public String getASize();
	/**�õ��ź�����**/
	public String getBSize();
	/**�õ��ܺ�����**/
	public String getCSize();
	/**�õ�λ������**/
	public String getDSize();
	
	/**�õ�����ʱ����**/
	public String getANum();
	/**�õ��Ŵ�ʱ����**/
	public String getBNum();
	/**�õ��ܴ�ʱ����**/
	public String getCNum();
	/**�õ�λ��ʱ����**/
	public String getDNum();
	
	
	/**����������ⵥ�ݵ�����**/
	public ArrayList<InventoryImportReceiptPO> showImport();
	/**�������г��ⵥ�ݵ�����**/
	public ArrayList<InventoryExportReceiptPO> showExport();
	/**�������е������ݵ�����**/
	public ArrayList<AdjustReceiptPO> showAdjust();
	
	/**����һ��po���ݼ�������ⵥ��**/
	public ResultMessage insertImport(InventoryImportReceiptPO po);
	/**����һ��po���ݼ����ɳ��ⵥ��**/
	public ResultMessage insertExport(InventoryExportReceiptPO po);
	/**����һ��po���ݼ����ɵ�������**/
	public ResultMessage insertAdjust(AdjustReceiptPO po);

}