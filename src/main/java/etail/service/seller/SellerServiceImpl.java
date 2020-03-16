package etail.service.seller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.seller.Seller;
import etail.domain.seller.SellerBody;
import etail.domain.seller.SellerHead;
import etail.repository.seller.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService{
	public SellerRepository sellerRepo;
	public SellerAddressService saService;
	public SellerHeadService shService;
	
	@Autowired
	public SellerServiceImpl(SellerRepository sellerRepo, SellerAddressService saService, SellerHeadService shServ) {
		this.sellerRepo = sellerRepo;
		this.saService = saService;
		this.shService = shServ;
	}

	public SellerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Seller findSellerById(Long id) {
		return this.sellerRepo.findById(id).orElse(null);
	}

	@Override
	public void saveSeller(Seller s) {
		sellerRepo.save(s);
	}
	
	@Override
	public void deleteSellerById(Long id) {
		sellerRepo.deleteById(id);
	}

	@Override
	public List<SellerHead> getSellersByAreaId(Long id) {
		return saService.getSellersByAreaId(id);
	}

	@Override
	public List<SellerHead> getSellersByCityId(Long id) {
		// TODO Auto-generated method stub
		return saService.getSellersByCityId(id);
	}

	@Override
	public List<Seller> getSellerByQueryArea(Long id) {
		return sellerRepo.findAllSellersByArea(id).stream().collect(Collectors.toList());
	}

	@Override
	public List<Seller> getSellerByQueryCity(Long id) {
		return sellerRepo.findAllSellersByCity(id).stream().collect(Collectors.toList());
	}

	@Override
	public List<Seller> getAllSellers() {
		// TODO Auto-generated method stub
		List<Seller> sellers = new ArrayList<>();
		sellerRepo.findAll().forEach(x-> sellers.add(x));
		
		return sellers;
	}

	@Override
	public SellerHead findSellerHeadById(Long id) {
		// TODO Auto-generated method stub
		return sellerRepo.findById(id).orElse(null).getSellerHead();
	}

	@Override
	public SellerBody findSellerBodyById(Long id) {
		// TODO Auto-generated method stub
		return sellerRepo.findById(id).orElse(null).getSellerBody();
	}

	@Override
	public List<Seller> findSellerByName(String name) {
		// TODO Auto-generated method stub
		List<Seller> sellers = new ArrayList<>();
		shService.findByNameLike(name).forEach(s -> sellers.add(s.getSeller()));
		return sellers;
	}
}
