abstract class Instrument{
    // - private String name
    private String name;
    // - protected int year (year of manufacture)
    protected int year;
    // - constructor that initializes both fields
   public Instrument(String name, int year){
       this.name=name;
       this.year=year;
   }
   public String getName(){
       return name;
   }
    // - abstract method play() that returns a String
   public abstract String play();
    // - concrete method getInstrumentDetails() that returns information about the instrument
   public String getInstrumentDetails(){
       return"Name of the instrument: "+this.name+
     ",Year of manufacture: "+this.year;
   }

}