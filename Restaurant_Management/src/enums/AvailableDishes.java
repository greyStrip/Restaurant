package enums;

public enum AvailableDishes {
	TEA(1,5),
	COFFEE(2,5),
	MEAL(3,10),
	PASTRIES(4,5),
	JUICE(5,6);
	
	private int id;
	private int timeTaken;
	
	private AvailableDishes(int id, int timeTaken) {
		this.id = id;
		this.timeTaken = timeTaken;
	}

	public int getId() {
		return id;
	}

	public int getTimeTaken() {
		return timeTaken;
	}
	
}
