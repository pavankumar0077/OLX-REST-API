package com.olx.service;

import java.time.LocalDate;
import java.util.List;

import com.olx.dto.Advertise;

public interface AdvertiseService {

	public Advertise postAdvertise(Advertise adv);

	public Advertise updateAdvertise(Advertise adv);

	public boolean deleteAdvertise(Advertise adv);

	public List<Advertise> getAllAdvByUser();

	public List<Advertise> getAdvByUser();

	public Advertise SearchAdvByText(String searchText);

	public Advertise returnAdv(int id);

//	public List<Advertise> searchAdvertisesByFilterCriteria(String searchText, int categoryId, String postedBy,
//			String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
//			int startIndex, int records);
	List<Advertise> filterAdvertise(String searchText, Integer categoryId, String postedBy, String dateCondition,
			LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy, int startIndex, int records);
}
