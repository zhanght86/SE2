package dataservice.recorddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.BussinessConditionPO;
import po.BussinessProcessPO;
import po.PersistentObject;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public interface RecordDataService extends DataService<PersistentObject> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "RecordData";
	/**返回1. 收款单2.付款单**/
	public ArrayList<BussinessProcessPO> getBussinessProcess(String begindate, String enddate) throws RemoteException;
	/**返回信息：	1. 收入2. 支出。3. 利润：总收入-总支出**/
	public ArrayList<BussinessConditionPO> getBussinessCondition(String enddate) throws RemoteException;
	
}
