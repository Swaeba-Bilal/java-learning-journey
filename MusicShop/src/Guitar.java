 class Guitar extends StringedInstrument implements Tunable,Maintainable{
// - private String guitarType (acoustic, electric, etc.)
    private String guitarType;
// - constructor that initializes all fields
    Guitar(String name,int year,int numberOfStrings,String guitarType){
        super(name,year,numberOfStrings);
        this.guitarType=guitarType;
    }
// Override the parent's class

    @Override
    public String play() {
        return "Playing the "+this.guitarType+" guitar with "+getNumberOfStrings()+" strings";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails()+",Type: "+this.guitarType;
    }
    // Implement methods from Tunable interface

    @Override
    public String tune() {
        return "Tuning the "+guitarType+" guitar";
    }
    public String adjustPitch(boolean up){
        return up ? "Increasing pitch of the guitar":"Decreasing pitch of the guitar";
    }
    // Implement methods from Maintainable interface
    @Override
    public String clean(){
        return "Cleaning the "+guitarType+" guitar";
    }
    @Override
    public String inspect(){
        return "Inspecting the "+guitarType+" guitar from"+year;
    }}