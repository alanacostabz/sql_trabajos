public class Player {
    
    public int salary;
    public String born;
    public String city;
    public String prst;
    public String cntry;
    public String nat;
    public short ht;
    public short wt;
    public short dftyr;
    public short dftrd;
    public short ovrl;
    public char hand;
    public String lastName;
    public String firstName;
    public String position;
    public String team;
    public short gp;

    public Player(int salary, String born, String city, String prst, String cntry, String nat, short ht, short wt, short dftyr, short dftrd, short ovrl, char hand, String lastName, String firstName, String position, String team, short gp) {
        this.salary = salary;
        this.born = born;
        this.city = city;
        this.prst = prst;
        this.cntry = cntry;
        this.nat = nat;
        this.ht = ht;
        this.wt = wt;
        this.dftyr = dftyr;
        this.dftrd = dftrd;
        this.ovrl = ovrl;
        this.hand = hand;
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        this.team = team;
        this.gp = gp;
    }

    public Player(){
        super();
    } 
    public int getSalary() {
        return salary;
    }

    public String getBorn() {
        return born;
    }

    public String getCity() {
        return city;
    }

    public String getPrst() {
        return prst;
    }

    public String getCntry() {
        return cntry;
    }

    public String getNat() {
        return nat;
    }

    public short getHt() {
        return ht;
    }

    public short getWt() {
        return wt;
    }

    public short getDftyr() {
        return dftyr;
    }

    public short getDftrd() {
        return dftrd;
    }

    public short getOvrl() {
        return ovrl;
    }

    public char getHand() {
        return hand;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public short getGp() {
        return gp;
    }
    
    public void setCity(String city){
        int l = city.length();
        if(l < 30) {
            StringBuilder sb = new StringBuilder(city);
            int count = 30 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.city = sb.toString();
        } else {
            this.city = city;
        }   
    }
    
    public void setPrSt(String prst){
        int l = prst.length();
        if(l < 3) {
            StringBuilder sb = new StringBuilder(prst);
            int count = 3 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.prst = sb.toString();
        } else {
            this.prst = prst;
        }   
    }
    
    public void setCntry(String cntry){
        int l = cntry.length();
        if(l < 3) {
            StringBuilder sb = new StringBuilder(cntry);
            int count = 3 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.cntry = sb.toString();
        } else {
            this.cntry = cntry;
        }   
    }
    
    public void setNat(String nat){
        int l = nat.length();
        if(l < 3) {
            StringBuilder sb = new StringBuilder(nat);
            int count = 3 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.nat = sb.toString();
        } else {
            this.nat = nat;
        }   
    }
    
    public void setLastName(String lastName){
        int l = lastName.length();
        if(l < 20) {
            StringBuilder sb = new StringBuilder(lastName);
            int count = 20 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.lastName = sb.toString();
        } else {
            this.lastName = lastName;
        }   
    }
    
    public void setFirstName(String firstName){
        int l = firstName.length();
        if(l < 20) {
            StringBuilder sb = new StringBuilder(firstName);
            int count = 20 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.firstName = sb.toString();
        } else {
            this.firstName = firstName;
        }   
    }
    
    public void setPosition(String position){
        int l = position.length();
        if(l < 10) {
            StringBuilder sb = new StringBuilder(position);
            int count = 10 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.position = sb.toString();
        } else {
            this.position = position;
        }   
    }
    
    public void setTeam(String team){
        int l = team.length();
        if(l < 15) {
            StringBuilder sb = new StringBuilder(team);
            int count = 15 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.team = sb.toString();
        } else {
            this.team = team;
        }   
    }
    
    public void setBorn(String born){
        int l = team.length();
        if(l < 8) {
            StringBuilder sb = new StringBuilder(team);
            int count = 8 - l;
            for(int i = 0;  i < count; i++) {
                sb.append(' ');
            }
            this.born = sb.toString();
        } else {
            this.born = born;
        }   
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setHt(short ht) {
        this.ht = ht;
    }

    public void setWt(short wt) {
        this.wt = wt;
    }

    public void setDftyr(short dftyr) {
        this.dftyr = dftyr;
    }

    public void setDftrd(short dftrd) {
        this.dftrd = dftrd;
    }

    public void setOvrl(short ovrl) {
        this.ovrl = ovrl;
    }

    public void setHand(char hand) {
        this.hand = hand;
    }

    public void setGp(short gp) {
        this.gp = gp;
    }
}
