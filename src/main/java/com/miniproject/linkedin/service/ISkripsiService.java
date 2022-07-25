package com.miniproject.linkedin.service;

import java.util.List;

import com.miniproject.linkedin.model.SkripsiModel;

public interface ISkripsiService {

	int insert(SkripsiModel model);
	List<SkripsiModel> readAllData();
	List<SkripsiModel> readCustom();
	List<SkripsiModel> getEqTahun(Integer tahun);
	List<SkripsiModel> getGtTahun(Integer tahun);
	List<SkripsiModel> getLtTahun(Integer tahun);
	List<SkripsiModel> getNeTahun(Integer tahun);
	List<SkripsiModel> getLikeWord(String word);
	List<SkripsiModel> getByNilaiTahun(int tahun, int nilai);
	List<SkripsiModel> getAscExcptFirst(String key);
	int gantiNilai(Integer id, Integer nilai);
	int deleteById(int id);


}
