package ui.commonui.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJRadioButton;
import ui.myui.MyJTextField;
import ui.myui.MyLogo;
import ui.myui.MyPasswordField;
import ui.myui.MyTitle;
/**
 * 登陆界面 Panel
 * @author  zsq
 * @time 下午4:08:40
 */
public class Panel_Login extends MyJPanel{
	private static final long serialVersionUID = 1L;
	private MyJTextField userIdField;
	private MyPasswordField passwordField;
	private MyJRadioButton keepPassword;
	private MyButton login;
	private MyButton search;
	
	public Panel_Login(Frame_Login frame_Login) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyLogo.setLogo(this);
		MyTitle.setTitle(this, "快递物流系统",450,115, 380, 72);
		
		this.initComponent(frame_Login);
	}
	
	private void initComponent(Frame_Login frame_Login){
		this.add(new MyJLabel(450, 388, 90, 40,"用户ID",18,true));
		this.add(new MyJLabel(450,443,90,40,"密码",18,true));
		
		search = new MyButton(15,15,35,35, LoginImage.getBUTTON_LOGISTIC());
		search.setActionCommand("Search");
		search.addActionListener(frame_Login);
		this.add(search);
		
		userIdField = new MyJTextField(535, 385, 210, 45);
		userIdField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==userIdField){
					passwordField.requestFocus();
				}
				
			}
			
		});
		userIdField.setOnlyInteger(9);
		this.add(userIdField);

		passwordField = new MyPasswordField(535, 445, 210, 45);
		this.add(passwordField);
		
		keepPassword= new MyJRadioButton(645,495,200,30,"记住密码");
		keepPassword.addActionListener(frame_Login);
		this.add(keepPassword);
		
	/*	login = new MyButton(571,580,137,30,LoginImage.getBUTTON_LOGIN());
		login.setActionCommand("login");
		System.out.println("111");
		login.registerKeyboardAction(frame_Login, 
		        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), 
		        JComponent.WHEN_IN_FOCUSED_WINDOW); 
		System.out.println("112");
		login.addKeyListener(new KeyAdapter(){ 
			
		    public void keyPressed(KeyEvent event){ 
		    	System.out.println("113");
		    	if (KeyEvent.getKeyText(event.getKeyCode()).compareToIgnoreCase("Enter") == 0){ 
		    		System.out.println("114");
		    		login.doClick(); 
		    		System.out.println("115");
		    	} 
	    	} 
		}); 
		login.addActionListener(frame_Login);
		this.add(login);*/
	}
	
	public String[] getData(){
		String[] data = new String[2];
		data[0] = userIdField.getText();
		data[1] = new String(passwordField.getPassword());
		return data;
	}
}
