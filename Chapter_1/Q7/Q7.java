package Q7;

public class Q7 {
	public static void main(String[] args) {//O(n2)
		int m = 5, n = 4;
		ZeroMatrix r = new ZeroMatrix(m, n);
		r.generateMatrix();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(r.getMatrix()[i][j] + " ");
			}
			System.out.println();
		}
		r.zero();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(r.getMatrix()[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class ZeroMatrix {
	private int matrix[][] = null;
	public ZeroMatrix(int m, int n) {
		matrix = new int[m][n];
	}
	public int[][] getMatrix() {
		return this.matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public void generateMatrix() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = (int)(Math.random()*5);
			}
		}
	}
	public void zero() {
		boolean row[] = new boolean[matrix.length];
		boolean column[] = new boolean[matrix[0].length];
		for(int i = 0; i < matrix.length; i++) { // if you do the book way it costs you 2*n2 but it's more clear to read
			for(int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (!row[i]) {
						for (int k = 0; k < matrix[0].length; k++)
							matrix[i][k] = 0; 
						row[i] = true;
					}
					if (!column[j]) {
						for (int k = 0; k < matrix.length; k++)
							matrix[k][j] = 0; 
						column[j] = true;
					}
				}
			}
		}
	}
}