package com.msyidai.cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.msyidai.actions.BackLogin;
import com.msyidai.actions.LoanInput;

public class PersonLoanInputTest extends TestBase {
	@Test( description = "个人标的还款测试")
	@Parameters({"personLoanassetId","personLoanamount","personLoanrate"})
	public void personLoanInputTest(String assetId, String amount, String rate) {
		BackLogin backLogin = new BackLogin();
		LoanInput loanInput=new LoanInput();
		backLogin.backLogin("admin", "password").loanInput.personLoanInput(assetId, amount, rate);
		assertion.assertEquals(loanInput.getResult().contains("成功"), "成功");
	}

	@DataProvider(name = "foreignLoanInPutTestData")
	public Object[][] foreignLoanInPutTestData() {
		return new Object[][] { { "ZC_20180115_175832", "5000", "12" } };

	}
}
