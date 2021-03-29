
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")){
            this.scorePlayer1 += 1;
        }else{
            this.scorePlayer2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (Comparision.equalsNumbers(this.scorePlayer1,this.scorePlayer2)){
            score=messages("Love-All","Fifteen-All","Thirty-All","Deuce", scorePlayer1);
        }else if (Comparision.equalOrGreater(this.scorePlayer1,4)
                || Comparision.equalOrGreater(this.scorePlayer2,4)){
            score= winner();
        }else{
            score= inGame(score);
        }
        return score;
    }

    public String winner(){
        int Result = scorePlayer1 - scorePlayer2;
        String score="";
        if(Comparision.equalOrGreater(Math.abs(Result),2)){
            if(Comparision.equalOrGreater(Result,2)){
                score="Win for player1";
            }else{
                score="Win for player2";
            }
        }else{
            if(Comparision.equalsNumbers(Result,1)){
                score="Advantage player1";
            }else{
                score="Advantage player2";
            }
        }
        return score;
    }

    public String inGame(String score){
        for (int i=1; i<3; i++){
            score= points(score,i);
        }
        return score;
    }

    public String points(String score, int i){
        int pointsScore=0;
        if (Comparision.equalsNumbers(i,1)){
            pointsScore = scorePlayer1;
        }
        else {
            score+="-";
            pointsScore = scorePlayer2;
        }
        score+=messages("Love","Fifteen","Thirty","Forty",pointsScore);
        return score;
    }

    public String messages(String text1,String text2,String text3,String text4, int choose){
        String message="";
        switch(choose){
            case 0:
                message=text1;
                break;
            case 1:
                message=text2;
                break;
            case 2:
                message=text3;
                break;
            default:
                message =text4;
                break;
        }
        return message;
    }
}
