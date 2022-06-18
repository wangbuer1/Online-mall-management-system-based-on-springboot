package com.boot.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.entity.Details;
import com.boot.entity.Goods;
import com.boot.service.DetailsService;
import com.boot.service.GoodsService;
import com.boot.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/details" , produces = "text/plain;charset=utf-8")
public class DetailsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private GoodsService goodsService;

	// 准备添加数据
	@RequestMapping("createDetails.action")
	public String createDetails() {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "admin/adddetails";
	}
	// 添加数据
	@RequestMapping("addDetails.action")
	public String addDetails(Details details) {
		this.detailsService.insertDetails(details);
		return "redirect:/details/createDetails.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteDetails.action")
	public String deleteDetails(String id) {
		this.detailsService.deleteDetails(id);
		return "redirect:/details/getAllDetails.action";
	}

	// 批量删除数据
	@RequestMapping("deleteDetailsByIds.action")
	public String deleteDetailsByIds() {
		String[] ids = this.getRequest().getParameterValues("detailsid");
		if (ids != null) {
			for (String detailsid : ids) {
				this.detailsService.deleteDetails(detailsid);
			}
		}
		return "redirect:/details/getAllDetails.action";
	}

	// 更新数据
	@RequestMapping("updateDetails.action")
	public String updateDetails(Details details) {
		this.detailsService.updateDetails(details);
		return "redirect:/details/getAllDetails.action";
	}

	// 显示全部数据
	@RequestMapping("getAllDetails.action")
	public String getAllDetails(String number) {
		List<Details> detailsList = this.detailsService.getAllDetails();
		PageHelper.getPage(detailsList, "details", null, null, 10, number, this.getRequest(), null);
		return "admin/listdetails";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryDetailsByCond.action")
	public String queryDetailsByCond(String cond, String name, String number) {
		Details details = new Details();
		if(cond != null){
			if ("ordercode".equals(cond)) {
				details.setOrdercode(name);
			}
			if ("goodsid".equals(cond)) {
				details.setGoodsid(name);
			}
			if ("price".equals(cond)) {
				details.setPrice(name);
			}
			if ("num".equals(cond)) {
				details.setNum(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.detailsService.getDetailsByLike(details), "details", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querydetails";
	}

	// 按主键查询数据
	@RequestMapping("getDetailsById.action")
	public String getDetailsById(String id) {
		Details details = this.detailsService.getDetailsById(id);
		this.getRequest().setAttribute("details", details);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "admin/editdetails";
	}


}
