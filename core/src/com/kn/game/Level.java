import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

class Level {
	Board b;
	HashMap<Integer, Integer> p1_pieces;
	HashMap<Integer, Integer> p2_pieces;
	int winnerPid; // pid of winner

	// Constructors
	public Level() {
		b = new Board();
		p1_pieces = new HashMap<Integer, Integer>();
		p2_pieces = new HashMap<Integer, Integer>();
		winnerPid = -1;
	}

	public Level(int len) {
		b = new Board(len);
		p1_pieces = new HashMap<Integer, Integer>();
		p2_pieces = new HashMap<Integer, Integer>();
		winnerPid = -1;
	}

	// Getters
	public Board getBoard() {
		return b;
	}
	public HashMap<Integer, Integer> getP1Pieces() {
		return p1_pieces;
	}
	public HashMap<Integer, Integer> getP2Pieces() {
		return p2_pieces;
	}
	public int getWinnerPid() {
		return winnerPid;
	}

	// Setters
	public void setBoard(Board board) {
		b = board;
	}
	public void setP1Pieces(HashMap<Integer, Integer> map) {
		p1_pieces = map;
	}
	public void setP2Pieces(HashMap<Integer, Integer> map) {
		p2_pieces = map;
	}
	public void setWinnerPid(int i) {
		winnerPid = i;
	}

	// Utilities
	public boolean isLevelOver() {
		return b.isGameOver();
	}

	private boolean movesRemain() {
		Iterator itP1 = p1_pieces.entrySet().iterator();
		while (itP1.hasNext()) {
			Map.Entry entry = (Map.Entry) itP1.next();
			int piecesRemaining = (Integer) entry.getValue();
			if (piecesRemaining > 0) {
				return true;
			}
		}

		Iterator itP2 = p2_pieces.entrySet().iterator();
		while (itP2.hasNext()) {
			Map.Entry entry = (Map.Entry) itP2.next();
			int piecesRemaining = (Integer) entry.getValue();
			if (piecesRemaining > 0) {
				return true;
			}
		}

		return false;
	}

	// 1-2-3! testing, testing!
	// public static void main(String[] args) {
	// 	Level l = new Level();
	// 	System.out.println("false? " + l.movesRemain());

	// 	HashMap<Integer, Integer> p1_testpieces = new HashMap<Integer, Integer>();
	// 	p1_testpieces.put(0, 0);
	// 	p1_testpieces.put(1, 0);
	// 	l.setP1Pieces(p1_testpieces);

	// 	HashMap<Integer, Integer> p2_testpieces = new HashMap<Integer, Integer>();
	// 	p2_testpieces.put(0, 0);
	// 	p2_testpieces.put(1, 0);
	// 	l.setP2Pieces(p2_testpieces);

	// 	System.out.println("false? " + l.movesRemain());
		
	// 	p1_testpieces.put(1, 3);
	// 	System.out.println("true? " + l.movesRemain());

	// 	p2_testpieces.put(1, 1);
	// 	System.out.println("true? " + l.movesRemain());

	// 	// testing LevelGenerator.
	// 	LevelGenerator lg = new LevelGenerator();
	// 	Level generatedLevel = lg.generate(1);

	// 	System.out.println("true? " + generatedLevel.movesRemain());
	// 	System.out.println("4? " + generatedLevel.getBoard().getLen());

	// 	generatedLevel = lg.generate(2);
	// 	System.out.println("true? " + generatedLevel.movesRemain());
	// 	System.out.println("6? " + generatedLevel.getBoard().getLen());

	// 	generatedLevel = lg.generate(0);
	// 	System.out.println("false? " + generatedLevel.movesRemain());
	// 	System.out.println("10? " + generatedLevel.getBoard().getLen());
	// }
}