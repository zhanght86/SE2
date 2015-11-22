package ui.specialui.manager.HandleReceipt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;

import ui.myui.MyTable;
import ui.myui.MyTranslucentPanel;

public class Panel_Manager_SearchReceipt extends MyTranslucentPanel{
	private JTable table;
	private MyJButton selectButton;
	private MyComboBox receiptTypeList;
	private MyComboBox receiptStateList;
	public Panel_Manager_SearchReceipt() {
		super(30,100, 655, 540);
		this.initComponent();
		// TODO Auto-generated constructor stub
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		String [] receiptType = {"所有单据","寄件订单","装车单","收件确认单","营业厅到达单","营业厅派件单","收款单","付款单","中转中心到达单","飞机转运单","火车转运单","卡车转运单","入库单","出库单","库存调整单"};
		String [] receiptState = {"所有状态","草稿","正在审批","通过审批","未通过审批"};
		
		MyJLabel receiptTypeLabel= new MyJLabel(20,10,120,30, "选择单据类别",14,true);
		this.add(receiptTypeLabel);
		
		MyJLabel receiptStateLabel = new MyJLabel(295,10,120,30,"选择单据状态",14,true);
		this.add(receiptStateLabel);
		
		selectButton = new MyJButton(555,10,90,30,"搜索",14);
		selectButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("111");
			//清空VO储存池s
		//	listPool.clear();
			//typePool.clear();
			
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			int rowCount = table.getRowCount();
			
			for(int k = 0; k < rowCount; k++)
				tableModel.removeRow(0);
			
			if(receiptTypeList.getSelectedIndex() == 1){
				try {
					getApprovalData(receiptStateList.getSelectedIndex());
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
			}else if(receiptTypeList.getSelectedIndex() == 2){
				try {
					getPassData(receiptStateList.getSelectedIndex());
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
			}else if(receiptTypeList.getSelectedIndex() == 3){
				try {
					getFailureData(receiptStateList.getSelectedIndex());
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
			}else{
				try {
					getApprovalData(receiptStateList.getSelectedIndex());
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				try {
					getPassData(receiptStateList.getSelectedIndex());
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				try {
					getFailureData(receiptStateList.getSelectedIndex());
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
			}
			
			if(table.getRowCount() == 0){
				//WarningFrame wf = new WarningFrame("目前没有符合条件的单据!");
				//wf.setVisible(true);
			}
		}
			
	});
		this.add(selectButton);

		receiptTypeList = new MyComboBox(135,10,150,30,14,receiptType);
		this.add(receiptTypeList);
		
		receiptStateList = new MyComboBox(395,10,150,30,14,receiptState);
		this.add(receiptStateList);
		
		//the table
		String[] headers = {"选择","单据编号","单据种类","单据状态"};
		MyTable	table = new MyTable(headers);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new MyFont(14));
					
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
							  	
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setResizingAllowed(false);
						
		jsp.setBounds(10, 50, 630, 485);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		
		  
	}

	private static final long serialVersionUID = 1L;
	
	private void getApprovalData(int index) throws RemoteException{
	}
	
	private void getPassData(int index) throws RemoteException{
		
	}
	
	private void getFailureData(int index) throws RemoteException{
		
	}
	
	private void initTable(){
		ReceiptTableModel tablemodel = new ReceiptTableModel();
		
		table = new JTable(tablemodel);
		table.setCellSelectionEnabled(false);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);	
		JTableHeader head = table.getTableHeader();
		
		
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(30);
		firsetColumn.setMaxWidth(30);
		firsetColumn.setMinWidth(30);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setMaxWidth(110);
		table.getColumnModel().getColumn(1).setMinWidth(110);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setMaxWidth(180);
		table.getColumnModel().getColumn(2).setMinWidth(180);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(85, 95, 380, 465);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);	
	}
	
	

}
