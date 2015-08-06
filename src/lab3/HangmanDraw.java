package lab3;


//This class serves to draw the hangman picture 

public class HangmanDraw{

    public static void draw(int n){
        if (n==5){
            System.out.println("");
            System.out.println("           ===============");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("           ===============");
        }
        if (n==4){
            System.out.println("");
            System.out.println("           ===============");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                _        =");
            System.out.println("               (_)       =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("           ===============");
        }  
        if (n==3){
            System.out.println("");
            System.out.println("           ===============");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                _        =");
            System.out.println("               (_)       =");
            System.out.println("                |        =");
            System.out.println("                |        =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("           ===============");
        }     
        if (n==2){
            System.out.println("");
            System.out.println("           ===============");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                _        =");
            System.out.println("               (_)       =");
            System.out.println("               \\|/       =");
            System.out.println("                |        =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("           ===============");
        }   
        if (n==1){
            System.out.println("");
            System.out.println("           ===============");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("                _        =");
            System.out.println("               (_)       =");
            System.out.println("               \\|/       =");
            System.out.println("                |        =");
            System.out.println("               / \\       =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("           ===============");
        }  
        if (n==0){
            System.out.println("");
            System.out.println("           ===============");
            System.out.println("                |        =");
            System.out.println("                |        =");
            System.out.println("                |        =");
            System.out.println("               (_)       =");
            System.out.println("               \\|/       =");
            System.out.println("                |        =");
            System.out.println("               / \\       =");
            System.out.println("                         =");
            System.out.println("                         =");
            System.out.println("           ===============");
        }  
    }

}