package businesslogic.facility;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.facilitydataservice.DriverDataService;
import po.accountpo.DriverPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.accountvo.DriverVO;

public class Driver{
	private DriverDataService DriverData;
	
	public Driver() {
		try {
			DriverData = (DriverDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+DriverDataService.NAME);
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
		return DriverData.add(driverPO);
	}

	public ResultMessage deleteDriver(DriverVO driver) throws RemoteException {
		return DriverData.delete(driver.getID());
	}

	public ResultMessage modifyDriver(DriverVO driver) throws RemoteException {
		DriverPO driverPO = FacilityTrans.convertVOtoPO(driver);
		return DriverData.modify(driverPO);
	}

	public ArrayList<DriverVO> findDriver() throws RemoteException {
		ArrayList<DriverPO> driverPOs = DriverData.find();
		ArrayList<DriverVO> driverVOs = FacilityTrans.convertDriverPOstoVOs(driverPOs);
		return driverVOs;

	}


}
