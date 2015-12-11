package businesslogic.basebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import command.BaseCommandController;
import command.Command;
import config.RMIConfig;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import state.ConfirmState;
import state.ResultMessage;
import vo.BaseVO;

/**
 * 管理公司成本常量
 * 
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:24
 */
public class Base {
	private BaseDataService baseData;
	private BaseCommandController commandController;
	public Base() throws MalformedURLException, RemoteException, NotBoundException {
		commandController = new BaseCommandController("base");
		baseData = getData();
	}

	public BaseDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (BaseDataService) Naming.lookup(RMIConfig.PREFIX + BaseDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public String getID() throws RemoteException {
		return baseData.getID();
	}

	public ResultMessage addBase(BaseVO vo) throws RemoteException {
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		return baseData.add(basePO);
	}

	public ResultMessage deleteBase(String ID) throws RemoteException {
		BasePO po =  baseData.delete(ID);
		if(po==null){
			return ResultMessage.FAIL;
		}else{
			commandController.addCommand(new Command<BasePO>("delete", po));
			return ResultMessage.SUCCESS;
		}
	}

	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		ResultMessage message = baseData.modify(basePO);
		return message;
	}

	public ArrayList<BaseVO> show() throws RemoteException {
		ArrayList<BasePO> pos = baseData.find();
		ArrayList<BaseVO> vos = BaseTrans.convertBasePOstoVOs(pos);
		return vos;
	}

	public BaseVO find(String id) throws RemoteException {
		ArrayList<BasePO> pos = baseData.find();
		for (BasePO basePO : pos) {
			if (basePO.getID().equals(id)) {
				return BaseTrans.convertPOtoVO(basePO);
			}
		}
		return null;
	}

}
