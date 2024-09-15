package tugas;

public class Komputer {
    String merk, jnsProcessor;
    int kecProcessor, sizeMemory;

    public Komputer(){

    }
    public Komputer(String merk, int kecProcessor, int sizeMemory, String jnsProcessor){
        this.merk = merk;
        this.kecProcessor = kecProcessor;
        this.sizeMemory = sizeMemory;
        this.jnsProcessor = jnsProcessor;
    }

    public void tampilData(){
        System.out.println(
                "Merk: " + merk +
                "\nProcessor Speed: " + kecProcessor  +
                "\nMemory Size: " + sizeMemory +
                "\nProcessor Type: " + jnsProcessor
        );
    }
}
