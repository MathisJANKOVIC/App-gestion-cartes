import java.util.ArrayList;
import java.util.Random;

public class Player 
{
    private String username ;
    private String password ;
    private int level ;
    protected int goldAmount  ;
    private int gemAmount ;
    private Cards cards ; 
    // private static final int maxLevel = 50 ; (to implement)
    

    public Player(String username, String password)
    {
        this.username = username ;
        this.password = password ;
        this.level = 1 ;
        this.goldAmount = 0 ;
        this.gemAmount = 0 ;
        this.cards = new Cards(this) ;    
    }

    public void setUsername(String username) {
        // checking required
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    // to enhance (encode)
    public void setPassword(String password) { 
        this.password = password ;
    }

    // to enhance (encode)
    public String getPassword() {
        return password;
    }

    // to enhance
    public void upgradeLevel() {    
        this.level ++ ;   
    }

    public int getLevel() {
        return level;
    }

    public void addGold(int amountToAdd) {
        this.goldAmount = this.goldAmount + amountToAdd ;
    }

    public void payGold(int amountToPay) 
    {
        if(goldAmount >= amountToPay){
            this.goldAmount = this.goldAmount - amountToPay ;
        } else{
            // to enhance (GUI)
            System.out.println("You don't have enough gold !");      
            return ;     
        }        
    }  

    public int getGoldAmount() {
        return goldAmount;
    }

    public void addGems(int amountToAdd) {
        this.gemAmount = this.gemAmount + amountToAdd ;
    }

    public void payGems(int amountToPay) 
    {
        if(gemAmount >= amountToPay){
            this.gemAmount = this.gemAmount - amountToPay ;
        } else{
            // to enhance (GUI)
            System.out.println("You don't have enough gems !");         
        }        
    } 

    public int getGemAmount() {
        return gemAmount;
    }

    @Override
    public String toString() {
        // to enhance (GUI)
        return username + " | " + level + " | " + goldAmount + " golds | " + gemAmount + " gems\n";
    }

    // to enhance
    public void openSilverChest(ArrayList<Card> listCard)
    {
        Random random = new Random() ;
        int random1, random2 ;

        int goldAmount = 182 + random.nextInt(208-182);
        addGold(goldAmount);
        
        do{
            random1 = random.nextInt(listCard.size());
        }while(listCard.get(random1).rarity != "Common");

        do{
            random2 = random.nextInt(listCard.size());
        }while(listCard.get(random2).rarity != "Common" || random2 == random1);
        
        int numberCard1 = random.nextInt(21);
        int numberCard2 = 21 - numberCard1 ;

        listCard.get(random1).addCards(numberCard1);

        System.out.println("[Silver chest]");
        System.out.println("You got :");
        System.out.println(goldAmount + " golds");

        if(listCard.get(random1).cardNumber == 0 && listCard.get(random1).level == listCard.get(random1).rarity.startsAtLevel)
        {
            System.out.println(listCard.get(random1).name + "unlocked");
        }
        else
        {
            System.out.println(numberCard1 + " " + listCard.get(random1).name);
        }

        listCard.get(random1).addCards(numberCard2);

        if(listCard.get(random2).cardNumber == 0 && listCard.get(random2).level == listCard.get(random2).rarity.startsAtLevel)
        {
            System.out.println(listCard.get(random2).name + "unlocked");
        }
        else
        {
            System.out.println(numberCard2 + " " + listCard.get(random2).name);
        }

        System.out.println();      
    }
}

