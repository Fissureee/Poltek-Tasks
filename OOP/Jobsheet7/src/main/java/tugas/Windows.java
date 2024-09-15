package tugas;

public class Windows extends Laptop{
    String fitur;

    public Windows(){

    }
    public Windows(String merk, int kecProcessor, int sizeMemory, String jnsProsesor, String jnsBattery, String fitur){
        super(merk, kecProcessor, sizeMemory, jnsProsesor, jnsBattery);
        this.fitur = fitur;
    }

    public void tampilWindows(){
        super.tampilData();
        System.out.println("Feature: "+fitur);
    }
}
