package tugas;

public class Mac extends Laptop{
    String security;

    public Mac(){

    }
    public Mac(String merk, int kecProcessor, int sizeMemory, String jnsProsesor, String jnsBattery, String security){
        super(merk, kecProcessor, sizeMemory, jnsProsesor, jnsBattery);
        this.security = security;
    }

    public void tampilMac(){
        super.tampilData();
        System.out.println("Battery Type: "+security);
    }
}
