package etail.repository.bubbles;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.bubbles.Label;
import etail.domain.seller.SellerHead;

@Repository
@Transactional(readOnly=true)
public interface LabelsRepository  extends CrudRepository<Label, Long>{
	public Label findByName(String name);
	public List<Label> findByParent(Label parent);
	public List<Label> findByNameLike(String name);
	
	@Query(value="SELECT LABELS.* FROM LABELS WHERE LABELS.FK_PARENT_ID = :id", nativeQuery=true)
	public Collection<Label> qfindSiblingLabelsOf(@Param("id")Long id);

	@Query(value="SELECT LABELS.* FROM LABELS WHERE LABELS.NAME LIKE :name", nativeQuery=true)
	public Collection<Label> qfindLabelsLike(@Param("name")String name);
	
	@Query(value="SELECT LABELS.* FROM LABELS WHERE LABELS.FK_PARENT_ID = :id", nativeQuery=true)
	public Collection<Label> qfindSubLabelsOf(@Param("id")Long id);

	@Query(value="SELECT LABELS.* FROM LABELS WHERE LABELS.FK_PARENT_ID = null", nativeQuery=true)
	public Collection<Label> qfindParentLabels();
	
	@Query(value="SELECT SL.M_SELLER_ID FROM SELLERS_LABELS SL WHERE SL.M_LABEL_ID IN :ids", nativeQuery=true)
	public Collection<Long> qfindShIdsByLabelIds(@Param("id")List<Long> ids);
	
	@Query(value="SELECT SL.M_SELLER_ID FROM SELLERS_LABELS SL WHERE SL.M_LABEL_ID = :id", nativeQuery=true)
	public Collection<Long> qfindShIdsByLabelId(@Param("id")Long id);
	
	@Query(value="SELECT SH.* FROM SELLERHEADS SL WHERE SH.ID IN :ids", nativeQuery=true)
	public Collection<SellerHead> qfindSHsByShIds(@Param("ids")List<Long> ids);
}