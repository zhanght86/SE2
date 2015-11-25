package businesslogicservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice._Order_Data_Stub;
import po.OrderPO;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;

public class _Order_Stub implements OrderBLService {

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("You have confirmed!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ResultMessage addOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
		OrderPO orderPO = null;
//				new OrderPO(order.ID, null, order.senderName, order.senderAddress, order.senderTel,
//				order.senderCo, order.recipientName, order.recipientAddress, order.recipientTel, order.recipientCo,
//				commmodities, order.midAddres, order.sendTime, order.recipientTime, order.money);
		OrderDataService orderDataService = new _Order_Data_Stub();
		try {
			orderDataService.add(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public OrderVO inquireOrder(String orderNumber, String senderName) {
		OrderDataService orderDataService = new _Order_Data_Stub();
		System.out.println("Inquire an order!");
		OrderPO orderPO = null;
		try {
			orderPO = orderDataService.find(orderNumber);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (orderPO != null && orderPO.getSenderName() == senderName) {
			System.out.println("Found!");
			return new OrderVO(orderPO.getSendTime(), orderPO.getRecipientTime(), orderPO.getMoney());
		} else {
			System.out.println("Not Found");
			return null;
		}
	}

	public ResultMessage updateOrder(ArrayList<CommodityVO> commmodities, OrderVO order) {
		OrderPO orderPO = null;;
		OrderDataService orderDataService = new _Order_Data_Stub();
		try {
			orderDataService.modify(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage costAndTime(OrderVO order) {
		System.out.println("Recipient time:" + order.recipientTime);
		System.out.println("Cost:" + order.money);
		return ResultMessage.SUCCESS;
	}

}
