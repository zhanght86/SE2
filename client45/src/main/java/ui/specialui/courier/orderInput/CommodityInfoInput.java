package ui.specialui.courier.orderInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJRadioButton;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class CommodityInfoInput extends MyTranslucentPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField commodityNumField;
	private MyJTextField commodityVolumnField;
	private MyJTextField commodityWeightField;
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
		this.add(new MyJLabel(190, 104, 120, 20, "实际体积/m^3", 15, true));
		this.add(new MyJLabel(360, 104, 120, 20, "实际重量/kg", 15, true));
		this.add(new MyJLabel(50, 150, 80, 20, "包装类型", 15, true));
		this.add(new MyJLabel(300, 150, 80, 20, "快递类型", 15, true));
		this.add(new MyJLabel(50, 250, 80, 20, "货物名", 15, true));
		this.add(new MyJLabel(290, 250, 80, 20, "货物种类", 15, true));
		
		commodityNumField = new MyJTextField(130, 100, 50, 30);
		commodityNumField.setOnlyInteger(3);
		this.add(commodityNumField);
		
		commodityVolumnField = new MyJTextField(300, 100, 50, 30);
		commodityVolumnField.setOnlyInteger(3);
		this.add(commodityVolumnField);
		
		commodityWeightField = new MyJTextField(460, 100, 50, 30);
		commodityWeightField.setOnlyInteger(4);
		this.add(commodityWeightField);
		
		String[] packs = {"纸盒", "塑料", "泡沫", "金属"};
		packKindField = new MyJComboBox(130, 150, 130, 30, packs);
		this.add(packKindField);
		
		String[] deliveries = {"顺丰", "EMS", "圆通", "中通", "申通", "圆通", "韵达", "京东"};
		deliveryKindField = new MyJComboBox(380, 150, 130, 30, deliveries);
		this.add(deliveryKindField);
		
		choseCompareWeight = new MyJRadioButton(50, 200, 180, 20, "是否进行重量矫正");
		this.add(choseCompareWeight);
		
		MyJTextField commodityNameField = new MyJTextField(110, 250, 150, 30);
		this.add(commodityNameField);
		
		MyJTextField commodityKindField = new MyJTextField(360, 250, 150, 30);
		this.add(commodityKindField);
				
		commodityList = new MyJTable(new String[]{"名称", "种类"}, false);
		MyJScrollPane jsp = new MyJScrollPane(50, 340, 460, 135, commodityList);
		this.add(jsp);
		
		MyJButton addCommodity = new MyJButton(50, 300, 110, 20, "添加货物", 15);
		addCommodity.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String[] data = new String[2];
				data[0] = commodityNameField.getText();
				data[1] = commodityKindField.getText();
				if((!data[0].equals(""))&&(!data[1].equals(""))){			
					commodityList.addRow(data);
					commodityNameField.setText(null);
					commodityKindField.setText(null);
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
		String[] info = new String[5];
		info[0] = commodityNumField.getText();
		info[1] = commodityVolumnField.getText();
		info[2] = commodityWeightField.getText();
		info[3] = (String) packKindField.getSelectedItem();
		info[4] = (String) deliveryKindField.getSelectedItem();
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

	public String[] getCommodityList() {
		String[][] data = commodityList.getData();
		if(data.length == 0){
			return null;
		}
		String[] commodities = new String[data.length];
		for(int i = 0; i < data.length; i++){
			commodities[i] = data[i][0] + " " + data[i][1];
		}
		return commodities;
	}
}