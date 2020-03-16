package etail.service.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.seller.SellerBody;
import etail.repository.seller.SellerBodyRepository;

@Service
public class SellerBodyServiceImpl implements SellerBodyService{
	private SellerBodyRepository sbRepo;
	
	@Autowired
	public SellerBodyServiceImpl(SellerBodyRepository sbRepo) {
		this.sbRepo = sbRepo;
	}

	@Override
	public boolean updateBody(SellerBody s) {
		// TODO Auto-generated method stub
		SellerBody ent = sbRepo.findById(s.getId()).orElse(null);
		if(ent == null) return false;
		ent.setBodyDesc(s.getBodyDesc());
		ent.setBodyHours(s.getBodyHours());
		sbRepo.save(ent);
		return true;
	}

	@Override
	public SellerBody findSellerById(Long id) {
		// TODO Auto-generated method stub
		return sbRepo.findById(id).orElse(null);
	}

	@Override
	public void saveSellerBody(SellerBody s) {
		// TODO Auto-generated method stub
		sbRepo.save(s);
	}
}
