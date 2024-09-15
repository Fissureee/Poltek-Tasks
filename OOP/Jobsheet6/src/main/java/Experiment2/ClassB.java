package Experiment2;

public class ClassB extends ClassA{
    private int z, x, y;
    public ClassB(){
        x = super.getX();
        y = super.getY();
    }
    public void setZ(int z){
        this.z = z;
    }
    public void getNilaiZ(){
        System.out.println("nilai Z:"+z);
    }
    public void getJumlah(){
        System.out.println("jumlah:"+ (x+y+z));
    }
}
