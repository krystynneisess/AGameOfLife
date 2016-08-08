import java.util.HashMap;

class Species {
	int id;
	String name;
	private HashMap<Integer, String> idLookup;

	// Constructors 
	public Species() {
		id = -1;
		name = "";
		idLookup = initMap();
	}

	public Species(int i) {
		idLookup = initMap();
		id = i;
		name = idLookup.get(i);
	}

	private HashMap<Integer, String> initMap() {
		HashMap<Integer, String> h = new HashMap<Integer, String>();
		h.put(0, "red");
		h.put(1, "blue");

		return h;
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
		name = idLookup.get(i);
	}

}