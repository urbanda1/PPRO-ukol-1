package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InzeratController {
    private PametoveUlozisteInzeratu inzerat = new PametoveUlozisteInzeratu();


    /**
     * @return katalog
     */
    public PametoveUlozisteInzeratu getKatalog() {
        return inzerat;
    }

    /**
     * @param inzerat katalog, který má být nastaven (injektujeme pomoci anotaci)
     */
//    @Autowired
//    public void setKatalog(PametoveUlozisteInzeratu inzerat) {
//        this.inzerat = inzerat;
//    }

    /**
     * Vlastni akce namapovana na danou URL, naplni Model pro JSP a urci logicke jmeno view
     */
    @RequestMapping("/inzerat.do")
    public ModelAndView zobrazit() {
        ModelAndView model = new ModelAndView("main");
        System.out.println(inzerat.getInzeraty());
        model.addObject("inzeraty", inzerat.getInzeraty());

        return model;
    }

}