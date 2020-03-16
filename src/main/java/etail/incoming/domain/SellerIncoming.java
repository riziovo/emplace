package etail.incoming.domain;

import java.util.HashSet;
import java.util.List;
import etail.domain.bubbles.Label;
import etail.domain.bubbles.Subcategory;
import etail.domain.seller.Seller;
import etail.domain.seller.SellerAddress;
import etail.domain.seller.SellerBody;
import etail.domain.seller.SellerHead;
import etail.domain.seller.SellerPInfo;

public class SellerIncoming {
	public SellerHead sHead;
	public SellerBody sBody;
	public SellerAddress sA;
	public SellerPInfo sInfo;
	public List<Subcategory> subcatgrs;
	public List<Label> labels;
	
	public static Seller convertFullToSeller(SellerIncoming sInc) {
		Seller seller = new Seller();
		
		sInc.sHead.setSeller(seller);
		sInc.sA.setSellerHead(sInc.sHead);
		sInc.sBody.setSeller(seller);
		sInc.sInfo.setSeller(seller);
		//
		seller.setSellerHead(sInc.sHead);
		
		seller.setSellerBody(sInc.sBody);
		seller.setSellerPInfo(sInc.sInfo);
		
		return seller;
	}

	public SellerIncoming(SellerHead sHead, SellerBody sBody, SellerAddress sA, SellerPInfo sInfo,
			List<Subcategory> subcatgrs, List<Label> labels) {
		
		this.subcatgrs = subcatgrs;
		this.labels = labels;
		
		this.sHead = sHead;
		this.sHead.setArea(sA.getArea());
		this.sHead.setCity(sA.getArea().getCity());
		this.sHead.setState(sA.getArea().getCity().getState());
		this.sHead.setSellerAddress(sA);
		
		if(this.subcatgrs!= null)
			this.sHead.setSubcategories(new HashSet<>(this.subcatgrs));
		
		if(this.labels != null)
			this.sHead.setLabels(new HashSet<>(this.labels));
		
		this.sBody = sBody;
		this.sA = sA;
		this.sInfo = sInfo;
	}
}
