package businesslogicservice.transferblservice;

import java.util.ArrayList;

import po.OrderPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.TransferArrivalListPO;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.TransferArrivalListVO;
import vo.receiptvo.TransferOrderVO;

public class _Transfer_Stub implements TransferBLService {

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("You have confirmed!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() {
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
		System.out.println("You get all orderPOs");
		ArrayList<CommodityVO> allCommodityVOs = new ArrayList<>();
		System.out.println("Get commodities from orderPOs");
		for(int i=0;i<orderPOs.size();i++){
			OrderPO orderPO = orderPOs.get(i);
			ArrayList<CommodityVO> oneCommodityVOs = orderPO.getCommodityVO();
			for (CommodityVO commodityVO : oneCommodityVOs) {
				allCommodityVOs.add(commodityVO);
			}
		}
		System.out.println("You have got all commodities!");
		return allCommodityVOs;
	}

	@Override
	public TransferOrderVO planeTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		TransferOrderVO transferOrderVO = new TransferOrderVO(facilityID, null, departure, destination, courierName, orders);
		System.out.println("You have added a plane transfer");
		return transferOrderVO;
	}

	@Override
	public TransferOrderVO truckTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		TransferOrderVO transferOrderVO = new TransferOrderVO(facilityID, null, departure, destination, courierName, orders);
		System.out.println("You have added a truck transfer");
		return transferOrderVO;
	}

	@Override
	public TransferOrderVO trainTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		TransferOrderVO transferOrderVO = new TransferOrderVO(facilityID, null, departure, destination, courierName, orders);
		System.out.println("You have added a train transfer");
		return transferOrderVO;
	}

	@Override
	public ResultMessage submit(ReceiptPO receipt) {
		System.out.println("You have submit a receipt");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage save(ReceiptPO receipt) {
		System.out.println("You have saved a receipt");
		return ResultMessage.SUCCESS;
	}

	@Override
	public TransferArrivalListVO receiptList(String transferID, String departure,String destination, CommodityState state,
			ArrayList<String> orders) {
		TransferArrivalListVO transferArrivalListVO = new TransferArrivalListVO(transferID, null, transferID, departure, destination, state, orders);
		TransferArrivalListPO transferArrivalListPO = new TransferArrivalListPO(transferID, null, transferID, departure, destination,state, orders);
		System.out.println("You have fielded a receipt");
		ResultMessage resultMessage = this.submit(transferArrivalListPO);
		if(resultMessage==ResultMessage.SUCCESS){
			System.out.println("The receipt has passed!");
			this.save(transferArrivalListPO);
		}else{
			System.out.println("The receipt has not passed!");
		}
		return transferArrivalListVO;
	}

}
