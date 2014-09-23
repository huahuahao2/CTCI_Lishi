package Q6;

public class Q6 {
	public static void main(String[] args) {//O(n2)
		Rotate90 r = new Rotate90();
		r.generateMatrix(7);
		for (int i = 0; i < r.getMatrix().length; i++) {
			for (int j = 0; j < r.getMatrix().length; j++) {
				System.out.print(r.getMatrix()[i][j] + " ");
			}
			System.out.println();
		}
		r.rotateMatrix();
		for (int i = 0; i < r.getMatrix().length; i++) {
			for (int j = 0; j < r.getMatrix().length; j++) {
				System.out.print(r.getMatrix()[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Rotate90 {
	private int[][] m = null;
	public Rotate90() {
	}
	public Rotate90(int[][] matrix) {
		this.m = matrix;
	}
	public int[][] getMatrix() {
		return this.m;
	}
	public void setMatrix(int[][] matrix) {
		this.m = matrix;
	}
	public void rotateMatrix() {
		for (int i = 0; i < m.length/2; i++) {
			for (int j = i; j < m.length-i-1; j++) {
				int middle = m[i][j];
				m[i][j] = m[m.length-j-1][i];
				m[m.length-j-1][i] = m[m.length-i-1][m.length-j-1];
				m[m.length-i-1][m.length-j-1] = m[j][m.length-i-1];
				m[j][m.length-i-1] = middle;
			}
		}
	}
	public void generateMatrix(int size) {
		int[][] m = new int[size][size];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = j;
			}
		}
		this.m = m;
	}
}