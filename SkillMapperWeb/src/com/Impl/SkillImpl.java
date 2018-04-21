package com.Impl;
import com.Model.*;
import java.util.*;
public interface SkillImpl {
	
	public String insertSkill(
			int emp_id,
			String skills,
			String certification,
			int teaching_hours,
			int trained_no_of_stdnts,
			int skill_rating,
			int no_of_stdns,
			int yrs_of_expr,
			String lang_known);
	public List<Skill> displaySkill();
	public String deleteSkill(int s);
	public int updateSkills(int empid, String status, String remarks);
	public List<Skill>  getSkillsByStatus();

}
