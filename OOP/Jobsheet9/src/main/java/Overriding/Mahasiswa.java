package Overriding;

public class Mahasiswa extends Manusia{
    @Override
    public void makan() {
        super.makan();
    }

    public void tidur(){}
}
