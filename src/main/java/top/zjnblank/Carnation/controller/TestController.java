package top.zjnblank.Carnation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zjnblank.Carnation.service.IMailService;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final IMailService mailService;

    @GetMapping("/tSendMimeMail")
    public String tSendMimeMail() {
        mailService.sendMimeMail();
        return "success";
    }
}
