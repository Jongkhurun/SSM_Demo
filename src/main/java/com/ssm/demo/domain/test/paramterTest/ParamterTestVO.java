package com.ssm.demo.domain.test.paramterTest;

import com.ssm.demo.domain.verificationGroups.First;
import com.ssm.demo.domain.verificationGroups.Second;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author 懒♂癌
 * @date 2018-01-31 9:46
 */
@Data
public class ParamterTestVO {
    @NotNull(message = "Id 不能为空", groups = First.class)
    Integer id;

    @Max(value = 99, message = "页码最大不能超过99")
    Integer pageIndex = 1;

    @NotNull(message = "修改时间不能为空", groups = Second.class)
    @DateTimeFormat(pattern = "yyyy-MM")
    Date updateTime;

    @Size(min = 1, max = 20, message = "产品名称不能超过20个字", groups = Second.class)
    String name;

    @NotNull(message = "金额不能为空")
    Double price;
}
