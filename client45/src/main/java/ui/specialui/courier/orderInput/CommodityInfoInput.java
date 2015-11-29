package ui.specialui.courier.orderInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import state.CommodityState;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJRadioButton;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;
import vo.CommodityVO;

public class CommodityInfoInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField commodityNumField;
	private MyJComboBox packKindField;
	private MyJComboBox deliveryKindField;
	private MyJRadioButton choseCompareWeight;
	private MyJTable commodityList;
	
	public CommodityInfoInput() {
		super(620, 100, 550, 510);
		this.initComponent();
	}

	private void initComponent() {
		this.add(new MyJLabel(215, 30, 140, 40, "托运货物信息", 22, true));
		this.add(new MyJLabel(50, 104, 80, 20, "原件数/件", 15, true));
		this.add(new MyJLabel(50, 150, 80, 20, "包装类型", 15, true));
		this.add(new MyJLabel(300, 150, 80, 20, "快递类型", 15, true));
		this.add(new MyJLabel(50, 200, 80, 20, "货物种类", 15, true));
		this.add(new MyJLabel(50, 250, 120, 20, "实际体积/m^3", 15, true));
		this.add(new MyJLabel(300, 250, 120, 20, "实际重量/kg", 15, true));
		
		commodityNumField = new MyJTextField(130, 100, 50, 30);
		commodityNumField.setOnlyInteger(3);
		this.add(commodityNumField);
		
		choseCompareWeight = new MyJRadioButton(300, 104, 180, 20, "是否进行重量矫正");
		this.add(choseCompareWeight);
		
		String[] packs = {"纸盒", "塑料", "泡沫", "金属"};
		packKindField = new MyJComboBox(130, 150, 130, 30, packs);
		this.add(packKindField);
		
		String[] deliveries = {"汽车", "火车", "飞机"};
		deliveryKindField = new MyJComboBox(380, 150, 130, 30, deliveries);
		this.add(deliveryKindField);
		
		MyJTextField commodityKindField = new MyJTextField(130, 200, 130, 30);
		this.add(commodityKindField);
			
		MyJTextField commodityVolumnField = new MyJTextField(160, 250, 100, 30);
		commodityVolumnField.setOnlyDouble();;
		this.add(commodityVolumnField);
		
		MyJTextField commodityWeightField = new MyJTextField(400, 250, 110, 30);
		commodityWeightField.setOnlyDouble();
		this.add(commodityWeightField);
		
		commodityList = new MyJTable(new String[]{"种类", "体积", "重量"}, false);
		MyJScrollPane jsp = new MyJScrollPane(50, 340, 460, 135, commodityList);
		this.add(jsp);
		
		MyJButton addCommodity = new MyJButton(50, 300, 110, 20, "添加货物", 15);
		addCommodity.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String[] data = new String[3];
				data[0] = commodityKindField.getText();
				data[1] = commodityWeightField.getText();
				data[2] = commodityVolumnField.getText();
				if((!data[0].equals(""))&&(!data[1].equals(""))&&(!data[2].equals(""))){			
					commodityList.addRow(data);
					commodityKindField.setText(null);
					commodityVolumnField.setText(null);
					commodityWeightField.setText(null);
				}
			}
		});
		this.add(addCommodity);
		
		MyJButton deleteCommodity = new MyJButton(180, 300, 110, 20, "删除选中货物", 15);
		deleteCommodity.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				commodityList.removeRow();
			}
		});
		this.add(deleteCommodity);
		
		MyJButton clearCommodity = new MyJButton(310, 300, 110, 20, "清空货物", 15);
		clearCommodity.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				commodityList.clear();
			}
		});
		this.add(clearCommodity);
	}

	public String[] getCommodityInfo() {
		String[] info = new String[3];
		info[0] = commodityNumField.getText();
		info[1] = (String) packKindField.getSelectedItem();
		info[2] = (String) deliveryKindField.getSelectedItem();
		for (String string : info) {
			if(string.equals("")) return null;
		}
		return info;
	}

	/**
	 * @return 是否比较实际重量与计算重量
	 */
	public boolean isCompareWight() {
		return choseCompareWeight.isSelected();
	}

	public ArrayList<CommodityVO> getCommodityList() {
		String[][] data = commodityList.getData();
		if(data.length == 0){
			return null;
		}
		ArrayList<CommodityVO> commodities = new ArrayList<CommodityVO>();
		for(int i = 0; i < data.length; i++){
			commodities.add(new CommodityVO(data[i][0], Double.parseDouble(data[i][1]), Double.parseDouble(data[i][2]), CommodityState.Success));
		}
		return commodities;
	}

	/**
	 * 界面刷新
	 */
	public void refresh() {
		commodityNumField.setText(null);
		packKindField.setSelectedIndex(0);
		deliveryKindField.setSelectedIndex(0);
		choseCompareWeight.setSelected(false);
		commodityList.clear();
	}
}