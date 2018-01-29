package com.ssm.demo.api.test;

import com.ssm.demo.utils.common.RD;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 懒♂癌
 * @date 2018-01-27 17:04
 */
@RestController
@RequestMapping("/test/paramterModel")
public class ParamterModelApi {
    @RequestMapping("/obtain")
    public RD obtain(){
        System.out.println("123");
        return RD.success();
    }
}
