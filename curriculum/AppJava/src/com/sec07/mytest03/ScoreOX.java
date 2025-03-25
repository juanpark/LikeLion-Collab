package com.sec07.mytest03;

public class ScoreOX {
	private int no; //번호
	private int cnt; //맞는 개수
	private int score; //점수
	private int rank; //순위 

	private char[] c_ox; // o,x 저장변수
	private String name;//이름
	private int[] dap; // 입력한 답

	public static int tot; //전체 맞는 정답 수

	public ScoreOX(int no, String name, int[] js) {
		this.no = no;
		this.rank = 1;
		this.name = name;
		dap = js;
		c_ox = new char[5];
	}

	public void compute() {
		final int sol[] = { 1, 1, 1, 1, 1 };
		for (int i = 0; i < 5; i++) {
			if (dap[i] == sol[i]) {
				c_ox[i] = 'o';
				++cnt;
				++tot;
			} else
				c_ox[i] = 'x';
		}
		score = cnt * 20;
	}

	public void display() {
		System.out.printf("%3d %5s", no, name);
		for (int i = 0; i < 5; i++) {
			System.out.printf("%5c", c_ox[i]);
		}
		System.out.printf("%7d %5d\n", score, rank);
	}

	public static void Ranking(ScoreOX[] pm) {
		int i, j;
		for (i = 0; i < pm.length; i++) {
			for (j = 0; j < pm.length; j++) {
				if (pm[i].score < pm[j].score) {
					pm[i].rank++;
				}//if end
			}//inner for end
		}//outter for end
	}//Ranking end
}//ScoreOX end
