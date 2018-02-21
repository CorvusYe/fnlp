package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeSchoolPost<T> extends HasResumeId<T> {
    
    public String getName() ;

    public void setName(String name) ;

    public Date getStartDate() ;

    public void setStartDate(Date startDate) ;

    public Date getEndDate() ;

    public void setEndDate(Date endDate) ;

    public String getDescription() ;

    public void setDescription(String description) ;

}
