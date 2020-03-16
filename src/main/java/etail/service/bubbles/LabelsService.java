package etail.service.bubbles;

import java.util.Collection;
import java.util.List;

import etail.domain.bubbles.Label;
import etail.domain.seller.SellerHead;

public interface LabelsService {
	public void saveAll(List<Label> labels);
	public void deleteAll(List<Label> labels);
	public void delete(Label label);
	
	
	public Label findByName(String name);
	public List<Label> findByParent(Label parent);
	public List<Label> findByNameLike(String name);
	
	public List<Label> qfindSiblingLabelsOf(Long id);

	public List<Label> qfindLabelsLike(String name);
	
	public List<Label> qfindSubLabelsOf(Long id);

	public List<Label> qfindParentLabels();
	
	public List<Long> qfindShIdsByLabelIds(List<Long> ids);	
	public List<Long> qfindShIdsByLabelId(Long id);
	public List<SellerHead> qfindSHsByShIds(List<Long> ids);

}
