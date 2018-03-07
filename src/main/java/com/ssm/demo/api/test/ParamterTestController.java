package com.ssm.demo.api.test;

import com.ssm.demo.domain.object.vo.ParamterTestVO;
import com.ssm.demo.domain.object.vo.groups.First;
import com.ssm.demo.domain.object.vo.groups.Second;
import com.ssm.demo.utils.common.RD;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 懒♂癌
 * @date 2018-01-27 17:04
 */
@RestController
@RequestMapping("/test/paramterTest")
public class ParamterTestController {
    @RequestMapping("/obtain")
    public RD obtain(@Validated ParamterTestVO o){
        System.out.println("123");
        return RD.success(o);
    }

    @RequestMapping("/obtainFirst")
    public RD obtainFirst(@Validated({First.class}) ParamterTestVO o){
        System.out.println("First");
        return RD.success(o);
    }

    @RequestMapping("/obtainSecond")
    public RD obtainSecond(@Validated({Second.class}) ParamterTestVO o){
        System.out.println("Second");
        return RD.success(o);
    }

    @RequestMapping("/obtainString")
    public  RD obtainString(){
        return RD.success();
    }

    /**
     * 好像不可以接收List 模型
     * @param o
     * @return
     */
    @RequestMapping("/obtaisList")
    public RD obtaisList(@Validated({Second.class}) List<ParamterTestVO> o){
        System.out.println("List");
        return RD.success(o);
    }
}
