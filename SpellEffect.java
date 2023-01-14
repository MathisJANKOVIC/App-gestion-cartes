public class SpellEffect 
{
    protected final String type ;
    protected final double duration ;
    protected final int efficiency ; 

    SpellEffect(String type, double duration, int efficiency) 
    {
        this.type = type ;
        this.duration = duration ;
        this.efficiency = efficiency ;
    }
    
}
