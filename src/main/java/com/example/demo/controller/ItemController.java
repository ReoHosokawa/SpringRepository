package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Item;
import com.example.demo.service.ItemService;
import com.example.demo.service.MasterItemNameService;
import com.example.demo.service.MasterVendorService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private MasterItemNameService masterItemNameService;
	@Autowired
	private MasterVendorService masterVendorService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("items", itemService.findAll());
		return "index";
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("item", itemService.findOne(id));
		return "show";
	}
	
	@GetMapping("new")
	public String newItem(@ModelAttribute("item") Item item, Model model) {
		model.addAttribute("masterItemNames", masterItemNameService.findAll());
		model.addAttribute("masterVendors", masterVendorService.findAll());
		return "new";
	}
	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, @ModelAttribute("item") Item item, Model model) {
		model.addAttribute("item", itemService.findOne(id));
		model.addAttribute("masterItemNames", masterItemNameService.findAll());
		model.addAttribute("masterVendors", masterVendorService.findAll());
		model.addAttribute("oldItemNameId", item.getNameId());
		return "edit";
	}
	
	@PostMapping
	public String create(@ModelAttribute("item") @Validated Item item, BindingResult result, Model model) {
		final Long selectedNameId = item.getNameId();
		final Long selectedVendorId = item.getVendorId();
		boolean isError = false;
		
		if (result.hasErrors()) {
			isError = true;
		}
		
		do {
			if (selectedNameId == -1) {
				model.addAttribute("itemNameErrorMessage", "商品名を選択してください。");
				isError = true;
				break;
			}
			
			// 商品名が選択されている場合、商品テーブルに入力された商品名がすでに存在するかを確認する
			final int itemNameCount = itemService.findNameIdCount(selectedNameId);
			if (itemNameCount == 1) {
				model.addAttribute("itemNameErrorMessage", "指定された商品名はすでに登録されています。");
				isError = true;
				break;
			}
		} while (false);
		
//		final String inputItemName = item.getName();
		// 商品名マスタに登録されている商品名を指定しているか確認する
//		final int masterNameCount = masterItemNameService.findNameCount(inputItemName);
//		if (masterNameCount == 0) {
//			model.addAttribute("itemNameErrorMessage", "指定された商品名はマスタに登録されていません。");
//			return "new";
//		}
		
		if (selectedVendorId == -1) {
			model.addAttribute("vendorErrorMessage", "ベンダーを選択してください。");
			isError = true;
		}
		
		if (isError) {
			model.addAttribute("masterItemNames", masterItemNameService.findAll());
			model.addAttribute("masterVendors", masterVendorService.findAll());
			model.addAttribute("selectedItemNameId", selectedNameId);
			model.addAttribute("selectedVendorId", selectedVendorId);
			return "new";
		}
		
		// ベンダーマスタに登録されているベンダーを指定しているか確認する
//		final String inputVendorName = item.getVendor();
//		final int vendorCount = masterVendorService.findNameCount(inputVendorName);
//		if (vendorCount == 0) {
//			model.addAttribute("vendorErrorMessage", "指定されたベンダーはマスタに登録されていません。");
//			return "new";
//		}
		
		itemService.save(item);
		return "redirect:/items";
	}
	
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute("item") @Validated Item item, BindingResult result, Model model) {
		final Long selectedNameId = item.getNameId();
		final Long selectedVendorId = item.getVendorId();
		boolean isError = false;
		
		if (result.hasErrors()) {
			isError = true;
		}
		
		if (selectedNameId == -1) {
			model.addAttribute("itemNameErrorMessage", "商品名を選択してください。");
			isError = true;
		}
		
//		final String inputItemName = item.getName();
		// 商品名マスタに登録されている商品名を指定しているかチェックする
//		final int masterNameCount = masterItemNameService.findNameCount(inputItemName);
//		if (masterNameCount == 0) {
//			model.addAttribute("itemNameErrorMessage", "指定された商品名はマスタに登録されていません。");
//			return "edit";
//		}
		
		// ベンダーマスタに登録されているベンダーを指定しているかチェックする
//		final String inputVendorName = item.getVendor();
//		final int vendorCount = masterVendorService.findNameCount(inputVendorName);
//		if (vendorCount == 0) {
//			model.addAttribute("vendorErrorMessage", "指定されたベンダーはマスタに登録されていません。");
//			return "edit";
//		}
		
		if (selectedVendorId == -1) {
			model.addAttribute("vendorErrorMessage", "ベンダーを選択してください。");
			isError = true;
		}
		
		if (isError) {
			model.addAttribute("item", item);
			model.addAttribute("masterItemNames", masterItemNameService.findAll());
			model.addAttribute("masterVendors", masterVendorService.findAll());
			model.addAttribute("selectedItemNameId", selectedNameId);
			model.addAttribute("selectedVendorId", selectedVendorId);
			return "edit";
		}
		
		item.setId(id);
		itemService.update(item);
		return "redirect:/items";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		itemService.delete(id);
		return "redirect:/items"; 
	}
}
