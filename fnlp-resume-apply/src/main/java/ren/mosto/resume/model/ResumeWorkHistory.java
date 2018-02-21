package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeWorkHistory<T> extends HasResumeId<T> {
    
    
    public String getCompanyName() ;

    public void setCompanyName(String companyName) ;

    public String getIndustryCategory() ;

    public void setIndustryCategory(String industryCategory) ;

    public String getEnterpriseSize() ;

    public void setEnterpriseSize(String enterpriseSize) ;

    public String getPosition() ;

    public void setPosition(String position) ;

    public Date getStartDate() ;

    public void setStartDate(Date startDate) ;

    public Date getEndDate() ;

    public void setEndDate(Date endDate) ;

    public String getSalary() ;

    public void setSalary(String salary) ;

    public String getEnterpriseNature() ;

    public void setEnterpriseNature(String enterpriseNature) ;

    public String getReferencePerson() ;

    public void setReferencePerson(String referencePerson) ;

    public String getDescription() ;

    public void setDescription(String description) ;

}
