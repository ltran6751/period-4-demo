import java.util.Scanner;
/**
 * Write a description of class BattleshipMain here.
 *
 * @author Loc Tran
 * @version 11/17/17
 */
public class BattleshipMain
{
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        
        
        int x, y = 0;
        int p1Counter = 0;
        int p2Counter = 0;
        boolean playAgain = true;
        boolean winner = false;
        int yuh = 0;
        
        do
        {
            Battleship p1 = new Battleship('~');
            Battleship p2 = new Battleship('~');
            Battleship p1Ships = new Battleship('o');
            Battleship p2Ships = new Battleship('o');
            System.out.print('\u000C');
            System.out.println("Player 1, place your ships");
            p1Ships.display();
            p1Ships.place(2);
            delayClear();
            p1Ships.display();
            p1Ships.place(3);
            delayClear();
            p1Ships.display();
            p1Ships.place(4);
            delayClear();
            p1Ships.display();
            delayClear();
            
            System.out.println("Player 2, place your ships");
            p2Ships.display();            
            p2Ships.place(2);      
            delayClear();
            p2Ships.display();
            p2Ships.place(3);
            delayClear();
            p2Ships.display();
            p2Ships.place(4);
            delayClear();
            p2Ships.display();
            delayClear();
            do
            {
                p1.display();
                p1.shoot(p2Ships, 1);
                p1.display();
                winner = p2Ships.win();
                if(winner == true)
                {
                    System.out.println("Player 1 is better than Player 2 at the game");
                    System.out.println("Finna sink some ships again? 1 for yes 2 for no.");
                    yuh = kb.nextInt();
                    switch (yuh)
                    {
                        case 1:
                            winner = true;
                            p1Counter++;
                            break;
                        case 2:
                            winner = true;
                            playAgain = false;
                            System.out.println("Bye have a great time!");
                            break;
                        default:
                            System.out.println("UH OH THAT'S NOT A CHOICE BUCKAROO");
                            break;
                    }
                }
                delayClear();
                p2.display();
                p2.shoot(p1Ships, 2);
                delayClear();
                p2.display();
                winner = p1Ships.win();
                if(winner == true)
                {
                    System.out.println("Player 2 is better than Player 1 at the game");
                    System.out.println("Finna sink some ships again? 1 for yes 2 for no.");
                    yuh = kb.nextInt();
                    switch (yuh)
                    {
                        case 1:
                            winner = true;
                            p2Counter += 1;
                            break;
                        case 2:
                            winner = true;
                            playAgain = false;
                            System.out.println("Bye have a great time!");
                            break;
                        default:
                            System.out.println("UH OH THAT'S NOT A CHOICE BUCKAROO");
                            break;
                    }
                }
            } while(winner == false);
            System.out.println("Player 1: " + p1Counter);
            System.out.println("Player 2: " + p2Counter);
        } while(playAgain == true);
    }
    
    public static void delayClear()
    {
        int i = (int)(Math.random() * 4) + 1;
        switch(i)
        {
            case 1:
                System.out.println("aight, give me a sec");
                break;
            case 2:
                System.out.println("how 'bout them dodgers?");
                break;
            case 3:
                System.out.println("hold on");
                break;
            case 4:
                System.out.println("hold up");
                break;
            default:
                System.out.println("wait this wasn't supposed to display");
                break;
        }
        try        
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.print('\u000C');
    }
}


