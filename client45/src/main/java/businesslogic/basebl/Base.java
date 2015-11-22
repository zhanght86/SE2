package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.facility.FacilityTrans;
import businesslogicservice.baseblservice.BaseBLService;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import po.FacilityPO;
import state.ConfirmState;
import state.FindTypeBase;
import state.ResultMessage;
import vo.BaseVO;

public class Base implements BaseBLService{
	private BaseDataService baseData;
	public Base() {
		try {
			baseData = (BaseDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+BaseDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}
	@Override
	public ArrayList<BaseVO> show(FindTypeBase baseType) throws RemoteException {
		ArrayList<BasePO> pos=baseData.find(baseType);
		ArrayList<BaseVO> vos=new ArrayList<BaseVO>();
		for(BasePO po:pos){
			BaseVO vo=POtoVO(po);
			vos.add(vo);
		}
		 return vos;
	}
	public BaseVO POtoVO(BasePO po){
		BaseVO vo=new BaseVO(po.getID(),po.getDistances(), po.getPrice(), po.getSalaryPolicies());
		return vo;
	}
	
	public BasePO VOtoPO(BaseVO vo){
		BasePO po=new BasePO(vo.getId(), vo.getDistances(), vo.getPrice(), vo.getSalaryPolicies());
		return po;
	}
	@Override
	public String getID(FindTypeBase baseType) throws RemoteException {
		return baseData.getID(baseType);
	}
	@Override
	public ResultMessage addBase(BaseVO vo) throws RemoteException {
		BasePO PO = VOtoPO(vo);
		return baseData.add(PO);
	}
	@Override
	public ResultMessage deleteBase(String ID) throws RemoteException {
		return baseData.delete(ID);
	}
	@Override
	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
		BasePO PO = VOtoPO(vo);
		return baseData.modify(PO);
	}
}
