public class Vehicle {
    String regNo, make;
    Integer yoManuf;
    double value;

    public Vehicle (String inregNo, String inmake, Integer inyoManuf, double invalue){
        this.regNo = inregNo;
        this.make = inmake;
        this.yoManuf = inyoManuf;
        this.value = invalue;
    }

    public String getRegNo(){
        return regNo;
    }

    public String getMake(){
        return  make;
    }

    public Integer getYoManuf(){
        return yoManuf;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double inValue){
        value = inValue;
    }

    public int calculateAge(int currYear){
        return currYear - yoManuf;
    }

    @Override
    public String toString(){
        return "Reg No: " + regNo+ ", Make: " + make + ", Year of Manufacture: " + yoManuf + ", Value: " + value;
    }
}
