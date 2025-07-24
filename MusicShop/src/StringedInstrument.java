class StringedInstrument extends Instrument {
    private int numberOfStrings;
// - constructor that initializes name, year, and numberOfStrings
    public StringedInstrument(String name,int year,int numberOfStrings){
        super(name, year);
        this.numberOfStrings=numberOfStrings;
    }
// - implementation of the abstract play() method

    @Override
    public String play() {
        return "Playing the stringed instrument";
    }
    // - override getInstrumentDetails() to include number of strings
    @Override
    public String getInstrumentDetails() {
      return   super.getInstrumentDetails()+", Strings: "+numberOfStrings;
    }
public int getNumberOfStrings(){
        return numberOfStrings;
}}