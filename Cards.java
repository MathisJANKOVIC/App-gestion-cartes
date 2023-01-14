import java.util.ArrayList;

public class Cards
{
    private Spell giantSnowball ;
    private Spell royalDelivery ;
    private Spell zap ;
    private ArrayList<Card> cardList ;

    protected Cards(Player player) // Definition of all cards 
    {   
        cardList = new ArrayList<>() ;

        this.giantSnowball = this.zap = new Spell(player, "Zap", "Common", 0, 75, 23, 2.5, 0, null, 0, 0, "Stun", 0.5, 0, null, 0, 0);
        cardList.add(giantSnowball);

        this.royalDelivery = new Spell(player, "Giant Snowball", "Common", 0, 76, 23, 2.5, 0, null, 0, 0, "slowdown", 2.5, 0, null, 0, 0);
        cardList.add(royalDelivery);

        this.zap = new Spell(player, "Zap", "Common", 0, 75, 23, 2.5, 0, null, 0, 0, "Stun", 0.5, 0, null, 0, 0);
        cardList.add(zap);
    }
}
