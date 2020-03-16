package etail.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import etail.domain.seller.Seller;
import etail.service.seller.SellerService;

@RestController
@RequestMapping(value= {""})
public class IndexController {
	
	public SellerService sellerServ;
	
	public IndexController(SellerService sellerServ) {
		this.sellerServ = sellerServ;
	}

	@RequestMapping(value= {"/all"}, method = RequestMethod.GET)
	public List<Seller> getAllSellers() {
		//model.addAttribute("sellers", sellerServ.getAllSellers());
		return sellerServ.getAllSellers();
	}
	
	@RequestMapping(value= {"/search"}, method = RequestMethod.GET)
	public List<Seller> SearchSellersByArea(@RequestParam(name="ae")Long id) {
		//model.addAttribute("sellers", sellerServ.getAllSellers());
		return sellerServ.getSellerByQueryArea(id);
	}
}