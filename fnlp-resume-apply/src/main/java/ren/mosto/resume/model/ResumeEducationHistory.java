package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeEducationHistory<T> extends HasResumeId<T> {
    
    public String getSchoolName() ;

    public void setSchoolName(String schoolName) ;

    public Date getStartDate() ;

    public void setStartDate(Date startDate) ;

    public Date getEndDate() ;

    public void setEndDate(Date endDate) ;

    public String getEducation() ;

    public void setEducation(String education) ;

    public String getIsUnify() ;

    public void setIsUnify(String isUnify) ;

    public String getMajorName() ;

    public void setMajorName(String majorName) ;

    public String getGpa() ;

    public void setGpa(String gpa) ;

    public String getRanking() ;

    public void setRanking(String ranking) ;

    public T getUniversityId() ;

    public void setUniversityId(T universityId) ;

    public String getMajorDesc() ;

    public void setMajorDesc(String majorDesc) ;
}
