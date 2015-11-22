package dataservice.userdataservice;

import java.rmi.RemoteException;

import dataservice.ManageDataService;
import po.UserPO;
import state.ResultMessage;
import state.UserIdentity;

/**
 *提供系统用户集体载入、增删改查的服务
 *@author zsq
 *@version Oct 22,2015 
 */
public interface  UserDataService extends ManageDataService<UserPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "UserData";
	/**
	 * 增加一名系统用户
	 * @param po
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015 
	 */
//	public ResultMessage insert(UserPO po) throws RemoteException;
	/**
	 * 删除一名系统用户
	 * @param ID
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015 
	 */
//	public ResultMessage delete(String ID) throws RemoteException;
	/**
	 * 更新UserPO
	 * @param PO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015 
	 */
//	public ResultMessage update(UserPO PO) throws RemoteException;
	/**
	 *显示UserPO
	 * @return 返回所有的UserPO的集合
	 * @author zsq
	 * @version
	 */
//	public ArrayList<UserPO> find() throws RemoteException;
	/**
	 * 验证用户登录
	 * @param loginInfo
	 * @return 返回登录的用户的身份，登录失败时返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException;
	
	/**
	 * @param oldPassword，旧密码
	 * @param newPassword，新密码
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateAdmin(String oldPassword,String newPassword) throws RemoteException;
	/**
	 * @author Ann
	 * @return
	 * @throws RemoteException
	 */
	public String getID() throws RemoteException;
}