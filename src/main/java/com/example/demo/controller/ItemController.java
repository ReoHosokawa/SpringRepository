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

		itemService.save(item);
		return "redirect:/items";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute("item") @Validated Item item, BindingResult result,
			Model model) {
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
