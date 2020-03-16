package etail.service.seller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import etail.domain.seller.Seller;
import etail.domain.seller.SellerAddress;
import etail.domain.seller.SellerHead;
import etail.repository.seller.SellerAddressRepository;
import etail.repository.seller.SellerRepository;

@Service
public class SellerAddressServiceImpl implements SellerAddressService{
	public SellerAddressRepository sellerAddressRepo;
	public SellerRepository sellerRepo;
	
	public SellerAddressServiceImpl(SellerAddressRepository sellerAddressRepo, SellerRepository sellerRepo) {
		this.sellerAddressRepo = sellerAddressRepo;
		this.sellerRepo = sellerRepo;
	}

	public SellerAddressServiceImpl() {
	}

	@Override
	public void updateSellerAddressById(SellerAddress s) {
		this.sellerAddressRepo.save(s);
	}

	@Override
	public void saveSellerAddress(SellerAddress s) {
		this.sellerAddressRepo.save(s);
	}

	@Override
	public SellerAddress getSellerAddressById(Long id) {
		// TODO Auto-generated method stub
		return this.sellerAddressRepo.findById(id).orElse(null);
	}

	@Override
	public List<SellerHead> getSellersByAreaId(Long id) {
		List<SellerHead> sellers = new ArrayList<>();
		this.sellerAddressRepo.findAll().forEach(x->{
			if(x.getArea().getId() == id)
				sellers.add(x.getSellerHead());
		});
		return sellers;
	}

	@Override
	public List<SellerHead> getSellersByCityId(Long id) {
		List<SellerHead> sellers = new ArrayList<>();
		this.sellerAddressRepo.findAll().forEach(x->{
			if(x.getArea().getCity().getId() == id)
				sellers.add(x.getSellerHead());
		});
		return sellers;
	}
}
