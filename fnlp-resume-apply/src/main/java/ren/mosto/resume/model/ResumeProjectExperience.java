package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeProjectExperience<T> extends HasResumeId<T> {
    
    public String getProjectName() ;

    public void setProjectName(String projectName) ;

    public Date getStartDate() ;

    public void setStartDate(Date startDate) ;

    public Date getEndDate() ;

    public void setEndDate(Date endDate) ;

    public String getDuty() ;

    public void setDuty(String duty) ;

    public String getDescription() ;

    public void setDescription(String description) ;
}
