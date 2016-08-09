import java.util.Random;

class Board {
	int len; // board dimension is len x len
	int t; // timestep
	Tile[][] tiles;

	// Constructors 
	public Board() {
		len = 10;
		t = 0;
		tiles = new Tile[len][len];

		// note to self--don't do this, it doesn't actually work: 
		// for (Tile[] tileCol : tiles) {
		// 	for (Tile tile : tileCol) {
		// 		tile = new Tile();
		// 	}
		// }

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				tiles[i][j] = new Tile();
				tiles[i][j].x = i;
				tiles[i][j].y = j;
			}
		}
	}

	// Getters 
	public int getLen() {
		return len;
	}

	public int getT() {
		return t;
	}

	// Setters 
	public void setLen(int l) {
		// NOTE:  CLEARS TILES.
		len = l;
		tiles = new Tile[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				tiles[i][j] = new Tile();
				tiles[i][j].x = i;
				tiles[i][j].y = j;
			}
		}
	}

	// Utilities
	public boolean performMove(Player p, Species s, int x, int y) {
		Tile wantedTile = tiles[x][y];

		if (wantedTile.isOccupied()) {
			return false;
		}

		wantedTile.setPid(p.id);
		wantedTile.setSpecies(s);

		return true;
	}

	public void advanceTime() {
		// track visited tiles; each tile is visited exactly once.
		// if a tile is grown from or into, that tile is considered visited.
		// if a tile's species dies, that tile is considered visited.
		boolean[][] visited = new boolean[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// no revisiting allowed!
				if (visited[i][j]) {
					break;
				}

				// let's see if a tile grows or dies.
				Tile currTile = tiles[i][j];
				int sid = currTile.getSpecies().getId();
				
				Tile growthTile = null;
				Tile deathTile = null;

				int growthX = -1;
				int growthY = -1;
				int rnd = -1;

				// depending on the species (0 or 1), different growth/death rules apply.
				switch (sid) {
					case 0:
						// try to grow one tile in random direction...
						rnd = randInt(4);

						switch (rnd) {
							case 0: // north
								growthX = currTile.getX()-1;
								growthY = currTile.getY();
								break;
							case 1: // east
								growthX = currTile.getX();
								growthY = currTile.getY()+1;
								break;
							case 2: // south
								growthX = currTile.getX()+1;
								growthY = currTile.getY();
								break;
							case 3: // west
								growthX = currTile.getX();
								growthY = currTile.getY()-1;
								break;
							default:
								break;
						}

						// ...but die if blocked in direction of attempted growth.
						if (availableCoord(growthX, growthY)) {
							growthTile = tiles[growthX][growthY];
						} else {
							deathTile = currTile;
						}
						break;
					case 1:
						// die if surrounded on 3+ sides...
						if (numSurrounding(currTile) >= 3) {
							deathTile = currTile;
							break;
						}

						// ...or try to grow one tile north if unblocked; else randomly east/west.
						growthX = currTile.getX()-1;
						growthY = currTile.getY();

						if (availableCoord(growthX, growthY)) {
							growthTile = tiles[growthX][growthY];
						} else {
							rnd = randInt(2);
							
							switch (rnd) {
								case 0: // east
									growthX = currTile.getX();
									growthY = currTile.getY()+1;
									break;
								case 1: // west
									growthX = currTile.getX();
									growthY = currTile.getY()-1;
									break;
								default:
									break;
							}

							// only grow east/west if unblocked, of course. 
							// else, do nothing.
							if (availableCoord(growthX, growthY)) {
								growthTile = tiles[growthX][growthY];
							}
						}
						break;
					default: 
						break;
				}

				// growth/death tile identified.  now mark and execute!
				visited[currTile.getX()][currTile.getY()] = true;

				if (deathTile != null) {
					currTile.setPid(-1);
					currTile.setSpecies(new Species());
				} else if (growthTile != null) {
					growthTile.setPid(currTile.getPid());
					growthTile.setSpecies(currTile.getSpecies());
					visited[growthTile.getX()][growthTile.getY()] = true;
				}
			}
		}
	}

	private int randInt(int bound) {
		Random rng = new Random();
		return rng.nextInt(4);
	}

	// checks if coordinates are on board
	private boolean validCoord(int x, int y) {
		return !(x < 0 || y < 0 || x >= len || y >= len);
	}

	// checks if coordinates are of an available tile
	private boolean availableCoord(int x, int y) {
		return validCoord(x, y) && !tiles[x][y].isOccupied();
	}

	// returns the number of tiles surrounding this tile
	private int numSurrounding(Tile t) {
		int count = 0;

		if (!availableCoord(t.getX()+1, t.getY())) {
			count++;
		}
		if (!availableCoord(t.getX()-1, t.getY())) {
			count++;
		}
		if (!availableCoord(t.getX(), t.getY()+1)) {
			count++;
		}
		if (!availableCoord(t.getX(), t.getY()-1)) {
			count++;
		}

		return count;
	}

	public void printBoard() {
		System.out.println();
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				Tile t = tiles[i][j];
				int pid = t.getPid();
				String sName = t.getSpecies().getName();

				switch(pid) {
					case 1: // player 1 --> uppercase
						System.out.print(sName.substring(0, 1).toUpperCase() + " ");
						break;
					case 2: // player 2 --> lowercase
						System.out.print(sName.substring(0, 1).toLowerCase() + " ");
						break;
					default:
						System.out.print(". ");
						break;
				}
			}
			System.out.println();
		}
	}

	// 1-2-3!  testing, testing! putting it all together...!
	public static void main(String[] args) {
		Board b = new Board();
		Player p1 = new Player(1, "Player1"); // uppercase
		Player p2 = new Player(2, "Player2"); // lowercase
		Species sR = new Species(0); // species r/R
		Species sB = new Species(1); // species b/B

		b.performMove(p1, sR, 3, 3);
		b.performMove(p2, sB, 6, 3);
		b.printBoard();

		// print after 100 iterations.
		for (int i = 0; i < 100; i++) {
			b.advanceTime();
		}
			b.printBoard();
		
		// print every iteration, for 10 iterations.
		// for (int i = 0; i < 10; i++) {
		// 	b.advanceTime();
		// 	b.printBoard();
		// }
	}
}