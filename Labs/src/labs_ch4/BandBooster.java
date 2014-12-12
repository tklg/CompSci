package labs_ch4;

public class BandBooster {
	
	String name;
	int boxesSold;
	
	
	public BandBooster(String n) {
		boxesSold = 0;
		name = n;
	}
	
	public String getName() {
		return name;
	}
	public void updateSales(int num) {
		boxesSold += num;
	}
	public String toString() {
		return (getName() + ":\t" + boxesSold + " boxes");
	}

}
