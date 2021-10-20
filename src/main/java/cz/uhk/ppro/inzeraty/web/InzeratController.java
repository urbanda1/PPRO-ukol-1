package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InzeratController {
    private PametoveUlozisteInzeratu inzeraty = new PametoveUlozisteInzeratu();


    @RequestMapping("/")
    public ModelAndView zobrazitMain() {
        ModelAndView model = new ModelAndView("main");
        model.addObject("inzeraty", inzeraty.getInzeraty());

        return model;
    }

    @RequestMapping("/create-form")
    public ModelAndView zobrazitCreate() {
        Inzerat i = new Inzerat();
        ModelAndView model = new ModelAndView("create");
        model.addObject("inzerat", i);

        return model;
    }

    @PostMapping("/saveInzerat")
    public String create(@ModelAttribute("inzerat") Inzerat i) {
        inzeraty.pridej(i);

        return "redirect:/";
    }

}