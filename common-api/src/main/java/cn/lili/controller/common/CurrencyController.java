package cn.lili.controller.common;

import cn.lili.common.enums.ResultUtil;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.system.entity.enums.SettingEnum;
import cn.lili.modules.system.service.SettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Currency format setting api")
@RequestMapping("/common/common/currency")
public class CurrencyController {
    @Autowired
    private SettingService settingService;

    @ApiOperation(value = "currency")
    @GetMapping
    public ResultMessage<Object> getCurrencyFormat() {
        return ResultUtil.data(settingService.get(SettingEnum.BASE_SETTING.name()));
    }
}
