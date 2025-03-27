
public enum Monde {
    MONDE_0(15),
    MONDE_1(12),
    MONDE_2(9),
    MONDE_3(6);

    private int nbCases;

    Monde(int nbCases) {
        this.nbCases = nbCases;
    }

    public int getNbCases() {
        return this.nbCases;
    }
}