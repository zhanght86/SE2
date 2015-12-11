package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import command.AccountCommandController;
import command.Command;
import po.accountpo.AccountPO;
import state.ResultMessage;
import vo.accountvo.AccountVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:31:56
 */
public class AccountController implements AccountBLService {
	private Account AccountBL;
	private AccountCommandController commandController;
	public AccountController() throws MalformedURLException, RemoteException, NotBoundException {
		AccountBL = new Account();
		commandController = new AccountCommandController("account");
	}
	/**
	 * @see AccountBLService#show()
	 */
	public ArrayList<AccountVO> show() throws RemoteException {
		return AccountBL.show();
	}

	/**
	 * @see AccountBLService#show(String)
	 */
	public ArrayList<AccountVO> show(String duty) throws RemoteException {
		return AccountBL.show(duty);
	}

	/**
	 * @see AccountBLService#getID()
	 */
	public String getID() throws RemoteException {
		return AccountBL.getID();
	}

	/**
	 * @see AccountBLService#addAccount(AccountVO)
	 */
	public ResultMessage addAccount(AccountVO vo) throws RemoteException {
		return AccountBL.addAccount(vo);
	}

	/**
	 * @see AccountBLService#deleteAccount(String)
	 */
	public ResultMessage deleteAccount(String ID) throws RemoteException {
		AccountPO account =  AccountBL.deleteAccount(ID);
		if(account==null)
			return ResultMessage.FAIL;
		else{
			commandController.addCommand(new Command<AccountPO>("delete", account));
			//c
			return ResultMessage.SUCCESS;
		}
	}

	/**
	 * @see AccountBLService#updateAccount(AccountVO)
	 */
	public ResultMessage updateAccount(AccountVO vo) throws RemoteException {
		return AccountBL.updateAccount(vo);
	}

	/**
	 * @see AccountBLService#find(String)
	 */
	public AccountVO find(String id) throws RemoteException {
		return AccountBL.find(id);
	}

}
