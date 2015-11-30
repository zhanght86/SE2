package po.receiptpo;

import state.ReceiptType;

public class InventoryImportReceiptPO extends ReceiptPO {
	/**
	 * @author lxl
	 * @version Oct 23,2015
	 **/

	private static final long serialVersionUID = 1L;

	// 目的地
	private String depture;
	private String destination;
	private String CommoditiesID;
	private int area;
	private int row;
	private int frame;
	private int position;
	public InventoryImportReceiptPO(String ID, ReceiptType type, String depture, String destination,
			String commoditiesID, int area, int row, int frame, int position) {
		super(ID, type);
		this.depture = depture;
		this.destination = destination;
		this.CommoditiesID = commoditiesID;
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
	}
	public String getDepture() {
		return depture;
	}
	public void setDepture(String depture) {
		this.depture = depture;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getFrame() {
		return frame;
	}
	public void setFrame(int frame) {
		this.frame = frame;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCommoditiesID() {
		return CommoditiesID;
	}
	public void setCommoditiesID(String commoditiesID) {
		CommoditiesID = commoditiesID;
	}

	
}
