class Player {
	int id;
	String name;

	// Constructors
	public Player() {
		id = -1;
		name = "";
	}

	public Player(int i, String n) {
		id = i;
		name = n;
	}

	// Getters 
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Setters
	public void setId(int i) {
		id = i;
	}

	public void setName(String n) {
		name = n;
	}
}