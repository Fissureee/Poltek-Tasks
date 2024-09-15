package tugas;

public class Laptop extends Komputer{
    String jnsBattery;

    public Laptop(){

    }
    public Laptop(String merk, int kecProcessor, int sizeMemory, String jnsProsesor, String jnsBattery){
        super(merk, kecProcessor, sizeMemory, jnsProsesor);
        this.jnsBattery = jnsBattery;
    }

    public void tampilLaptop(){
        super.tampilData();
        System.out.println("Battery Type: "+jnsBattery);
    }
}
