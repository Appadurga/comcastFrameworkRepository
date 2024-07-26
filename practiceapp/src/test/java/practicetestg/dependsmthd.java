package practicetestg;

import org.testng.annotations.Test;

public class dependsmthd {
		@Test
	public void createname()
	{
			System.out.println("durga");
			}
		@Test(dependsOnMethods="createname")
		public void createanumber()
		{
			System.out.println("7892187323");
		}
	}

