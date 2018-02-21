package ren.mosto.resume.model;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeFamily<T> extends HasResumeId<T> {

    public String getName() ;

    public void setName(String name) ;

    public String getFamilyTitle() ;

    public void setFamilyTitle(String familyTitle) ;

    public String getCompany() ;

    public void setCompany(String company) ;

    public String getPosition() ;

    public void setPosition(String position) ;

    public String getMobile() ;

    public void setMobile(String mobile) ;
}
