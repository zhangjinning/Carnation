package top.zjnblank.Carnation.service.impl;

import cn.hutool.core.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import top.zjnblank.Carnation.service.IMailService;

import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MailServiceImpl implements IMailService {
    private final JavaMailSender mailSender;

    @Override
    public boolean sendMimeMail() {
        String code = RandomUtil.randomNumbers(4);

        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true);
            msgHelper.setFrom("zjnblank@126.com");
            msgHelper.setTo("663232104@qq.com");
            msgHelper.setSubject("欢迎注册zjnblank");
            msgHelper.setText("<html><body><h1 style=\"color:red;\">您好，您申请注册的验证码为：" + code + "</h1></body></html>", true);
            mailSender.send(msg);
            return true;
        } catch (Exception e) {
            log.error("Exception: \n", e);
        }
        return false;
    }
}
