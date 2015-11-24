package output;

import java.util.ArrayList;
import java.util.List;

import util.ExportExcel;
import vo.receiptvo.ExpenseVO;

public class TestExcel {
	public static void main(String[] args) {
		String[] title = {"ID","地区","价格","又一个地区","时间"};
		List<Object> expenses = new ArrayList<Object>();
		for (int i = 0; i < 80; i++) {
			ExpenseVO vo = new ExpenseVO(i+"", "南京", i*100, "南京");
			expenses.add(vo);
		}
		String fileName = "output/testExcel.xls";
		String result = ExportExcel.exportExcel(fileName, title, expenses);
		System.out.println(result);
	}
}
