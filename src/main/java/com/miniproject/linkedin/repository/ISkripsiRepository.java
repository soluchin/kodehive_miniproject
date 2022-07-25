package com.miniproject.linkedin.repository;

import java.util.List;

import com.miniproject.linkedin.model.SkripsiModel;

public interface ISkripsiRepository {
	public int insert(SkripsiModel model);
	public List<SkripsiModel> readAllData();
	public List<SkripsiModel> readCustom();
	public List<SkripsiModel> getEqTahun(Integer tahun);
	public List<SkripsiModel> getGtTahun(Integer tahun);
	public List<SkripsiModel> getLtTahun(Integer tahun);
	public List<SkripsiModel> getNeTahun(Integer tahun);
	public List<SkripsiModel> getLikeWord(String word);
	public List<SkripsiModel> getByNilaiTahun(int tahun, int nilai);
	public List<SkripsiModel> getAscExcptFirst(String key);
	public int gantinilai(Integer id, Integer nilai);
	public int deleteById(Integer id);
}
