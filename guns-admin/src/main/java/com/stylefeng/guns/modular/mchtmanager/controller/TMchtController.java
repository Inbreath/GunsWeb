package com.stylefeng.guns.modular.mchtmanager.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.ErrorTipCodes;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.page.PageInfoBT;
import com.ums.mbr.service.domain.Mcht;
import com.ums.mbr.service.facade.MchtFacade;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TMcht;
import com.stylefeng.guns.modular.mchtmanager.service.ITMchtService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 商户管理控制器
 *
 * @author fengshuonan
 * @Date 2018-07-10 14:13:47
 */
@ImportResource(value = "classpath:xml/all.xml")
@Controller
@RequestMapping("/tMcht")
public class TMchtController extends BaseController {

    private String PREFIX = "/mchtmanager/tMcht/";

    private ErrorTip errorTip = new ErrorTip(ErrorTipCodes.SYS_SUCCESS.getCode(), ErrorTipCodes.SYS_SUCCESS.getMessage());

    @Autowired
    private ITMchtService tMchtService;

    @Resource
    private MchtFacade mchtFacade;

    /**
     * 跳转到商户管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tMcht.html";
    }

    /**
     * 跳转到添加商户管理
     */
    @RequestMapping("/tMcht_add")
    public String tMchtAdd() {
        return PREFIX + "tMcht_add.html";
    }

    /**
     * 跳转到修改商户管理
     */
    @RequestMapping("/tMcht_update/{tMchtId}")
    public String tMchtUpdate(@PathVariable String tMchtId, Model model) {

        Mcht mcht = mchtFacade.findByMchtno(StringUtils.trimAllWhitespace(tMchtId));
        model.addAttribute("item",mcht);
        LogObjectHolder.me().set(mcht);
        return PREFIX + "tMcht_edit.html";
    }

    /**
     * 获取商户管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        List<Mcht> pageMchtList = new ArrayList<>();
        if (StringUtils.isEmpty(condition)) {
            pageMchtList = mchtFacade.findAllMcht();
        } else {
            pageMchtList.add(mchtFacade.findByMchtno(StringUtils.trimAllWhitespace(condition)));
        }

        if (null != pageMchtList || pageMchtList.size() > 0) {
            return pageMchtList;
        } else {
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_SELECT_ERROR.getCode());
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_SELECT_ERROR.getMessage());
        }

        return errorTip;
    }

    /**
     * 新增商户管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TMcht tMcht) {
        Mcht mcht = new Mcht();

        mcht.setMchtno(tMcht.getMchtno());
        mcht.setMchtname(tMcht.getMchtname());
        mcht.setBriefname(tMcht.getBriefname());
        mcht.setState(tMcht.getState());
        mcht.setSignType(tMcht.getSignType());

        mcht.setPublicKey(tMcht.getPublicKey());
        mcht.setPrivateKey(tMcht.getPrivateKey());
        mcht.setMd5key(tMcht.getMd5key());
        mcht.setRefundFlag(tMcht.getRefundFlag());
        mcht.setCategoryid(tMcht.getCategoryid());

        mcht.setMallCode(tMcht.getMallCode());
        mcht.setNote(tMcht.getNote());

        System.out.println("tmcht；"+tMcht.toString());


        if (mchtFacade.insert(mcht) <= 0) {
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_INSERT_ERROR.getCode());
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_INSERT_ERROR.getMessage());
        }

        return errorTip;
    }

    /**
     * 删除商户管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String tMchtId) {
        if (mchtFacade.delete(tMchtId) <= 0) {
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_DELETE_ERROR.getCode());
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_DELETE_ERROR.getMessage());
        }

        return errorTip;
    }

    /**
     * 修改商户管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TMcht tMcht) {
        Mcht mcht = new Mcht();

        mcht.setMchtno(tMcht.getMchtno());
        mcht.setMchtname(tMcht.getMchtname());
        mcht.setBriefname(tMcht.getBriefname());
        mcht.setState(tMcht.getState());
        mcht.setSignType(tMcht.getSignType());

        mcht.setPublicKey(tMcht.getPublicKey());
        mcht.setPrivateKey(tMcht.getPrivateKey());
        mcht.setMd5key(tMcht.getMd5key());
        mcht.setRefundFlag(tMcht.getRefundFlag());
        mcht.setCategoryid(tMcht.getCategoryid());

        mcht.setMallCode(tMcht.getMallCode());
        mcht.setNote(tMcht.getNote());

        if (mchtFacade.update(mcht) <= 0) {
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_UPDATE_ERROR.getCode());
            errorTip.setCode(ErrorTipCodes.SYS_DATABASE_UPDATE_ERROR.getMessage());
        }

        return errorTip;
    }

    /**
     * 商户管理详情
     */
    @RequestMapping(value = "/detail/{tMchtId}")
    @ResponseBody
    public Object detail(@PathVariable("tMchtId") Integer tMchtId) {
        return tMchtService.selectById(tMchtId);
    }
}
