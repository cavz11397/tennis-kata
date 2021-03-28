
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")){
            this.m_score1 += 1;
        }else{
            this.m_score2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (this.m_score1 == this.m_score2){
            score=messages("Love-All","Fifteen-All","Thirty-All","Deuce",m_score1);
        }else if (this.m_score1>=4 || this.m_score2>=4){
            score= winner();
        }else{
            score= inGame(score);
        }
        return score;
    }

    public String winner(){
        int Result = m_score1-m_score2;
        if (Result==1){
            return "Advantage player1";
        }
        if(Result ==-1) {
            return "Advantage player2";
        }
        if (Result>=2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    public String inGame(String score){
        for (int i=1; i<3; i++){
            score= points(score,i);
        }
        return score;
    }

    public String points(String score, int i){
        int pointsScore=0;
        if (i==1){
            pointsScore = m_score1;
        }
        else {
            score+="-";
            pointsScore = m_score2;
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
