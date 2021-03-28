
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
            return condition4((condition3(pointsPlayer1,pointsPlayer2)),
                        status + "-All",
                        status + "-" + points[pointsPlayer2]) ;
        } else {
            return (condition3(pointsPlayer1,pointsPlayer2))
                    ? "Deuce" : condition5(status);
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1"){
            this.pointsPlayer1 += 1;
        }else{
            this.pointsPlayer2 += 1;
        }
    }

    public boolean condition1(int num1, int num2, int num3, int num4){
        return (condition2(num1,num3) && condition2(num2,num3) && !condition3((num1 + num2), num4)) ? true : false;
    }

    public boolean condition2(int num1, int num2){
        return ((num1 < num2)) ? true : false;
    }

    public boolean condition3(int num1, int num2){
        return (num1==num2) ? true : false;
    }

    public String condition4(boolean flag, String message1, String message2){
        return (flag) ? message1 : message2;
    }

    public String condition5(String status){
        status = condition4(condition2(pointsPlayer2,pointsPlayer1),
                    nameFirstPlayer,nameSecondPlayer);
        return condition4(condition3(
                        condition6(pointsPlayer1,pointsPlayer2)*
                        condition6(pointsPlayer1,pointsPlayer2),1),
                    "Advantage " + status,
                    "Win for " + status);
    }

    public int condition6(int num1, int num2){
        return (num1-num2);
    }

}
