//$Id$
package by.tarif.oops;

import java.util.Scanner;

public class Othelo {
	private int board[][];
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public Othelo() {
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean move(int symbol, int x, int y){
		if(isInBoard(x,y) == false || !isEmpty(x, y)){
			return false;
		}
		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dy = {-1,  0,  1, 1, 1, 0, -1, -1};
		boolean res = false;
		for(int i =0;i<8;i++){
			if(moveTo(x, dx[i], y, dy[i], symbol)) {
				res = true;
			}
		}
		if(res == true) {
			board[x][y] = symbol;
		}
		return res;
	}

	public boolean isInBoard(int x, int y){
		if(x<0 || x>=8 || y<0 || y>=8){
			 return false;
		 }
		 return true;
	}
	public boolean isEmpty(int x, int y){
		if(board[x][y] ==0){
			 return true;
		 }
		 return false;
	}
	
	public boolean moveTo(int x, int dx, int y, int dy, int symbol){
		if(isInBoard(x,y) == false || !isEmpty(x, y)){
			return false;
		}
		int tempX = x+dx;
		int tempY = y+dy;
		boolean profitable = false;
		while(isInBoard(tempX, tempY) && board[tempX][tempY] != 0 && board[tempX][tempY] != symbol) {
			tempX = tempX + dx;
			tempY = tempY + dy;
			if(isInBoard(tempX, tempY) && board[tempX][tempY] == symbol) {
				profitable = true;
				break;
			}
			
		}
		if(profitable) {
			x = x+dx;
			y= y+dy;
			while(board[x][y] != symbol) {
				board[x][y] = symbol;
				x = x+dx;
				y= y+dy;
			}
			 
		}
		 return profitable;
	}

	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Othelo game = new Othelo();
		int n = s.nextInt();
		for(int i=1;i<=n;i++) {
			boolean res = false;
			int symbol = i%2==1?1:2;
			while(!res) {
				int x = s.nextInt();
				int y = s.nextInt();
				res = game.move(symbol, x, y);
			}
			System.out.println("Player "+symbol+" started");
			game.print();
		}
		s.close();
	}

}
