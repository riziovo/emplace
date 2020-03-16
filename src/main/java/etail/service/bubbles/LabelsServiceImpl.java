package etail.service.bubbles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.bubbles.Label;
import etail.domain.seller.SellerHead;
import etail.repository.bubbles.LabelsRepository;

@Service
public class LabelsServiceImpl implements LabelsService{
	private LabelsRepository labRepo;
	
	@Autowired
	public LabelsServiceImpl(LabelsRepository labRepo) {
		this.labRepo = labRepo;
	}

	@Override
	public void saveAll(List<Label> labels) {
		labRepo.saveAll(labels);
	}

	@Override
	public void deleteAll(List<Label> labels) {
		labRepo.deleteAll(labels);
	}

	@Override
	public Label findByName(String name) {
		// TODO Auto-generated method stub
		return labRepo.findByName(name);
	}

	@Override
	public List<Label> findByParent(Label parent) {
		// TODO Auto-generated method stub
		return labRepo.findByParent(parent);
	}

	@Override
	public List<Label> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return labRepo.findByNameLike(name);
	}

	@Override
	public List<Label> qfindSiblingLabelsOf(Long id) {
		// TODO Auto-generated method stub
		List<Label> l = new ArrayList<>();
		labRepo.qfindSiblingLabelsOf(id).forEach(l::add);
		return l;
	}

	@Override
	public List<Label> qfindLabelsLike(String name) {
		List<Label> l = new ArrayList<>();
		labRepo.qfindLabelsLike(name).forEach(l::add);
		return l;
	}

	@Override
	public List<Label> qfindSubLabelsOf(Long id) {
		List<Label> l = null;
		labRepo.qfindSubLabelsOf(id).forEach(l::add);
		return l;
	}

	@Override
	public List<Label> qfindParentLabels() {
		List<Label> l = new ArrayList<>();
		labRepo.qfindParentLabels().forEach(l::add);
		return l;
	}

	@Override
	public List<Long> qfindShIdsByLabelIds(List<Long> ids) {
		List<Long> l = new ArrayList<>();
		labRepo.qfindShIdsByLabelIds(ids).forEach(l::add);
		return l;
	}

	@Override
	public List<Long> qfindShIdsByLabelId(Long id) {
		List<Long> l = new ArrayList<>();
		labRepo.qfindShIdsByLabelId(id).forEach(l::add);
		return l;
	}

	@Override
	public List<SellerHead> qfindSHsByShIds(List<Long> ids) {
		List<SellerHead> l = new ArrayList<>();
		labRepo.qfindSHsByShIds(ids).forEach(l::add);
		return l;
	}

	@Override
	public void delete(Label label) {
		label.getSellers().stream().forEach(x-> x.removeLabel(label));
		labRepo.delete(label);
	}
}
