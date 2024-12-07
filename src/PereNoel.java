public class PereNoel {
    public int serialNumber;
    static int numberOfSantas = 0;

    PereNoel() {
        numberOfSantas++;
        this.serialNumber = numberOfSantas;
    }
}
