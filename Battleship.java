import java.util.Scanner;
/**
 * A game of Battleship qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
 *
 * @author Loc Tran, Brendan Williams
 * @version 11/17/17
 */
public class Battleship
{
    private char [][] arr = new char[6][6];
    private int x, y, choice, size;
    Scanner kb = new Scanner(System.in);
    public Battleship(char thing)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                arr[i][j] = thing;
            }
        }
    }
    
    public void place(int s)
    {
        switch (s)
        {
            case 2:
                size = s;
                System.out.println("Would you like the Patrol Boat(2) to be 1-horizontal or 2-vertical?");
                break;
            case 3:
                size = s;
                System.out.println("Would you like the Submarine(3) to be 1-horizontal or 2-vertical??");
                break;
            case 4:
                size = s;
                System.out.println("Would you like the Battleship(4) to be 1-horizontal or 2-vertical??");
                break;
            default:
                System.out.println("YER BOAT IS TOO SMALL/BIG, BIG IDIOT!");
            break;
        }
        size = this.size;
        choice = kb.nextInt();
        
        while (choice > 2 || choice < 1)
        {
            System.out.println("did I say you could do that... punk");
            choice = kb.nextInt();
        }

        System.out.println("Where should it start?");
        coords();
        
        
        if (choice == 1)
        {
            for (int i = x; i < x + size - 1; i++)
            {
                if (arr[y][i] == 'x')
                {
                    System.out.println("UH SIR, THERES ALREADY A SHIPO THERE BUD");
                    coords();
                }                    
            }
        }
        if (choice == 2) 
        {
            for (int i = y; i < y + size - 1; i++)
            {
                if (arr[i][x] == 'x')
                {
                    System.out.println("UH SIR, THERES ALREADY A SHIPO THERE BUD");
                    coords();
                }                    
            }
        }
        
        switch (choice)
        {
            case 1:
                for (int i = x; i < x + size; i++)
                {
                    arr[y][i] = 'x';
                }
                break;
            case 2:
                for (int i = y; i < y + size; i++)
                {
                    arr[i][x] = 'x';
                }
                break;
            default:
                System.out.println("UH OH THAT'S NOT A CHOICE BUCKAROO");
                break;
        }
    }
    
    public void x()
    {
        System.out.println("x=?");
        x = kb.nextInt();
    }
    
    public void y()
    {
        System.out.println("y=?");
        y = kb.nextInt();
    }
    
    public void checkBoundsX()
    {
        while (x > 5)
        {
            System.out.println("UH OH THAT'S OUTTA THE OCEAN MY MAN");
            x();
        }
        if(choice == 1)
        {
            while (x > (6 - size))
            {
                System.out.println("UH OH, THERE'S GONNA BE A PROBLEM WITH YOUR ALIGNMENT PAL");
                x();
            }
        }
    }
    
    public void checkBoundsY()
    {
        while (y > 5)
        {
            System.out.println("UH OH THAT'S OUTTA THE OCEAN MY MAN");
            y();
        }
        if(choice == 2)
        {
            while (y > (6 - size))
            {
                System.out.println("UH OH, THERE'S GONNA BE A PROBLEM WITH YOUR ALIGNMENT PAL");
                y();
            }
        }
    }
    
    public void coords()
    {
        x();
        checkBoundsX();
        y();
        checkBoundsY();
    }
    
    public void shoot(Battleship Battleship, int p)
    {
        System.out.println("Player" + p + ", where would you like to shoot?");
        coords();
        while (this.arr[y][x] != '~')
        {
            System.out.println("Wait a second pal, you already kablamo'd there dawg");
            coords();
        }
        if (x <= 5 && x >= 0 && y <= 5 && x >= 0)
        {
            if (Battleship.arr[y][x] == 'x')
            {
                Battleship.arr[y][x] = 'o';
                this.arr[y][x] = 'x';
                System.out.println("YOu dONE hIt a ShiP SON!");
            }
            else
            {
                this.arr[y][x] = 'o';
                System.out.println("YoU AInt hIT nO ShiP");
            }
        }
        else
        {
            System.out.println("ThAT's NoT in THe OcEAn paL!");
        }
    }
    
    public boolean win()
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                if (arr[i][j] == 'x')
                    sum += 1;
            }
        }
        if (sum == 0)
            System.out.println("YoU Done SuNK His/hEr/tHeIR/its SHiPPers");
        return sum == 0;
    }


    
    //Ericka's Code
    
    public void nTL(int i)
    {                     
        switch(i) 
        {
             case 0:
                System.out.print("A");
                break;
             case 1:
                System.out.print("B");
                break;
             case 2:
                System.out.print("C");
                 break;
             case 3:
                System.out.print("D");
                 break;
             case 4:
                System.out.print("E");
                break;
             case 5:
                System.out.print("F");
                break;
        }                                                 
    }

    public void lTN(char i)
    {   
        switch(i)
        {
            case 'a':
                i= 'A';
                break;
            case 'b':
                i= 'B';
                break;
            case 'c':
                i= 'C';
                break;
            case 'd':
                i= 'D';
                break;
            case 'e':
                i= 'E';
                break;
            case 'f':
                i= 'F';
                break;
        }  
        switch(i) 
        {
            case 'A':
                System.out.print("0");
                break;
            case 'B':
                System.out.print("1");
                break;
            case 'C':
                System.out.print("2");
                break;
            case 'D':
                System.out.print("3");
                break;
            case 'E':
                System.out.print("4");
                break;
            case 'F':
                System.out.print("5");
                break;
        }  
    }   

    public void display()
    {        
       System.out.print("   0   1   2   3   4   5");  
       System.out.println();  
       for (int i = 0; i < arr.length; i++)
       {   
            nTL(i);
            for (int j = 0; j < arr[i].length; j++)
            {                     
                System.out.print("  ");
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }                      
            System.out.println();                       
       }
       System.out.println();   
       System.out.print("A = 0, B = 1, C = 2, D = 3, E = 4, F = 5"); 
       System.out.println();
    }

}
