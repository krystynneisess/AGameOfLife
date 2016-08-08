class Tile {
	int pid;
	int x;
	int y;
	Species species;

	// Constructors
	public Tile() {
		pid = -1;
		x = -1;
		y = -1;
		species = new Species();
	}

	public Tile(int x, int y) {
		pid = -1;
		x = x;
		y = y;
		species = new Species();
	}

	// Getters
	public int getPid() {
		return pid;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Species getSpecies() {
		return species;
	}

	// Setters
	public void setPid(int p) {
		pid = p;
	}

	public void setX(int x) {
		x = x;
	}

	public void setY(int y) {
		y = y;
	}

	public void setSpecies(Species s) {
		species = s;
	}

	// Utilities
	public boolean isOccupied() {
		return pid != -1;
	}
}