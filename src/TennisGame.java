public class TennisGame {
    public static final String SCORE_0="Love";
    public static final String SCORE_1="Fifteen";
    public static final String SCORE_2="Thirty";
    public static final String SCORE_3="Forty";
    public static final String SCORE_EQUALS="-All";
    public static final int SCORE_MINIMUM_REQUIRED=4;
    public static final int SCORE_ADVANTAGE=1;
    public static final int SCORE_DIFFERENCE_WIN=2;

    public static String getScore(String player1Name, String player2Name,
                                  int firstPlayerScore, int secondPlayerScore) {
        String scoreDescription = "";
        boolean isScoreEquals=firstPlayerScore==secondPlayerScore;
        boolean isScoreDifferenceMoreThan4=firstPlayerScore>=SCORE_MINIMUM_REQUIRED
                || secondPlayerScore>=SCORE_MINIMUM_REQUIRED;

        if (isScoreEquals)
        {
            scoreDescription=getScoreDescriptionEquals(firstPlayerScore,secondPlayerScore);
        }
        else if (isScoreDifferenceMoreThan4)
        {
            scoreDescription= getScoreDescriptionMoreThan4(firstPlayerScore,secondPlayerScore);
        }
        else
        {
            scoreDescription=getScoreDescriptionLessThan4(firstPlayerScore,secondPlayerScore);
        }
        return scoreDescription;
    }

    public static String getScoreDescriptionEquals(int firstPlayerScore, int secondPlayerScore) {
        String scoreDescription = "";
        switch (firstPlayerScore)
        {
            case 0:
                scoreDescription = SCORE_0.concat(SCORE_EQUALS);
                break;
            case 1:
                scoreDescription = SCORE_1.concat(SCORE_EQUALS);
                break;
            case 2:
                scoreDescription = SCORE_2.concat(SCORE_EQUALS);
                break;
            case 3:
                scoreDescription = SCORE_3.concat(SCORE_EQUALS);
                break;
            default:
                scoreDescription = "Deuce";
                break;
        }
        return scoreDescription;
    }
    public static String getScoreDescriptionMoreThan4(int firstPlayerScore, int secondPlayerScore) {
        String scoreDescription = "";
        int minusScore = firstPlayerScore-secondPlayerScore;
        if (minusScore==SCORE_ADVANTAGE) scoreDescription ="Advantage player1";
        else if (minusScore ==-SCORE_ADVANTAGE) scoreDescription ="Advantage player2";
        else if (minusScore>=SCORE_DIFFERENCE_WIN) scoreDescription = "Win for player1";
        else scoreDescription ="Win for player2";
        return scoreDescription;
    }
    public static String getScoreDescriptionLessThan4(int firstPlayerScore,int secondPlayerScore) {
        String scoreDescription = "";
        int tempScore=0;

        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = firstPlayerScore;
            else { scoreDescription+="-"; tempScore = secondPlayerScore;}
            switch(tempScore)
            {
                case 0:
                    scoreDescription+=SCORE_0;
                    break;
                case 1:
                    scoreDescription+=SCORE_1;
                    break;
                case 2:
                    scoreDescription+=SCORE_2;
                    break;
                case 3:
                    scoreDescription+=SCORE_3;
                    break;
            }
        }
        return scoreDescription;
    }

    public static void main(String[] args) {
        TennisGame tng=new TennisGame();
        System.out.println(tng.getScore("John","David",6,5));
    }
}
