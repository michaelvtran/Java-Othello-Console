package othello;

public class Board {
	Cell[][] cells;
	int ROWS, COLS, numBlack, numWhite;
	
	public Board(int row, int col) {
		this.ROWS = row;
		this.COLS = col;
		cells = new Cell[ROWS][COLS];
		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c < COLS; c++)
				cells[r][c] = new Cell(row, col);
	}
	
	public void draw() {
		System.out.print("    ");
		for (int c = 0; c < COLS; c++)
			System.out.print(c+1 + (c > 8 ? " " : "  ")); 
		System.out.println();
		
		for (int r = 0; r < ROWS; r++) {
			System.out.print(r+1 + (r > 8 ? " " : "  "));
			for (int c = 0; c < COLS; c++)
				cells[r][c].draw();
			System.out.println();
		}
		
		numBlack = countBlacks();
		numWhite = countWhites();
		System.out.format("%nBlack: %d%nWhite: %d%n%n", numBlack, numWhite);
	}
	
	public int countBlacks() {
		int count = 0;
		for (int r = 0; r < ROWS; r++) 
			for (int c = 0; c < COLS; c++)
				if (cells[r][c].value == Value.BLACK)
					count++;
		return count;
	}
	
	public int countWhites() {
		int count = 0;
		for (int r = 0; r < ROWS; r++) 
			for (int c = 0; c < COLS; c++)
				if (cells[r][c].value == Value.WHITE)
					count++;
		return count;
	}
}
