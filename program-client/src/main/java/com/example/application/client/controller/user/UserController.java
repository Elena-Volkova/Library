package com.example.application.client.controller.user;

import com.example.application.client.service.UserService;
import com.example.application.client.service.model.RoleEnum;
import com.example.application.client.service.model.Search;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * User Controller
 */
@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView adminPage(
            @RequestParam(required = false) boolean successAdd,
            @RequestParam(required = false) boolean successUpdate,
            @RequestParam(required = false) boolean successDelete
    ) {
        ModelAndView model = new ModelAndView();
        if (successAdd) {
            model.addObject("msg", "Производство успешно создано!");
        }
        if (successUpdate) {
            model.addObject("msg", "Производство успешно обновлено!");
        }
        if (successDelete) {
            model.addObject("msg", "Производство успешно удалено!");
        }
        model.addObject("search", new Search());
/*        List<Process> processes = processService.getProcesses(new Search());
        model.addObject("processes", processes);
        model.addObject("count", processes.size());*/
        model.setViewName("user");
        return model;
    }

/*    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute Search search) {
        ModelAndView model = new ModelAndView();
        List<Process> processes = processService.getProcesses(search);
        model.addObject("processes", processes);
        model.addObject("count", processes.size());
        model.addObject("users", userService.getUsers());
        model.addObject("search", search);
        model.setViewName("user");
        return model;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public ModelAndView addProcess() {
        ModelAndView model = new ModelAndView();
        model.addObject("process", new Process());
        model.addObject("users", userService.getUsers());
        model.setViewName("add_process");
        return model;
    }

    @RequestMapping(value = "/user/update/{processId}", method = RequestMethod.GET)
    public ModelAndView updateProcess(@PathVariable Long processId) {
        ModelAndView model = new ModelAndView();
        Process process = processService.getProcess(processId);
        model.addObject("process", process);
        model.addObject("payments", process.getPayments());
        model.addObject("users", userService.getUsers());
        model.setViewName("update_process");
        return model;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ModelAndView addProcess(@ModelAttribute Process process) {
        ModelAndView model = new ModelAndView();
        processService.add(process);
        model.setViewName("redirect:/user?successAdd=true");
        return model;
    }

    @RequestMapping(value = "/user/update/{processId}", method = RequestMethod.POST)
    public ModelAndView updateProcess(@PathVariable Long processId, @ModelAttribute Process process) {
        ModelAndView model = new ModelAndView();
        process.setId(processId);
        processService.update(process);
        model.setViewName("redirect:/user?successUpdate=true");
        return model;
    }

    @RequestMapping(value = "/user/delete/{processId}", method = RequestMethod.GET)
    public ModelAndView deleteProcess(@PathVariable Long processId) {
        ModelAndView model = new ModelAndView();
        processService.delete(processId);
        model.setViewName("redirect:/user?successDelete=true");
        return model;
    }

    @RequestMapping(value = "/user/report/{processId}", method = RequestMethod.GET)
    public ModelAndView printProcess(@PathVariable Long processId) {
        ModelAndView model = new ModelAndView();
        model.addObject("process", processService.getProcess(processId));
        model.setViewName("report");
        return model;
    }

    @RequestMapping(value = "/user/statistic", method = RequestMethod.GET)
    public ModelAndView statistic() {
        ModelAndView model = new ModelAndView();
        model.addObject("search", new StatisticSearch());
        List<Process> processes = processService.getProcesses(new Search());
        model.addObject("processes", processes);
        model.addObject("count", processes.size());
        model.addObject("users", userService.getUsers());
        model.setViewName("statistic");
        return model;
    }

    @RequestMapping(value = "/user/statistic", method = RequestMethod.POST)
    public ModelAndView statisticSearch(@ModelAttribute StatisticSearch search) {
        ModelAndView model = new ModelAndView();
        List<Process> processes = processService.getProcesses(search);
        model.addObject("processes", processes);
        model.addObject("count", processes.size());
        model.addObject("users", userService.getUsers());
        model.addObject("search", search);
        model.setViewName("statistic");
        return model;
    }

    @RequestMapping(value = "/user/statistic/field", method = RequestMethod.GET)
    public ModelAndView statisticByField() {
        ModelAndView model = new ModelAndView();
        model.addObject("report", processService.getReportByField(new Search()));
        model.setViewName("report-field");
        return model;
    }

    @RequestMapping(value = "/user/statistic/user", method = RequestMethod.GET)
    public ModelAndView statisticByUser(Long userId) {
        ModelAndView model = new ModelAndView();
        model.addObject("report", processService.getReportByUser(userId));
        model.setViewName("report-user");
        return model;
    }*/
}
