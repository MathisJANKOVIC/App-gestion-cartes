import java.lang.Math;
import java.lang.reflect.Field;

public class Spell extends Card 
{
    private final String type = "spell";
    private int damage ;
    private int areaDamage ;
    private int crownTowerDamage ;
    private final double radius ;
    private final double duration ;
    private final String targets ;
    private final double width ;
    private final double range ;
    private final SpellEffect effect ;
    private final SpellTroop troop ;
    private final int count ;

    protected Spell(Player player, String name, String rarity, int damage, int areaDamage, int crownTowerDamage, double radius, double duration, String targets, double width, double range, String effectType, double effectDuration, int effectEfficiency, String troopName, int troopLevelBonus, int count)
    {
        super(player, name, rarity);
        this.damage = damage ;
        this.areaDamage = areaDamage ;
        this.crownTowerDamage = crownTowerDamage ;        
        this.radius = radius ;
        this.duration = duration ;
        this.targets = targets ;
        this.width = width ;
        this.range = range ;
        this.effect = new SpellEffect(effectType, effectDuration, effectEfficiency);
        this.troop = new SpellTroop(troopName, troopLevelBonus);
        this.count = count ;
    }

    public String getType(){
        return type ;
    }
    public int getDamage() {
        return damage;
    }
    public int getAreaDamage() {
        return areaDamage;
    }
    public int getCrownTowerDamage() {
        return crownTowerDamage;
    }
    public double getRadius() {
        return radius;
    }
    public double getDuration() {
        return duration;
    }
    public String getTargets() {
        return targets;
    }
    public double getWidth() {
        return width;
    }
    public double getRange() {
        return range;
    }   
    public String getEffectType(){
        return effect.type;
    }
    public double getEffectDuration(){
        return effect.duration ;
    }
    public int getEffectEfficiency(){
        return effect.efficiency ;
    }
    public int getCount() {
        return count;
    }
    public String getTroopName() {
        return troop.name;
    }
    public int getTroopLevel(){
        return troop.level ;
    }

    public void upgradeCard()
    {
        Class<?> classRarity = null ;

        Object cardCost = null ;
        Field cardCostLvlField = null ;
        Field cardCostField = null ;
        int cardCostLvl = 0 ;

        Object goldCost = null ;
        Field goldCostLvlField = null ;
        Field goldCostField = null ;
        int goldCostLvl = 0 ;

        try{
            // we want to get rarity.rarityCardCost.cardCostLvlN+1
            classRarity = Class.forName(rarity); // get the class which name is the type of rarity

            cardCostField = classRarity.getField(rarity + "CardCost"); // we acces the field of type type.CardCost
            cardCost = cardCostField.get(null) ;
            cardCostLvlField = cardCost.getClass().getField("cardCostLvl" + (this.level+1)) ; // we acces the field type.CardCost.lvln+1
            cardCostLvl = cardCostLvlField.getInt(cardCostLvlField); // get the value of the field

            goldCostField = classRarity.getField(rarity + "GoldCost"); 
            goldCost = goldCostField.get(null) ;
            goldCostLvlField = goldCost.getClass().getField("goldCostLvl" + (this.level+1)) ;
            goldCostLvl = goldCostLvlField.getInt(goldCostLvlField); 

        } catch(ClassNotFoundException e) {
            System.out.println("Error : Class \"" + rarity + "\"not found");
            e.printStackTrace();
            return;
        } catch(NoSuchFieldException e) {
            System.out.println("Error : Class \"" + rarity + "\" has no attribute named + \"" + fieldToReach + "\"");
            e.printStackTrace();
            return;
        } catch(IllegalAccessException e) {
            System.out.println("Error : You don't have the permission to acces the field \"" + fieldToReach + "\"");
            e.printStackTrace();
            return;
        }

        if(cardNumber >= cardCostLvl)
            {
                if(player.goldAmount >= goldCostLvl)
                {                                      
                    this.level++;  
                    if(troop.level != 0) this.troop.level++ ;                                       
                    this.damage = (int) Math.round(damage*multiplyConstCardStats) ;
                    this.areaDamage = (int) Math.round(areaDamage*multiplyConstCardStats) ;
                    this.crownTowerDamage = (int) Math.round(crownTowerDamage*multiplyConstCardStats) ;
                    
                    player.payGold(goldCostLvl);
                    this.cardNumber = cardNumber - cardCostLvl ;

                    System.out.println(this.name + " is now at level " + this.level) ; // to enhance (GUI)
                }
                else
                {   // to enhance (GUI)
                    System.out.println("You don't have enough gold...");
                }
            }
            else
            {   // to enhance (GUI)               
                System.out.println("You don't have enough card to upgrade...");
            }

        System.out.println();
    }

    public void printCardInfo()
    {
        System.out.println("Name : " + this.name);
        System.out.println("Rarity : " + this.rarity);
        System.out.println("Level : " + this.level);
        System.out.print("Progression : " + this.cardNumber + " / ");
        
        if(this.level == 1){
            System.out.println(this.rarity.getCardCostLvl2());
        }
        if(this.level == 2){
            System.out.println(this.rarity.getCardCostLvl3());
        }
        if(this.level == 3){
            System.out.println(this.rarity.getCardCostLvl4());
        }
        if(this.level == 4){
            System.out.println(this.rarity.getCardCostLvl5());
        }
        if(this.level == 5){
            System.out.println(this.rarity.getCardCostLvl6());
        }
        if(this.level == 6){
            System.out.println(this.rarity.getCardCostLvl7());
        }
        if(this.level == 7){
            System.out.println(this.rarity.getCardCostLvl8());
        }
        if(this.level == 8){
            System.out.println(this.rarity.getCardCostLvl9());
        }
        if(this.level == 9){
            System.out.println(this.rarity.getCardCostLvl10());
        }
        if(this.level == 10){
            System.out.println(this.rarity.getCardCostLvl11());
        }
        if(this.level == 11){
            System.out.println(this.rarity.getCardCostLvl12());
        }
        if(this.level == 12){
            System.out.println(this.rarity.getCardCostLvl13());
        }
        if(this.level == 13){
            System.out.println(this.rarity.getCardCostLvl14());
        }

        System.out.println("Type : " + this.type);

        if(this.damage != 0){
            System.out.println("Damage : " + damage);
        }
        if(this.areaDamage != 0){
            System.out.println("Area Damage : " + areaDamage);
        }
        if(this.crownTowerDamage != 0){
            System.out.println("Crown Tower Damage : " + crownTowerDamage);
        }
        if(this.radius != 0){
            System.out.println("Radius : " + radius);
        }
        if(this.duration != 0){
            System.out.println("Duration : " + duration);
        }
        if(this.targets != null){
            System.out.println("Targets : " + targets);
        }
        if(this.width != 0){
            System.out.println("Width : " + width);
        }
        if(this.range != 0){
            System.out.println("Range : " + range);
        }
        if(this.effect.type != null)
        {
            if(this.effect.efficiency == 0)
            {
                System.out.println(effect.type + " duration : " + effect.duration + " sec");
            }
            else
            {
                System.out.println("Bost : " + effect.efficiency + "%");
            }            
        }

        if(this.count != 0){
            System.out.println("count : x" + count);
        }

        if(this.troop.name != null)
        {
            System.out.println(troop.level + " level : " + troop.level);
        }

        System.out.println();
    }
}
