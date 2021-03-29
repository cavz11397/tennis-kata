
public class TennisGame3 implements TennisGame {
    
    private int pointsPlayer2;
    private int pointsPlayer1;
    private String nameFirstPlayer;
    private String nameSecondPlayer;

    public TennisGame3(String p1N, String p2N) {
        this.nameFirstPlayer = p1N;
        this.nameSecondPlayer = p2N;
    }

    public String getScore() {
        String status="";
        if (condition1(pointsPlayer1,pointsPlayer2,4,6)){
            String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            status = points[pointsPlayer1];
            return condition2(
                        (Comparision.equalsNumbers(pointsPlayer1,pointsPlayer2)),
                        status + "-All",
                        status + "-" + points[pointsPlayer2]) ;
        } else {
            return (Comparision.equalsNumbers(pointsPlayer1,pointsPlayer2))
                    ? "Deuce" : condition3(status);
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1")){
            this.pointsPlayer1 += 1;
        }else{
            this.pointsPlayer2 += 1;
        }
    }

    public boolean condition1(int num1, int num2, int num3, int num4){
        return (Comparision.lessNumber(num1,num3)
                && Comparision.lessNumber(num2,num3)
                && !Comparision.equalsNumbers((num1 + num2), num4))
                    ? true : false;
    }

    public String condition2(boolean flag, String message1, String message2){
        return (flag) ? message1 : message2;
    }

    public String condition3(String status){
        status = condition2(
                    Comparision.lessNumber(pointsPlayer2,pointsPlayer1),
                    nameFirstPlayer,nameSecondPlayer);
        return condition2(
                    Comparision.equalsNumbers(
                            Comparision.subtraction(pointsPlayer1,pointsPlayer2)*
                            Comparision.subtraction(pointsPlayer1,pointsPlayer2),1),
                    "Advantage " + status,
                    "Win for " + status);
    }

}
