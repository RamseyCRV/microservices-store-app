package com.crv.microstore.smartadmin.Controller;

import com.crv.microstore.smartadmin.Config.SmartAdminConstants.ControllerConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping(value = ControllerConstants.URL_DASHBOARD)
public class DashboardController {

    @GetMapping
    public ModelAndView getDashboardPage(final Model model){

        return new ModelAndView(ControllerConstants.VIEW_DASHBOARD);
    }

}
