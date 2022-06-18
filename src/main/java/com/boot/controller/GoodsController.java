package com.boot.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.entity.Cate;
import com.boot.entity.Goods;
import com.boot.service.CateService;
import com.boot.service.GoodsService;
import com.boot.util.PageHelper;
import com.boot.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/goods" , produces = "text/plain;charset=utf-8")
public class GoodsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createGoods.action")
	public String createGoods() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/addgoods";
	}
	// 添加数据
	@RequestMapping("addGoods.action")
	public String addGoods(Goods goods) {
		goods.setSellnum("0");
		goods.setAddtime(VeDate.getStringDateShort());
		goods.setHits("0");
		this.goodsService.insertGoods(goods);
		return "redirect:/goods/createGoods.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteGoods.action")
	public String deleteGoods(String id) {
		this.goodsService.deleteGoods(id);
		return "redirect:/goods/getAllGoods.action";
	}

	// 批量删除数据
	@RequestMapping("deleteGoodsByIds.action")
	public String deleteGoodsByIds() {
		String[] ids = this.getRequest().getParameterValues("goodsid");
		if (ids != null) {
			for (String goodsid : ids) {
				this.goodsService.deleteGoods(goodsid);
			}
		}
		return "redirect:/goods/getAllGoods.action";
	}

	// 更新数据
	@RequestMapping("updateGoods.action")
	public String updateGoods(Goods goods) {
		this.goodsService.updateGoods(goods);
		return "redirect:/goods/getAllGoods.action";
	}

	// 显示全部数据
	@RequestMapping("getAllGoods.action")
	public String getAllGoods(String number) {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		PageHelper.getPage(goodsList, "goods", null, null, 10, number, this.getRequest(), null);
		return "admin/listgoods";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryGoodsByCond.action")
	public String queryGoodsByCond(String cond, String name, String number) {
		Goods goods = new Goods();
		if(cond != null){
			if ("goodsname".equals(cond)) {
				goods.setGoodsname(name);
			}
			if ("image".equals(cond)) {
				goods.setImage(name);
			}
			if ("cateid".equals(cond)) {
				goods.setCateid(name);
			}
			if ("price".equals(cond)) {
				goods.setPrice(name);
			}
			if ("recommend".equals(cond)) {
				goods.setRecommend(name);
			}
			if ("special".equals(cond)) {
				goods.setSpecial(name);
			}
			if ("storage".equals(cond)) {
				goods.setStorage(name);
			}
			if ("sellnum".equals(cond)) {
				goods.setSellnum(name);
			}
			if ("addtime".equals(cond)) {
				goods.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				goods.setHits(name);
			}
			if ("contents".equals(cond)) {
				goods.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.goodsService.getGoodsByLike(goods), "goods", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querygoods";
	}

	// 按主键查询数据
	@RequestMapping("getGoodsById.action")
	public String getGoodsById(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editgoods";
	}


}
