
import java.util.ArrayList;

public class Map {
    private ArrayList<Case> map = new ArrayList<Case>();

    public Map() {
        for (Monde m : Monde.values()) {
            for (int i = 0; i < m.getNbCases(); i++) {
                Case temp = new Case(m, i);
                this.map.add(temp);
            }
        }
    }

    public Case getFirstCase() {
        return map.get(0);
    }

    public Case getCase(int numCase, Monde monde) {
        for (Case c : map) {
            if (c.getNumCase() == numCase && c.getMonde() == monde) {
                return c;
            }
        }
        return null;
    }

    public Case getLeft(Case c) {
        if (c.getNumCase() == 0) {
            return c;
        } else {
            for (Case ca : map) {
                if (ca.getMonde() == c.getMonde() && ca.getNumCase() == (c.getNumCase() - 1)) {
                    return ca;
                }
            }
            return c;
        }
    }

    public Case getRight(Case c) {
        int temp = 0;
        for (Case ca : map) {
            if (ca == c && !(c.getMonde() == Monde.MONDE_3 && c.getNumCase() == Monde.MONDE_3.getNbCases())) {
                try {
                    return map.get(temp + 1);
                } catch (IndexOutOfBoundsException e) {
                    for (int i = 0; i < 50; i++) {
                        System.out.println("\n");
                    }
                    return null;
                }

            }
            temp++;
        }
        return c;
    }

    public int getSizeMap() {
        return this.map.size();
    }

}