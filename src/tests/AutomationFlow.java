package tests;

import org.testng.annotations.Test;

import utilities.Basetest;

public class AutomationFlow extends Basetest {

	pageElements.LandingPage lp;
	pageElements.CloseBrowser cs;
	pageElements.TC1_RegisterUser t1;
	pageElements.TC2_corretautentication t2;
	pageElements.TC3_incorrectautentication t3;
	pageElements.TC4_logoutuser t4;

	@Test
	public void tc1() throws Exception {
		lp = LaunchApplication();

		t1 = lp.usersignup();
		t2 = t1.testcase1();
	}

	@Test(dependsOnMethods = { "tc1" })
	public void tc2() throws Exception {
		t3 = t2.testcase2();
		t4 = t3.testcase3();
	}
	
	@Test(dependsOnMethods = { "tc2" })
	public void tc4() throws Exception {
		t4.testcase4();
	}
}
