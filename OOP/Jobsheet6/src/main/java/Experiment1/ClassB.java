package Experiment1;

public class ClassB extends ClassA{
    public int z;
    public ClassB(){
        super();
    }
    public void getNilaiZ(){
        System.out.println("nilai Z:"+z);
    }
    public void getJumlah(){
        System.out.println("Jumlah:" + (x+y+z));
    }
}
