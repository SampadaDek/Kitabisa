package mavenDemo;

public class ArrayComparison {

	public static void main(String[] args) {
		String months[] = {"Jan", "Feb", "March", "April", "May", "June"};
		String days[] = {"Mon", "Tue", "Wed", "May", "Jan"};
		
		for(int i=0;i<months.length;i++)
		{
			for(int j=0; j< days.length; j++)
			{
				if (months[i] == days[j])
					System.out.println(months[i]);
				
			}
		}
		
	}

}
