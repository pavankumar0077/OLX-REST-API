package com.olx.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertise;
import com.olx.service.AdvertiseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/advertise")
@CrossOrigin(origins = "*")
public class AdvertiseController {

	@Autowired
	AdvertiseService advertiseService;

	@PostMapping(value = "", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Post Advertisement", notes = "This REST API is used to post advertisements")
	public Advertise postAdvertise(@RequestHeader("auth-token") String authToken, Advertise adv) {
		return advertiseService.postAdvertise(adv);
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Update Advertisement", notes = "This REST API is used to update advertisements")
	public Advertise updateAdvertise(@RequestHeader("auth-token") String authToken, Advertise adv) {
		return advertiseService.updateAdvertise(adv);
	}

	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Reads all Advertisements", notes = "This REST API returns all Advertisements")
	public List<Advertise> getAllAdvByUser(@RequestHeader("auth-token") String authToken) {
		return advertiseService.getAllAdvByUser();
	}

	@DeleteMapping(value = "/advertise/{advertiseId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Delete Advertisement", notes = "This REST API is used to delete advetisement")
	public boolean deleteAdvertise(@RequestHeader("auth-token") String authToken, Advertise adv) {
		return advertiseService.deleteAdvertise(adv);
	}

	@GetMapping(value = "/search/filtercriteria", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Reads advertisements based on filter", notes = "This REST API returns all the advertisements on applied filter")
	public List<Advertise> searchAdvertisesByFilterCriteria(@RequestParam("searchText") String searchText,
			@RequestParam(name = "category", required = false) int categoryId,
			@RequestParam("postedBy") String postedBy, @RequestParam("dateCondition") String dateCondition,
			@RequestParam("onDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate onDate,
			@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
			@RequestParam("sortedBy") String sortedBy,
			@RequestParam(name = "startIndex", defaultValue = "0") int startIndex,
			@RequestParam(name = "records", defaultValue = "10") int records) {
		return advertiseService.searchAdvertisesByFilterCriteria(searchText, categoryId, postedBy, dateCondition,
				onDate, fromDate, toDate, sortedBy, startIndex, records);
	}

//	GetMapping(value="/search/filtercriteria", produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<AdvertiseDTO> searchAdvertisesByFilterCriteria(@RequestParam(name="searchText", required = false)String searchText,
//	@RequestParam(name = "category", required = false, defaultValue = "0")int categoryId, @RequestParam(name="postedBy", required=false)String postedBy,
//	@RequestParam(name="dateCondition", required=false)String dateCondition,
//	@RequestParam(name="onDate", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate onDate,
//	@RequestParam(name="fromDate", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
//	@RequestParam(name="toDate", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
//	@RequestParam(name="sortedBy", required=false)String sortedBy, @RequestParam(name = "startIndex", defaultValue="0")int startIndex, @RequestParam(name="records", defaultValue = "10")int records
//	) {
//	List<AdvertiseDTO> advertises = advertiseService.searchAdvertisesByFilterCriteria(searchText, categoryId, postedBy, dateCondition,
//	onDate, fromDate, toDate, sortedBy, startIndex, records);
//	return advertises;
//	}

	@GetMapping(value = "/{advertiseId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Reads all Advertisements by ID", notes = "This REST API returns All Advertisements by ID")
	public Advertise returnAdv(@RequestHeader("auth-token") String authToken, int id) {
		return advertiseService.returnAdv(id);
	}

	@GetMapping(value = "/advertise/search", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Reads all Advertisements by Search", notes = "This REST API returns Advertisements by Search")
	public Advertise SearchAdvByText(@RequestHeader("auth-token") String authToken, String searchText) {
		return advertiseService.SearchAdvByText(searchText);
	}

}
