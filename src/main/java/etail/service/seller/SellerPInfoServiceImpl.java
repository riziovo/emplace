package etail.service.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.seller.SellerPInfo;
import etail.repository.seller.SellerPInfoRepository;

@Service
public class SellerPInfoServiceImpl implements SellerPInfoService{
	private SellerPInfoRepository spiRepo;
	
	@Autowired
	public SellerPInfoServiceImpl(SellerPInfoRepository spiRepo) {
		this.spiRepo = spiRepo;
	}

	@Override
	public SellerPInfo findByEmailPrimary(String em) {
		// TODO Auto-generated method stub
		return spiRepo.findByEmailPrimary(em);
	}

	@Override
	public SellerPInfo findByPhonePrimary(String em) {
		// TODO Auto-generated method stub
		return spiRepo.findByPhonePrimary(em);
	}

	@Override
	public SellerPInfo findByGIN(String gin) {
		// TODO Auto-generated method stub
		return spiRepo.findByGIN(gin);
	}
}
