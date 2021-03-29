
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (fifthComparision(
                Comparision.equalsNumbers(P1point,P2point),
                Comparision.lessNumber(P1point,4))){
            score=messages("Love","Fifteen","Thirty","",P1point)+"-All";
        }

        if (fifthComparision(
                Comparision.equalsNumbers(P1point,P2point),
                Comparision.equalOrGreater(P1point, 3))){
            score = "Deuce";
        }

        if (fifthComparision(
                Comparision.greaterNumber(P1point,0),
                Comparision.equalsNumbers(P2point,0))){
            P1res=messages("","Fifteen","Thirty","Forty",P1point);
            P2res = "Love";
            score = concatenation(P1res,P2res);
        }

        if (fifthComparision(
                Comparision.greaterNumber(P2point,0),
                Comparision.equalsNumbers(P1point,0))){
            P2res= messages("","Fifteen","Thirty","Forty",P2point);
            P1res = "Love";
            score = concatenation(P1res,P2res);
        }

        if (fifthComparision(
                Comparision.greaterNumber(P1point,P2point),
                Comparision.lessNumber(P1point,4))){
            P1res= condition1(P1point,P1res);
            P2res= condition2(P2point,P2res);
            score= concatenation(P1res,P2res);
        }

        if (fifthComparision(
                Comparision.greaterNumber(P2point,P1point),
                Comparision.lessNumber(P2point,4))){
            P2res= condition1(P2point,P2res);
            P1res= condition2(P1point,P1res);
            score= concatenation(P1res,P2res);
        }

        score= condition3(score,
                    "Advantage player1",
                    fifthComparision(
                            Comparision.greaterNumber(P1point,P2point) ,
                            Comparision.equalOrGreater(P2point,3)));
        score= condition3(score,
                    "Advantage player2",
                    fifthComparision(
                            Comparision.greaterNumber(P2point,P1point) ,
                            Comparision.equalOrGreater(P1point,3)));
        score= condition3(score,
                    "Win for player1",
                    fifthComparision(
                            fifthComparision(Comparision.equalOrGreater(P1point,4),
                                            Comparision.equalOrGreater(P2point,0)),
                            Comparision.equalOrGreater((P1point-P2point),2)));
        score= condition3(score,
                    "Win for player2",
                    fifthComparision(
                            fifthComparision(Comparision.equalOrGreater(P2point,4),
                                            Comparision.equalOrGreater(P1point,0)),
                            Comparision.equalOrGreater((P2point-P1point),2)));
        return score;
    }
    
    public void SetP1Score(int number){
        for (int i = 0; i < number; i++){
            P1Score();
        }
    }
    
    public void SetP2Score(int number){
        for (int i = 0; i < number; i++){
            P2Score();
        }
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1")){
            P1Score();
        }else {
            P2Score();
        }
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

    public String concatenation(String p1res, String p2res){
        return p1res + "-" + p2res;
    }

    public String condition1(int num, String pres){
        return (num>=2) ? messages("","","Thirty","Forty",num) : pres;
    }

    public String condition2(int num, String pres){
        return ((num>0) && (num<3)) ? messages("","Fifteen","Thirty","",num) : pres;
    }

    public String condition3(String score, String message, boolean condition){
        return (condition) ? score=message : score;
    }

    public boolean fifthComparision(boolean flag1, boolean flag2){
        return (flag1 && flag2) ? true : false;
    }
}