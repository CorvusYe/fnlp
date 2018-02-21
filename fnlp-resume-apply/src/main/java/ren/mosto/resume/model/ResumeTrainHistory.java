package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeTrainHistory<T> extends HasResumeId<T> {
    
    public Date getStartTime() ;

    public void setStartTime(Date startTime) ;

    public Date getEndTime() ;

    public void setEndTime(Date endTime) ;

    public String getTrainCompany() ;

    public void setTrainCompany(String trainCompany) ;

    public String getPlace() ;

    public void setPlace(String place) ;

    public Integer getTrainTime() ;

    public void setTrainTime(Integer trainTime) ;

    public String getTrainName() ;

    public void setTrainName(String trainName) ;

    public String getCertificate() ;

    public void setCertificate(String certificate) ;

    public Date getCertificateTime() ;

    public void setCertificateTime(Date certificateTime) ;

    public String getDescribes() ;

    public void setDescribes(String describes) ;

    public Boolean getIsValid() ;

    public void setIsValid(Boolean isValid) ;
}
