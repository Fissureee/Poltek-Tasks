package tugas;

public class Pc extends Komputer{
    int ukuranMonitor;

    public Pc(){

    }
    public Pc(String merk, int kecProcessor, int sizeMemory, String jnsProsesor, int ukuranMonitor){
        super(merk, kecProcessor, sizeMemory, jnsProsesor);
        this.ukuranMonitor = ukuranMonitor;
    }

    public void tampilPc(){
        super.tampilData();
        System.out.println("Ukuran Monitor: "+ukuranMonitor);
    }
}