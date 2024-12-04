package com.bob.dcits.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import com.bob.dcits.annotation.Log;
import com.bob.dcits.domain.vo.EmailVo;
import com.bob.dcits.domain.EmailConfig;
import com.bob.dcits.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 发送邮件
 * @author guoq
 * @date 2024/09/28 6:55:53
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/email")
@Api(tags = "工具：邮件管理")
public class EmailController {

    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<EmailConfig> queryEmailConfig(){
        return new ResponseEntity<>(emailService.find(),HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping
    @ApiOperation("配置邮件")
    public ResponseEntity<Object> updateEmailConfig(@Validated @RequestBody EmailConfig emailConfig) throws Exception {
        emailService.config(emailConfig, emailService.find());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping
    @ApiOperation("发送邮件")
    public ResponseEntity<Object> sendEmail(@Validated @RequestBody EmailVo emailVo){
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
