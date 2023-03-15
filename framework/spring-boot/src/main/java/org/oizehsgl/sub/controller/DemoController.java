package org.oizehsgl.sub.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * controller
 *
 * @author oizehsgl
 * @Controller 控制器
 * @ResponseBody 返回json, xml
 * @RestController 返回json, 不能返回html
 * @since 3/13/23
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping(value = "/param/{length}/{pattern}/{range}", params = {"user=user", "pswd=pswd"}, headers = "HOST=localhost:8080", method = RequestMethod.GET)
    public R<List<DemoData>> passParameter(DemoData demoData1, String length, @PathVariable String pattern, @RequestParam Integer range, @Validated @RequestBody DemoData demoData2) {
        List<DemoData> demoDataList = new ArrayList<>();
        DemoData demoData = DemoData.builder().length(length).pattern(pattern).range(range).build();
        demoDataList.add(demoData);
        demoDataList.add(demoData1);
        demoDataList.add(demoData2);
        return R.response(RStatus.OK, demoDataList);
    }

    @GetMapping("/param/{length}")
    public R<List<DemoData>> passParameters(@PathVariable List<String> length, @RequestParam List<String> lengths) {
        RStatus rStatus = RStatus.OK;
        List<DemoData> returnDemoDataList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(returnDemoDataList)) {
            rStatus = RStatus.INTERNAL_SERVER_ERROR;
        }
        return R.response(rStatus, returnDemoDataList);
    }


    @GetMapping("/{length}")
    public R<DemoData> get(@Validated DemoData demoData) {
        RStatus rStatus = RStatus.OK;
        DemoData returnDemoData = demoData;
        if (Objects.isNull(returnDemoData)) {
            rStatus = RStatus.INTERNAL_SERVER_ERROR;
        }
        return R.response(rStatus, returnDemoData);
    }

    @GetMapping
    public R<List<DemoData>> get(@Validated @RequestBody List<DemoData> demoDataList) {
        List<DemoData> returnDemoDataList = demoDataList;
        return R.response(RStatus.OK, returnDemoDataList);
    }

    @PostMapping
    public R<List<DemoData>> post(@Validated @RequestBody List<DemoData> demoDataList) {
        RStatus rStatus = RStatus.OK;
        List<DemoData> returnDemoDataList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(returnDemoDataList)) {
            rStatus = RStatus.INTERNAL_SERVER_ERROR;
        }
        return R.response(rStatus, returnDemoDataList);
    }

    @PutMapping
    public R<List<DemoData>> put(@Validated @RequestBody List<DemoData> demoDataList) {
        RStatus rStatus = RStatus.OK;
        List<DemoData> returnDemoDataList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(returnDemoDataList)) {
            rStatus = RStatus.INTERNAL_SERVER_ERROR;
        }
        return R.response(rStatus, returnDemoDataList);
    }

    @DeleteMapping
    public R<List<DemoData>> delete(@Validated @RequestBody List<DemoData> demoDataList) {
        RStatus rStatus = RStatus.OK;
        List<DemoData> returnDemoDataList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(returnDemoDataList)) {
            rStatus = RStatus.INTERNAL_SERVER_ERROR;
        }
        return R.response(rStatus, returnDemoDataList);
    }
}
