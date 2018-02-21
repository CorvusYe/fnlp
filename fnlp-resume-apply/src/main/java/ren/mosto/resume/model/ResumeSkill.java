package ren.mosto.resume.model;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeSkill<T> extends HasResumeId<T> {
    
    public String getName() ;

    public void setName(String name) ;

    public String getUseTime() ;

    public void setUseTime(String useTime) ;

    public String getMasterDegree() ;

    public void setMasterDegree(String masterDegree) ;

}
