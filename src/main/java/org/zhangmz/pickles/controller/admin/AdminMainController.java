/*******************************************************************************
 * Copyright (c) 2015, 2016 张孟志 104446930@qq.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.zhangmz.pickles.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Title:AdminMainController.java
 * Description:控制台主页控制器
 * Company: DigitalChina 2016
 * @author:张孟志
 * @date:2016年1月25日 下午7:58:13
 * 说明：
 */
@Controller
@RequestMapping("/admin/main")
public class AdminMainController {

	@RequestMapping
	public ModelAndView home() {
		ModelAndView result = new ModelAndView("admin/main");
		return result;
    }
}