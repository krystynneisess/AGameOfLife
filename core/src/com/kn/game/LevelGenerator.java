import java.util.HashMap;

class LevelGenerator {

	// Constructors
	public LevelGenerator() {
		// nothing to do.
	}

	public Level generate(int i) {
		Level l = new Level();
		HashMap<Integer, Integer> p1Map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> p2Map = new HashMap<Integer, Integer>();

		switch (i) {
			case 1:
				l.getBoard().setLen(4);

				// set p1 pieces.
				p1Map.put(0, 2);
				p1Map.put(0, 2);
				l.setP1Pieces(p1Map);

				// set p2 pieces.
				p2Map.put(0, 2);
				p2Map.put(0, 2);
				l.setP2Pieces(p2Map);

				break;
			case 2:
				l.getBoard().setLen(6);
				
				// set p1 pieces.
				p1Map.put(0, 3);
				p1Map.put(0, 3);
				l.setP1Pieces(p1Map);

				// set p2 pieces.
				p2Map.put(0, 3);
				p2Map.put(0, 3);
				l.setP2Pieces(p2Map);

				break;
			default:
				break;
		}

		return l;

	}
}