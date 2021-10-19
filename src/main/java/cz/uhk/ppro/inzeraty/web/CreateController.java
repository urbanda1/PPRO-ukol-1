package cz.uhk.ppro.inzeraty.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateController {

    @RequestMapping("/create-controller")
    public String defectDetails() {
        return "create";
    }
}


