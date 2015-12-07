package businesslogic.facilitybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branchbl.BranchInfo;
import config.RMIConfig;
import dataservice.facilitydataservice.DriverDataService;
import po.accountpo.DriverPO;
import state.ConfirmState;
import state.ResultMessage;
import util.Util;
import vo.accountvo.DriverVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:25
 */
public class Driver{
	private DriverDataService DriverData;
	private BranchInfo_Facility branchInfo;
	public Driver() {
		branchInfo = new BranchInfo();
		try {
			DriverData = (DriverDataService)Naming.lookup(RMIConfig.PREFIX+DriverDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ResultMessage addDriver(DriverVO driver) throws RemoteException{
		DriverPO driverPO = FacilityTrans.convertVOtoPO(driver);
		if(branchInfo.addAccount(driverPO)==ResultMessage.SUCCESS)
			return DriverData.add(driverPO);
		return ResultMessage.FAIL;
	}

	public ResultMessage deleteDriver(DriverVO driver) throws RemoteException {
		if(branchInfo.deleteAccount(driver.branchID, driver.ID)==ResultMessage.SUCCESS)
			return DriverData.delete(driver.ID);
		return ResultMessage.FAIL;
	}

	public ResultMessage modifyDriver(DriverVO driver) throws RemoteException {
		DriverPO driverPO = FacilityTrans.convertVOtoPO(driver);
		if(branchInfo.modifyAccount(driverPO)==ResultMessage.SUCCESS)
			return DriverData.modify(driverPO);
		return ResultMessage.FAIL;
	}

	public ArrayList<DriverVO> findDriver() throws RemoteException {
		ArrayList<DriverPO> driverPOs = DriverData.find();
		ArrayList<DriverVO> driverVOs = FacilityTrans.convertDriverPOstoVOs(driverPOs);
		return driverVOs;

	}
	
	public DriverVO findDriver(String ID) throws RemoteException {
		DriverPO driverPO = DriverData.find(ID);
		DriverVO driverVO = FacilityTrans.convertPOtoVO(driverPO);
		return driverVO;
	}
	
	public String getID(String branchID) throws RemoteException{
		String[] branchMessage = Util.splitBranchID(branchID);
		String cityCode = branchMessage[0];
		String branchNumber = branchMessage[1];
		return cityCode+branchNumber+DriverData.getID();
	}

}
