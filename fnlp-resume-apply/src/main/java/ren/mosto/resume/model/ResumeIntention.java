package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeIntention<T> extends HasResumeId<T> { 
    
    public String getIntentionCity() ;

    public void setIntentionCity(String intentionCity) ;

    public Date getValidDate() ;

    public void setValidDate(Date validDate) ;

    public String getIntentionSalary() ;

    public void setIntentionSalary(String intentionSalary) ;

    public String getWorkState() ;

    public void setWorkState(String workState) ;

    public String getIntentionFunction() ;

    public void setIntentionFunction(String intentionFunction) ;

    public String getIntentionIndustry() ;

    public void setIntentionIndustry(String intentionIndustry) ;

    public String getPresentSalary() ;

    public void setPresentSalary(String presentSalary) ;

    public String getValidDateStr() ;

    public void setValidDateStr(String validDateStr) ;

    public String getIntentionPosition() ;

    public void setIntentionPosition(String intentionPosition) ;

    public String getFirstCity() ;

    public void setFirstCity(String firstCity) ;

    public String getSecondCity() ;

    public void setSecondCity(String secondCity) ;
}
