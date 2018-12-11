package sudoku;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sudoku {
	public static void answer_input(int [][]answer,int [][]board,int heart,int hole) {
		int row, cal,ans;
		while(true) { //���� �Է��ϱ�(����ó��)
			try {
				System.out.println("���� �Է����ּ���");
				System.out.println("���� ���°?: ");
				Scanner input = new Scanner(System.in);
				row = input.nextInt();
				System.out.println("���� ���°?: ");
				cal = input.nextInt();
				System.out.println("����?: ");
				ans = input.nextInt();
				if(1<=row && row<=9 && 1<=cal && cal<=9 && 1<=ans && ans<=9) break;
				System.out.println("1 ���� 9������ ���ڸ� �Է����ּ���:");
			}
			catch(InputMismatchException e) {
				Scanner input = new Scanner(System.in);
				System.out.println("���ڸ� �Է����ּ��� ");
			}
		}

		if(check(row,cal,ans,answer)==true) {//�����ϋ�
			System.out.println("����!");
			rerode(row,cal,ans,board);
			hole --;
			System.out.println("���� ��ĭ :"+ hole);
			if(hole != 0 ) answer_input(answer,board,heart,hole);
			else if(hole == 0 ) {
				System.out.println("���� Ŭ����!");
			}
		}
		else if (check(row,cal,ans,answer)==false){// �����϶�
			System.out.println("Ʋ���Ƚ��ϴ� ��~��");
			heart--;
			System.out.println("���� ��� :" + heart);
			if(heart != 0) {
				answer_input(answer,board,heart,hole);
			}
		}
		
	}
	public static void rerode(int row, int cal ,int ans,int [][]board){// �������� �����Ͽ� �����ش�.
		board[cal-1][row-1] = ans; 
		print(board);
	}
	public static boolean check(int row, int cal,int ans, int[][] answer) {// �������� �ƴ��� Ȯ��
		if(answer[cal-1][row-1]==ans) {
			return true;
		}
		else {
			print(answer);
			System.out.println(answer[cal-1][row-1]);
			return false;
		}
		
	}
	public static int level_input(){// ���̵� �ޱ�
		int level = 0;
		System.out.println("���̵� �Է����ּ��� 1(easy), 2(hard) :");
		while(true) {
			try { 
				Scanner input = new Scanner(System.in);
				level = input.nextInt();
				if(level == 1|| level == 2) break;
				System.out.println("1 Ȥ�� 2�߿� �Է����ּ���:");
			}
			catch(InputMismatchException e) {
				Scanner input = new Scanner(System.in);
				System.out.println("���ڸ� �Է����ּ��� ");
			}
		}
		return level;
	}
	public static int[][] make_board(){// ���� �� �����

		int n1,n2,n3,n4,n5,n6,n7,n8,n9;
		int [] root = new int [9];
		for(int i = 0; i<9;i++) {
			root[i] = i;
		}
		int ran_num ;
		int tmp;
		for(int j = 0; j <9;j++) {
			ran_num = (int)(Math.random()*9);
			if (ran_num!=j) {
				tmp = root[j];
				root[j] = root[ran_num];
				root[ran_num] = tmp;
			}
		}
		for (int i = 0;i<9;i++) {
			if (root[i] == 0) {
				root[i]=9;
			}
		}
		n1 = root[0];
		n2 = root[1];
		n3 = root[2];
		n4 = root[3];
		n5 = root[4];
		n6 = root[5];
		n7 = root[6];
		n8 = root[7];
		n9 = root[8];
		int [][] board= {{n1,n2,n3,n4,n5,n6,n7,n8,n9},
					     {n4,n5,n6,n7,n8,n9,n1,n2,n3},
						 {n7,n8,n9,n1,n2,n3,n4,n5,n6},
						 {n3,n1,n2,n5,n6,n4,n8,n9,n7},
					     {n6,n4,n5,n8,n9,n7,n2,n3,n1},
						 {n9,n7,n8,n2,n3,n1,n5,n6,n4},
						 {n2,n3,n1,n6,n4,n5,n9,n7,n8},
					     {n5,n6,n4,n9,n7,n8,n3,n1,n2},
						 {n8,n9,n7,n3,n1,n2,n6,n4,n5}};
		return board;
	}
	public static int [][] suffle(int [][]suffle_board){// 3ĭ�� ���� ����
				for(int x=0;x<30;x++){
			     int i = (int)(Math.random()*9);
			     if( 0<=i &&  i<=2 ) {
				      int j = (int)(Math.random()*3);
				      int tmp[] = suffle_board[i];
				      suffle_board[i] = suffle_board[j];
				      suffle_board[j] = tmp;
			     }
			     else if(3<=i &&  i<=5) {
			    	 int j = (int)(Math.random()*3+3);
			      	 int tmp[] = suffle_board[i];
			      	suffle_board[i] = suffle_board[j];
			      	suffle_board[j] = tmp;
			     }
			     else if(6<=i &&  i<=8) {
			    	 int j = (int)(Math.random()*3+6);
			      	 int tmp[] = suffle_board[i];
			      	suffle_board[i] = suffle_board[j];
			      	suffle_board[j] = tmp;
			     }
			   }
			    return suffle_board;
	}
	public static void print(int [][] printing){//������ �����ֱ�
	for (int k = 0; k < 9; k++) {//�� �࿡ ���� �ݺ���
		for (int j = 0; j < 9; j++) {//�� ���� ���� �ݺ���
        System.out.print(printing[k][j]+ " ");//�ݺ����� �����ϸ� �迭�� �ִ� ������ ��� ����Ѵ�
		}
	System.out.println();
	}
}
	public static int [][] change(int [][] board){//���� ���� �ٲٱ�
		int [][] board2 = new int[9][9] ;
		for(int i=0; i<board.length;i++) {
			for(int j =0;j<board[i].length; j++) {
				board2[j][i] = board[i][j];
			}
		}
		return board2;
	}
	public static int [][] hole_make(int [][] board,int level ,int hole){// �� ���۶ձ�
		while (hole != 0) {
			int i = (int)(Math.random()*9);
			int j = (int)(Math.random()*9);
			if(board[i][j] !=0) {
				board[i][j] = 0;
				hole--;
			}
		}
		return board;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int hole = 0;
		int heart = 4;//��� 4��
		int [][] first_board = make_board();
		int[][] suffle1_board = suffle(first_board);
		int level = level_input();
		if(level == 1) {
			hole = 2;
		}
		else if(level == 2) {
		    hole =50;
		}
		int [][] changed_board = change(suffle1_board);
		int  [][] suffle2_board= suffle(changed_board);
		int [][] answer = new int[9][9];
		for (int i=0; i<suffle2_board.length; i++) {
			for(int j=0; j<suffle2_board.length;j++) {
				answer[i][j] = suffle2_board[i][j];
			}
		}

		int [][] board = hole_make(suffle2_board,level,hole);
		System.out.println("�� ������");

		System.out.println("-------------------");
		print(board);
		System.out.println("-------------------");
		answer_input(answer,board,heart,hole);
		long end = System.currentTimeMillis();
		long time = (long) (( end - start )/1000.0);
		System.out.println( "�÷��� �ð� : " + time +"ms");

	}
}
	

