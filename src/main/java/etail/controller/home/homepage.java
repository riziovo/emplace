package etail.controller.home;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import etail.domain.bubbles.Label;
import etail.domain.bubbles.Subcategory;
import etail.domain.seller.Seller;
import etail.incoming.domain.SellerIncoming;
import etail.service.bubbles.SubcategoriesService;
import etail.service.seller.SellerService;

@RestController
@RequestMapping("/")
public class homepage {
	SubcategoriesService subcatServ;
	SellerService ss;
	
	@Autowired
	public homepage(SubcategoriesService subcatServ, SellerService ss) {
		this.subcatServ = subcatServ;
		this.ss = ss;
	}

	@RequestMapping(value= {"index/"}, method = RequestMethod.GET)
	public String sayHello() {
		return "Hi :)";
	}
	
	@RequestMapping(value = {"post/seller"}, method = RequestMethod.POST)
	public String postSeller(@RequestBody SellerIncoming seller) {
		
		ss.saveSeller(SellerIncoming.convertFullToSeller(seller));
		return seller.toString();
	}
}
