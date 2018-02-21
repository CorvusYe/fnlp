package ren.mosto.resume.model;

import java.util.Date;

/**
 * Created by ye on 2017/11/19.
 */
public interface ResumeCertificate<T> extends HasResumeId<T> {

    String getName() ;

    void setName(String name) ;

    Date getGainTime() ;

    void setGainTime(Date gainTime) ;
}
