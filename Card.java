import java.lang.reflect.Field;

public abstract class Card
{   
    protected Player player ;
    protected final String name ;   
    protected final String rarity ;
    protected int level ; 
    private final int maxLevel = 14 ;
    protected int cardNumber ;
    protected  static final double multiplyConstCardStats = 1.097 ;
    

    abstract void upgradeCard();
    abstract void printCardInfo();

    protected Card(Player player, String name, String rarity)
    {
        this.player = player ;
        this.name = name ;
        this.rarity = rarity ;

        Class<?> classRarity = null ;
        Field field = null ;
        String fieldToReach = "startsAtLvl" ;

        try{
            classRarity = Class.forName(rarity);
            field = classRarity.getField(fieldToReach);
            this.level = field.getInt(null);

        } catch(ClassNotFoundException e) {
            System.out.println("Error : Class \"" + rarity + "\"not found");
            e.printStackTrace();
            return;
        }  catch(NoSuchFieldException e) {
            System.out.println("Error : Class \"" + rarity + "\" has no attribute named + \"" + fieldToReach + "\"");
            e.printStackTrace();
            return;
        } catch(IllegalAccessException e) {
            System.out.println("Error : You don't have the permission to acces the field \"" + fieldToReach + "\"");
            e.printStackTrace();
            return;
        }
    }
    
    public String getName(){
        return name ;
    }
    public String getRarity(){
        return rarity ;
    } 
    public int getLevel(){
        return level ;
    }
    public int getCardNumber(){
        return cardNumber;
    }
    public void addCards(int cardNumberToAdd) {
        this.cardNumber += cardNumberToAdd;
    }
}