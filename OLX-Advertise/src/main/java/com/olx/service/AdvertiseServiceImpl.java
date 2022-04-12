package com.olx.service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Advertise;
import com.olx.entity.AdvertiseEntity;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Override
	public Advertise postAdvertise(Advertise adv) {
		return null;
	}

	@Override
	public Advertise updateAdvertise(Advertise adv) {
		return null;
	}

	@Override
	public List<Advertise> getAllAdvByUser() {
		return null;
	}

	@Override
	public List<Advertise> getAdvByUser() {
		return null;
	}

//	@Override
//	public Advertise filterAdv(Advertise adv) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Autowired
	EntityManager entityManager; // JPA

	@Override
	public List<Advertise> searchAdvertisesByFilterCriteria(String searchText, int categoryId, String postedBy,
			String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
			int startIndex, int records) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AdvertiseEntity> criteriaQuery = criteriaBuilder.createQuery(AdvertiseEntity.class);
		Root<AdvertiseEntity> rootEntity = CriteriaQuery.from(AdvertiseEntity.class);
		
		Predicate predicateTitle = criteriaBuilder.and();
		Predicate predicateDescription = criteriaBuilder.and();
		Predicate predicateSearchText = criteriaBuilder.and();
		Predicate predicateCategory = criteriaBuilder.and();
		Predicate predicateDateCondition = criteriaBuilder.and();
		Predicate predicatePostedBy = criteriaBuilder.and();
		Predicate predicateFinal = criteriaBuilder.and();

		
		
		if(searchText!=null && !"".equalsIgnoreCase(searchText)) {
			predicateTitle = criteriaBuilder.like(rootEntity.get("title"), "%" + searchText + "%");
			predicateDescription = criteriaBuilder.like(rootEntity.get("description"), "%" + searchText + "%");
			predicateSearchText = criteriaBuilder.or(predicateTitle, predicateDescription);	
		}
		
		if (postedBy != null && !"".equalsIgnoreCase(postedBy)) {
			predicatePostedBy = criteriaBuilder.equal(rootEntity.get(""), PostedBy);
		}
		
		if(dateCondition != null && dateCondition.contains("equal")) {
			predicateDateCondition = criteriaBuilder.equal(rootEntity.get("createDate"),onDate);
		}
		
		if(categoryId > 0) {
			predicateCategory = criteriaBuilder.equal(rootEntity.get("category"), categoryId);
		}
		
		//Write a code to create predicates for dateConditions, categoryId, posted_by etc.
		predicateFinal = criteriaBuilder.and(predicateSearchText, predicateCategory, predicateDateCondition,
		predicatePostedBy);
		criteriaQuery.where(predicateFinal);
		TypedQuery<AdvertiseEntity> typedQuery = EntityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(startIndex);
		typedQuery.setMaxResults(records);
		
//		List<AdvertiseEntity> advertiseEntityList = typedQuery.getResultList();
//		return convertEntityListIntoDTOList(advertiseEntityList);
//		}

//	private List<Advertise> convertEntityListIntoDTOList(List<AdvertiseEntity> advertiseEntityList) {
//		List<AdvertiseDTO> advertiseDtoList = new ArrayList<AdvertiseDTO>();
//		for(AdvertiseEntity advertiseEntity : advertiseEntities) {
//			AdvertiseDTO advertise = new AdvertiseDTO(advertiseEntity.getId,advertiseEntity.getTitle(), advertiseEntity., advertiseEntity);
//			advertiseDtoList.add(advertise);
//		}
//		return advertiseDtoList;
//	}

	@Override
	public Advertise returnAdv(int id) {
		return null;
	}

	@Override
	public Advertise SearchAdvByText(String searchText) {
		return null;
	}

	@Override
	public boolean deleteAdvertise(Advertise adv) {
		return true;
	}

}
