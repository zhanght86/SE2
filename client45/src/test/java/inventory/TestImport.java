package inventory;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import state.ResultMessage;
import vo.InventoryImportReceiptVO;
import vo.InventoryVO;

public class TestImport {
	private ResultMessage SUCCESS;

	@Test	
	public void testImport()throws RemoteException{
		InventoryImportReceiptVO importReceipt=new InventoryImportReceiptVO(null, null, null, 0, 0, 0, 0);
		MockInventoryImport test=new MockInventoryImport();
		assertEquals("1",test.getImportID());
		assertEquals("nanjing520",test.getCommodities());
		assertEquals("nanjing",test.getDestination());
		assertEquals((new InventoryVO(null,null,1, 1, 1, 1,"full")).getA(),(test.addPlace()).getA());
		assertEquals((new InventoryVO(null,null,1, 1, 1, 1,"full")).getB(),(test.addPlace()).getB());
		assertEquals((new InventoryVO(null,null,1, 1, 1, 1,"full")).getC(),(test.addPlace()).getC());
		assertEquals((new InventoryVO(null,null,1, 1, 1, 1,"full")).getD(),(test.addPlace()).getD());
		assertEquals(SUCCESS,test.submitImport(importReceipt));
	}
	
}
