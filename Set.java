package badders;

public class Set {
	private int gameNumber = 0;
	private int leftsideScore = 0;
	private int rightsideScore = 0;
	private int SetPoint = 0;
	private int SuddenDeathPoint = 0;

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public int getSuddenDeathPoint() {
		return SuddenDeathPoint;
	}

	public void setSuddenDeathPoint(int suddenDeathPoint) {
		SuddenDeathPoint = suddenDeathPoint;
	}

	public void addPoint(side whoScored) {// this method updates the current
		// player score
		// when a point is scored
		if (whoScored == side.LEFTHAND)
			leftsideScore++;
		else if (whoScored == side.RIGHTHAND)
			rightsideScore++;
	}

	public int getSetPoint() {
		return SetPoint;
	}

	public void setSetPoint(int setPoint) {
		SetPoint = setPoint;
	}

	public void setScore(side whoScored, int score) {// this method updates the
		// current
		// player score
		// when a point is scored
		if (whoScored == side.LEFTHAND)
			leftsideScore = score;
		else if (whoScored == side.RIGHTHAND)
			rightsideScore = score;
	}

	public void whatPoint() {

		System.out.println("Set Point is " + SetPoint);

	}

	public void gameStatus() { // this method calls the status of play on a game

		String side = new String();

		int ls = this.leftsideScore;
		int rs = this.rightsideScore;
		int sp = this.SetPoint;
		int sd = this.SuddenDeathPoint;
		int hv = 0; // higher value
		int lv = 0; // lower value

		boolean draw = false;
		int df = 0;

		// HIGHEST, LOWEST , DRAWING
		if (ls > rs) {
			hv = ls;
			lv = rs;
			side = "left";
		} else if (rs > ls) {
			hv = rs;
			lv = ls;
			side = "right";
		} else  {
			draw = true;
		}

		df = hv - lv;

		if (hv == sp - 1 && lv <= sp - 2) {
			System.out.println("setpoint");
		}

		if (hv > lv && hv < sp) {
			System.out.println("The current score is " + hv + " - " + lv + ", "
					+ side + " side is in the lead.");
		} else if (draw == true) {
			System.out.println("Both sides are drawing at " + ls + " all.");

		} else if (hv == sp && df >= 2) {

			System.out.println(side + " match won by " + hv + " - " + lv);

		} else if (hv > sd) {
			System.out.println("wrong input");
		}
		// /////////////////////////////////////////////////////////////////////////////////////////////
		if (hv > sp && hv < sd) {
			System.out.println("sudden death is now in effect");
		}
		if (hv == sp && df == 1) {
			SetPoint = this.getSuddenDeathPoint();
			System.out.println("sudden death is now in effect");
			System.out.println(SetPoint);

		} else if (hv == sd) {
			System.out.println("won in sudden death");
		}

	}
};
