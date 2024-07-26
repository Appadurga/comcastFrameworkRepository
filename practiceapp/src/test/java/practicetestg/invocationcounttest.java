package practicetestg;

import org.testng.annotations.Test;

public class invocationcounttest {
	@Test(invocationCount = 5)
	public void createname()
	{
			System.out.println("durga");
			}
		@Test(priority = 1)
		public void createanumber()
		{
			System.out.println("7892187323");
		}

}
