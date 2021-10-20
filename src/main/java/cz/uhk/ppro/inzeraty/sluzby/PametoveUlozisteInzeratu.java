package cz.uhk.ppro.inzeraty.sluzby;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cz.uhk.ppro.inzeraty.model.Inzerat;

public class PametoveUlozisteInzeratu implements UlozisteInzeratu {
    private List<Inzerat> inzeraty = new ArrayList<Inzerat>();

    @Override
    public List<Inzerat> getInzeraty() {
        return Collections.unmodifiableList(inzeraty);
    }

    @Override
    public void pridej(Inzerat i) {
        inzeraty.add(i);
        int maxId = 0;
        // vygenerovat nove id (bezne dela databaze)
        for (Inzerat inz : inzeraty) {
            if (inz.getId() > maxId) maxId = inz.getId();
        }
        i.setId(maxId + 1);
        Collections.sort(inzeraty, new Comparator<Inzerat>() {

            public int compare(Inzerat o1, Inzerat o2) {
                return o1.getDatum().compareTo(o2.getDatum());
            }

        });
    }

    @Override
    public void odstran(Inzerat i) {
        inzeraty.remove(i);
    }

    @Override
    public void odstran(int id) {
        inzeraty.remove(getById(id));
    }

    @Override
    public void uprav(Inzerat i) {
        for (int j = 0; j < inzeraty.size(); j++) {
            if (i.getId() == inzeraty.get(j).getId()) {
                inzeraty.set(j, i);
                return;
            }
        }
    }

    @Override
    public Inzerat getById(int id) {
        for (Inzerat i : inzeraty) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Inzerat> getInzeratyByKategorie(String kategorie) {
        List<Inzerat> vysledky = new ArrayList<Inzerat>();
        for (Inzerat i : inzeraty) {
            if (kategorie.equals(i.getKategorie())) {
                vysledky.add(i);
            }
        }
        return vysledky;
    }

}
