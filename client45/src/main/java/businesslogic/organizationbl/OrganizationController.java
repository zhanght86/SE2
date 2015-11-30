package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.organizationblservice.OrganizationBLService;
import state.ResultMessage;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public class OrganizationController implements OrganizationBLService {
	
	Organization organization = new Organization();

	@Override
	public ArrayList<BranchVO> showBranch() {
		try {
			return organization.showBranch();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getBranchID(String city) {
		try {
			return organization.getBranchID(city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addBranch(BranchVO vo) {
		try {
			return organization.addBranch(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteBranch(String organizationID) {
		try {
			return organization.deleteBranch(organizationID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage updateBranch(BranchVO vo) {
		try {
			return organization.updateBranch(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	
	
	public ArrayList<TransferVO> showTransfer() {

		try {
			return organization.showTransfer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String getTransferID(String city) {
		try {
			return organization.getTransferID(city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addTransfer(TransferVO vo) {
		try {
			return organization.addTransfer(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteTransfer(String organizationID) {
		try {
			return organization.deleteTransfer(organizationID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage updateTransfer(TransferVO vo) {
		try {
			return organization.updateTransfer(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public String getID() {
		/**
		 * @author Ann
		 */
		//我觉得没有必要getID
		// TODO getID
		return null;
	}

	@Override
	public ArrayList<String> getAllBranchNumbers() {
		try {
			return organization.getAllBranchNumbers();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) {
		try {
			return organization.getAccountsByOrganizationID(organizationID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID) {
		try {
			return organization.getFacilitiesByBranchID(branchID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID) {
		try {
			return organization.getInventoriesByTransferID(transferID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
