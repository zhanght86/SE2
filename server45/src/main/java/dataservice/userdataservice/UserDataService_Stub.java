package dataservice.userdataservice;

import java.util.ArrayList;

import po.PersistentObject;
import po.UserPO;
import state.ResultMessage;
import state.UserAuthority;
import state.UserIdentity;

public class UserDataService_Stub implements UserDataService{
	
	private ArrayList<UserPO> userPOs;
	
	private UserPO userPO_1;
	private UserPO userPO_2;
	public UserDataService_Stub(){
		userPOs = new ArrayList<UserPO>();
	
		userPO_1 = new UserPO("username1", "name1",  "password",UserIdentity.GENERAL_MANAGER,"operationRecords", UserAuthority.MANAGER_LEVEL);
		
		userPOs.add(userPO_1);
		userPOs.add(userPO_2);
	}
	@Override
	public ResultMessage insert(PersistentObject po) {
		System.out.println("Insert a user succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a user succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(PersistentObject PO) {
		System.out.println("Update the information of a user succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserPO> find() {
		System.out.println("Show all the users succeed!");
		return userPOs;
	}

	@Override
	public UserIdentity login(LoginInfo loginInfo) {
		System.out.println("Login succeed!");
		return UserIdentity.GENERAL_MANAGER;
	}

	@Override
	public ResultMessage updateAdmin(String oldPassword, String newPassword) {
		System.out.println("UpdataAdmin succeed!");
		return ResultMessage.SUCCESS;
	}

}