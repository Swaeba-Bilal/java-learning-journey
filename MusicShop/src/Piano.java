class Piano extends Instrument implements Tunable, Maintainable{
 private boolean isGrand;
// - constructor that initializes all fields
        public Piano(String name,int year, boolean isGrand){
            super(name,year);
            this.isGrand=isGrand;
        }
        public boolean isGrand(){
            return isGrand;
        }
// - implementation of the abstract play() method
        public String play(){
            return "Playing the "+(isGrand ?"grand":"upright")+" piano";
        }

        @Override
        public String getInstrumentDetails() {
            return super.getInstrumentDetails()+",Type "+(isGrand ?"Grand":"Upright");
        }
        @Override
        public String tune(){
            return "Tuning the piano";
        }

        @Override
        public String adjustPitch(boolean up) {
            return (up?"Increasing the pitch of piano":"Decreasing the pitch of piano");
        }
        @Override
        public String clean(){
            return "Cleaning the piano";
        }
        @Override
        public String inspect(){
            return "Inspecting the "+(isGrand?"Grand":"Upright")+" piano from "+year;
        }}
